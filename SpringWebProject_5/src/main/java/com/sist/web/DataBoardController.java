package com.sist.web;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

/*
 * @GetMapping : 목록 출력 , 상세보기 => SELECT
 * 	default => 화면 출력
 *             <a> sendRedirect , location.href
 * @PostMapping : 입력값 INSERT
 * 				<form> ajax=> type:'post'
 *              axios
 * ----------------------------------------web에서는 두개만 사용
 * @PutMapping : 수정 UPDATE
 * @DeleteMapping : 삭제 DELETE
 * -------------- RestFul @RequestMapping
 */


/*
 *  1. DataBase 연동
 *  2. Web연동
 *  
 *  NodeJS
 *    ㅣ
 *  브라우저 <===> 자바 <====> 오라클
 *                ㅣ                                                                                                                                 
 *               파이썬
 *               C#
 *         DispatcherServlet = HandleMapping
 *                                 ㅣ
 *                               ViewResolver
 *                                 ㅣ
 *                                 JSP
 *             ㅣ
 *           동작하기 위한 작업 설정 (메뉴얼 직업)
 *                              ------------- XML
 *       1. 사용자가 요청한 데이터 읽기 => detail.do?no=10   
 *         <a> <form> ajax, axios
 *                           ㅣ vue,react,next
 *                     ㅣjquery
 *         *** detail.do
 *                     -------------
 *       2. DispatchServlet => HandlerMapping
 *                             --------------
 *                             ㅣ@RequestMapping
 *                             ㅣ@GetMapping
 *                             ㅣ@PostMapping
 *                              => 밑에 필요한 데이터를 JSP
 *                              -----------------------
 *                                     ㅣ=>interceptor(자동로그인)
 *                              ㅣJSP로 데이터를 전송
 *                                => 어떤 JSP로 전송 할지
 *                                	= return "main/main.jsp"
 *                                => 어떤 값을 전송 할지
 *                                	= request.setAttrubyte*(
 *                                  = model.addAttribute()
 *                                => 전송하는 클래스
 *                                  = ViewResolver
 *                                    ㅣ경로명 / 확장자
 *                                      ㅣ=>interceptor
 */
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class DataBoardController {
	@Autowired
	private DataBoardDAO dDAO;
	@Autowired
	private FileInfoDAO fDAO;
	
	@GetMapping("databoard/list.do")
	public String databoard_list(String page,Model model)
	{
		//request 대신 전송하는 객체 : Model
		/*
		 * 매개변수로 데이터를 받는 경우
		 * => 값이 없다 : String (null값이 들어온다)
		 * => 모든 값이 있는 경우 : 해당 데이터형
		 * 
		 * => 요청값을 받는 경우
		 *    --------------
		 *    1. 순서가 없다
		 *    2. 모든 요청값은 String으로 받을 수 있다.
		 *    3. 데이터변경 => 해당 데이터형
		 *    4. 커맨드 객체 => 여러개가 동시에 들어올때 => VO
		 *    5. List , String []
		 *                ㅣ동적쿼리
		 *        ㅣ파일 업로드
		 *    6. JSP 내장 객체를 받을 수 있다
		 *       HttpServletRequest
		 *       HttpServletResponse
		 *       HttpSession
		 *       RedirectAttributes
		 *       ServletContext => application => reaPath
 		 */
		/*
		 * 스프링 : 프레임워크
		 *         -------
		 *         미리 구현된 클래스의 집합
		 *         --------------------
		 *         ㅣ 기본 틀이 만들어져 있따
		 *            => 기본 틀에 맞게 구현
		 *                --------------
		 *                XML / Annotation
		 *                --- 태그와 속성이 스프링 동작에 맞게 만들어져 있다
		 *                    클래스 메모리 할당 => 객체 생성
		 *                    <bean>  : 클래스 한개 메모리 할당
		 *                    <context: component-scan> : 패키지 단위로 객체 생성
		 *                    ㅣ객체 생성 요청 /객체 생성 (X) => 인터페이스 , VO , 임시클래스 제외
		 *                       => 어노테이션으로 표시
		 *                           : 개발자 직접 제어 => VO, MainClass ...
		 *                           : 스프링이 관리 => DAO , Manager, Service, Model(Controller)
		 *                           : 가비지 컬렉션 => 필요없는 객체 메모리를 회수
		 *                              => 프로그램을 종료시에 => new / 필요없는 객체 소멸
		 *                              => 많이 사용하는 객체를 관리 => 생성 /소멸
		 *                              => 핵심 코딩만 사용
		 *                    ㅣ개발자의 수준 , 실력에 상관없이 일정 수준 개발이 가능
		 *                       => 형식이 동일하다
		 *                       => 마이바티스 , 스프링
		 *                         => SQL : 경우의 수 (JOIN, SUBQUERY , 문장 2개...)
		 *                    ㅣ초보자도 많은 시간을 투자할 피료가 없이 유지보수가 가능
		 *                    ㅣ무료 (오픈 소스) => 개발시간 단축 => MVC동작 기본들 => 기능만
		 *                      => Model (@Controller) , DAO , JSP
		 *                         -------------------   ----  --- 결과값 출력
		 *                                               데이터 관리
		 *                              ㅣ결과값을 전송
		 *                    ㅣ 기능이 많이 있따 => 학습하는 시간이 많이 걸린다
		 *                       => 버전 갱신이 자주 있다(3개월에 한번..)
		 *                    ㅣ 프로그램이 무겁다 => 속도가 저하
		 *                                       ---------
		 *                                       Jquery => 3 => 4, 5
		 *                    ㅣ LG / 한화 => Vue
		 *                    ㅣ 삼성 / 현대 => React
		 *                    ㅣ 금융권 / React
		 *                    ----------------------------------------
		 *                    1. DI (값 주입)
		 *                       => 스프링에서 객체를 생성 => 필요한 데이터가 있는 경우
		 *                          초기화
		 *                          = 명시적 초기화
		 *                            String driver="oracle...."
		 *                          = setter DI
		 *                            p:변수명=값
		 *                          = 생성자 DI
		 *                            c:매개변수명=값...
		 *                          = 객체 주소값 대입 : p:객체명-ref="id"
		 *                            -------------------------------
		 *                            @Autowired
		 *                    => 객체 생성
		 *                       @Componet => AOP , 일반 클래스 (~Manager)
		 *                       @Repository => DAO => 테이블 1개 제어
		 *                       @Service => BI => 관련된 DAO 여러개 한번에 제어
		 *                       @Controller : Model
		 *                                     => 화면 변경 => Router
		 *                       @RestController : Model
		 *                                   => 다른 프로그램과 연결
		 *                                   => JSON => JavaScript
		 *                       @ControllerAdvice : 공통 예외처리
		 *                        -----------------------------
		 *              AOP => 필요시마다 공통된 기능을 모아서 관리 => 자동 호출이 가능
		 *                     ㅣ소스 중복 제거 , 공통으로 적용 => 자동화 처리
		 *                     => 어떤 메소드에서 적용 ㅣ 메소드 어느 영역인지
		 *                        ---------------    ---------------
		 *                        ㅣPointCut           ㅣJoinPoint
		 *                                              @Before => aaa()
		 *                                              @After => bbb()
		 *                                              @After-Throw => ccc()
		 *                                              @After-Returning => ddd()
		 *                                              @Around => eee()
		 *                        ----------------------------------
		 *                         PointCut => execution("* 패키지.클래스명.메소드명(매개변수..)")
		 *                                                -- 리턴형       ----- * , 시작*
		 *                                                -- 매개변수 : ..
		 *                         => Controller에서 적용
		 *                         public String board_list(String page,Model model)
		 *                         {
		 *                         	@Before => 메소드 적용
		 *                         	try 
		 *                         	{
		 *                         		------------------- Around start => log
		 *                              소스코딩
		 *                              ------------------- Around end
		 *                         	} catch(Exception ex)
		 *                         	{
		 *                         		@After-Throwing
		 *                         		ccc()	
		 *                         	}
		 *                         	finally
		 *                         	{
		 *                         		@After
		 *                         		bbb()
		 *                         	}
		 *                         	return ""; @After-Returning
		 *                         }
		 *              ORM => MyBatis연동 / JSP연동
		 *                     ----------   ------
		 *                     				ㅣ자동화 (SQL문장을 자동을 ㅗ생성)
		 *                                  ㅣSQL + 자동화
		 *                                    public EmpVO findByEmpno (int empno)
		 *                                    => SELECT * FROM emp
		 *                                       WHERE empno = empno
		 *                     ㅣXML / Annotation / XML+Annotation
		 *                                         ---------------
		 *                                         SQL문장이 길거나 복잡한 SQL => XML
		 *                                         
		 *                                         	(<trim prefi=\"OR\" ...>")
		 *                                         
		 *              MVC
		 *                동작
		 *                브라우저 요청 => http://localhost:8080/web/databoard/list.do
		 *                
		 *                => 1. DispatcherServlet 요청을 받는다
		 *                   2. HandlerMapping에 전송
		 *                      ㅣdataboard/list.do
		 *                          ㅣ
		 *                       @GetMapping("databoard.list.do")=>if
		 *                       => 밑에 있는 메소드 호출
		 *                       => 전송값 => model.addAttribute()
		 *                       => 어떤 JSP로 전송 할지
		 *                          return "main/main"
		 *                           ㅣ
		 *                   3. ViewResolver 전송받은 ModelAndView
		 *                   
		 *                       
		 *                       
		 *                       
		 *                          = 
		 */
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		List<DataBoardVO> list = dDAO.boardListData((curpage*10)-9, curpage*10);
		int count = dDAO.boardRowCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((curpage*10)-10);
		//전송
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("count",count);
		return "databoard/list";
	}
	@GetMapping("databoard/insert.do")
	public String databoard_insert()
	{
		
		return "databoard/insert";
	}
	@PostMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo)
	{
		List<MultipartFile> list =vo.getFiles();
				
		System.out.println("전송된 파일 수:" + list.size());
		String path="c:\\download\\";
		try
		{
			if(list.size()==0)
			{
				vo.setFilecount(0);
			}
			else
			{
				vo.setFilecount(list.size());
				//업로드
				
			}
			System.out.println("cc");
			int no=dDAO.boardInsert(vo);
			//파일 저장 => 데이터베이스 전송
			FileInfoVO fvo = new FileInfoVO();
				if(list.size()>0)
				{
					for(MultipartFile mf:list)
					{
						String filename=mf.getOriginalFilename();
						File file=new File(path+filename);
						mf.transferTo(file);//업로드
						
						fvo.setFilename(filename);
						fvo.setFilesize(file.length());
						fvo.setNo(no);
						System.out.println("filename:"+filename);
						System.out.println("filesize:"+file.length());
						System.out.println("no:"+no);
						fDAO.boardFileInsert(fvo);
						System.out.println("aa");
					}
			
				}
				else {
					
				}
		}catch (Exception e) {
			System.out.println("??");
			// TODO: handle exception
		}
		return "redirect:../databoard/list.do";
	}
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no,Model model)
	{
		System.out.println(no);
		DataBoardVO vo = dDAO.databoardDetailData(no);
		List<FileInfoVO> list = fDAO.fileListData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		System.out.println(list);
		return "databoard/detail";
	}
	@GetMapping("databoard/download.do")
	public void download(String fn,HttpServletResponse response)
	{
		try {
			
		File file=new File("c:\\download\\"+fn);
		//1. 파일 크기 2. 파일명
		response.setContentLength((int)file.length());
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn,"UTF-8"));
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos= new BufferedOutputStream(response.getOutputStream());
		byte[] buffer=new byte[1024];
		int i=0;// 읽은 바이트수
		while((i=bis.read(buffer,0,1024))!=-1)
		{
			bos.write(buffer,0,i);
		}
		bis.close();
		bos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	//자신의 화면에서 작업이 되는 경우	String/void
	}
	@GetMapping("databoard/delete.do")
	public String databoard_delete(int no, Model model)
	{
		model.addAttribute("no",no);
		return "databoard/delete";
	}
	@GetMapping("databoard/update.do")
	public String databoard_update(int no,Model model)
	{
		DataBoardVO vo=dDAO.databoardUpdateData(no);
		model.addAttribute("vo",vo);
		return "databoard/update";
	}
	
	
}
