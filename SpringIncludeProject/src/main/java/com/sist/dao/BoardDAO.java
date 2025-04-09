package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import java.sql.*;
@Repository
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public  BoardDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			getConnection();
			String sql = "SELECT no,subject,name,hit,regdate,group_tab,num "
					+ "FROM (SELECT no,subject,name,hit,regdate,group_tab,rownum as num "
					+ "FROM (SELECT no,subject,name,hit,regdate,group_tab "
					+ "FROM springreplyboard ORDER BY group_id DESC, group_step ASC))"
					+ "WHERE num BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1,start);
			ps.setInt(2,end);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setRegdate(rs.getDate(5));
				vo.setGroup_tab(rs.getInt(6));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
	//총페이지
	public int boardRowCount()
	{
		int total=0;
		try {
			getConnection();
			String sql= "SELECT COUNT(*) FROM springreplyboard";
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return total;
	}
	//insert /update / detail
	public void boardInsert(BoardVO vo)
	{
		try {
			getConnection();
			String sql = "INSERT INTO springreplyboard("
					+ "no,name,subject,content,pwd,group_id) "
					+ "VALUES(srb_no_seq.nextval,?,?,?,?,"
					+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
	}
	/*
	 NO	NUMBER
NAME	VARCHAR2(51 BYTE)
SUBJECT	VARCHAR2(2000 BYTE)
CONTENT	CLOB
PWD	VARCHAR2(10 BYTE)
REGDATE	DATE
HIT	NUMBER
GROUP_ID	NUMBER
GROUP_STEP	NUMBER
GROUP_TAB	NUMBER
ROOT	NUMBER
DEPTH	NUMBER
	 */
	/*
	 *  @Aspect
	 *  public class Transectional()
	 *  {
	 * 
	 *  }
	 */
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo = new BoardVO();
		try {
			getConnection();
			//around start
			conn.setAutoCommit(false);
			String sql="UPDATE springreplyboard SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			sql= "SELECT no,name,subject,content,regdate,hit FROM springreplyboard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
			//around end
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(Exception ex) {}
		}finally
		{
			try
			{
				conn.setAutoCommit(true);
			}catch(Exception e) {}
			disConnection();
		}
		return vo;
		
	}
	public BoardVO boardUpdateData(int no)
	{
		BoardVO vo = new BoardVO();
		try {
			getConnection();
			String sql= "SELECT no,name,subject,content,regdate,hit FROM springreplyboard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return vo;
		
	}
	
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck = false;
		try {
			getConnection();
			String sql = "SELECT pwd FROM springReplyboard "
					+ "WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();
			if(db_pwd.equals(vo.getPwd()))
			{
				bCheck=true;
				sql = "UPDATE springreplyboard SET "
						+ "name=?,subject=?,content=? "
						+ "WHERE no="+vo.getNo();
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.executeUpdate();
			}
		} catch (Exception e) {
		e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return bCheck;
	}
	//reply/delete=> 트랜잭션
	public void replyInsert(int pno,BoardVO vo)
	{
		try {
			getConnection();
			conn.setAutoCommit(false);
			//=> 상위 게시물에서 group_id,group_step,group_tab
			String sql= "SELECT group_id,group_step,group_tab "
					+ "FROM springreplyboard "
					+ "WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int gi=rs.getInt(1);
			int gs=rs.getInt(2);
			int gt=rs.getInt(3);
			rs.close();
			//=> group_step을 증가 (그룹별 출력 순서 변경
			sql="UPDATE springReplyboard SET "
					+ "group_step=group_step+1 "
					+ "WHERE group_id=? AND group_step>?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate();
			//=>insert
			sql="INSERT INTO "
					+ "springreplyboard(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
					+ "VALUES(srb_no_seq.nextval,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs+1);
			ps.setInt(7, gt+1);
			ps.setInt(8, pno);
			ps.executeUpdate();
			//= depth ++
			sql="UPDATE springReplyboard SET "
					+ "depth=depth+1 "
					+ "WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {}
		}finally
		{
			disConnection();
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public boolean boardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		try {
			getConnection();
			conn.setAutoCommit(false);
			//비밀번호 확인
			String sql="SELECT root,depth,pwd "
					+ "FROM springReplyBoard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int root=rs.getInt(1);
			int depth=rs.getInt(2);
			String db_pwd=rs.getString(3);
			ps=conn.prepareStatement(sql);
			if(db_pwd.equals(pwd))
			{
				bCheck=true;
				if(depth==0)
				{
					sql="DELETE FROM springReplyBoard "
							+ "WHERE no="+no;
					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
				}
				else
				{
					String msg="관리자가 삭제한 게시물입니다.";
					sql="UPDATE springreplyboard SET "
							+ "subject=?,content=?"
							+ "WHERE no = ?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, msg);
					ps.setString(2,msg);
					ps.setInt(3, no);
					ps.executeUpdate();
				}
				sql="UPDATE springreplyboard SET "
						+ "depth=depth-1 "
						+ "WHERE no="+root;
				ps=conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			
			//depth확인
			//=> 삭제 여부 depth=0 => 삭제 , update
			// => depth --
			conn.commit();
		}catch(Exception ex)
		{
			ex.printStackTrace();	
			try {
				conn.rollback();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}finally
		{
			try {
				conn.setAutoCommit(true);
			} catch (Exception e) {
				// TODO: handle exception
			}
			disConnection();
		}
		return bCheck;
	}
	
}
