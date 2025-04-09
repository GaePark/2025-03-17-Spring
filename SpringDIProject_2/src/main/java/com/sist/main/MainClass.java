package com.sist.main;
/*
 * 스프링
 * 	=> 클래스 관리 영역
 * 	   --------- 컨테이너 클래스
 * 			BeanFactory
 * 				ㅣ
 * 			ApplicationContext => XML 클래스 등록
 * 				ㅣ-AnnotationConfigApplicationContext
 * 			WebApplicationContext
 * 		
 * 			** Component : 클래스 한개 (기능을 가지고 있는 클래스)
 * 						   JButton / JTextField
 * 						   ~Model / ~Manager / ~DAO => 부품
 * 						   => CPU / 메모리 / 하드디스크 ...
 * 			** container : 조립자 => 클래스관리하는 영역
 * 							=> 메인보드
 * 				ㅣ클래스 관리
 * 				  --------
 *                1) 객체 생성
 *                   <bean id="a" class="com.sist.main.A">
 *                     => Class clsName=Class.forName("com.sist.main.A")
 *                        Object obj=clsName.newInstance()
 *                        => map.put("a",obj) => 대기 상태
 *                2) 생성시에 멤버변수에 대한 초기화
 *                   ----------------------- DI
 *                   ㅣsetXxx() => setter DI
 *                   ㅣ생성자 매개변수 => constructor DI
 *                   ㅣ생성시 / 소멸시에 메소드 호출 => method DI
 *                3) 객체를 찾기 => DL => getBean()
 *                4) 객체 소멸
 *             ㅣ 방법 3개
 *                클래스 등록 / DI
 *                1) XML : 공통
 *                2) Annotaiion : 개별
 *                3) XML+Annotation=> 웹 / 실무
 *                   --- ----------
 *                   	 ㅣ사용자 정의 클래스
 *                   ㅣ프로젝트에서 공통 사용되는 부분 / 라이브러리 클래스
 *                                               -------------
 *                                               MyBatis / Transaction
 *            => 공통으로 사용되는 클래스나 메소드를 모아서 관리 : 공통모듈
 *               => com.sist.commons
 *               => 자동 호출이 가능 (AOP)
 *            => 웹 => MVC
 *               => 추가 (Task, Security / Batch / SI / Spring-Data)
 *            => 프레이워크 VS 라이브러리
 *               -------    --------
 *               ㅣ레고        완제품
 *               => 기본 동작을 위한 틀이 만들어져있다
 *               				 --
 *               	형식에 맞게 셋팅후 사용
 *                  --- XML / Annotation
 *                      ㅣ이미 태그가 만들어져 있따 (속성) => DTD/스키마
 *                  --- 라이브러리 추가 : pom.xml / gradle((spring-Boot)
 *            스프링에서 제공하는 라이브러리
 *              = spring-core : Container/DI
 *              = spring-aop : AOP => 공통모듈
 *              = spring-orm : Mybatis / JPA
 *              = spring-dao : JDBC
 *              = spring-web / spring-webmvc
 *            스프링 사용 목적
 *              = 생산성 => 라이브러리가 뛰어나다 / 신뢰성이 좋다 / 빠른 개발
 *              = 유지 보수성 / 확장성 => 다른 프로그램 언어와 연동
 *              = 유지 보수성 / 확장성 => 다른 프로그램 언어와 연동
 *              = 무료 / 스프링을 변경해서 사용이 가능
 *              = *** 현재 기술에 맞게 라이브러리가 제작되고 있다
 *                    --------AI / MSA...
 */			
public class MainClass {

}
