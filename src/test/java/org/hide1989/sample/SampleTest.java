package org.hide1989.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j



public class SampleTest {
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	   
	@Test
	public void testExist() {
		
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-------------------");
		log.info(restaurant.getChef());
		
		
	}

}

// 테스트코드는 우선 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 @Runwith 어노테이션으로 표시한다.
// 다음으로 가장 중요한 설정은 @ContextConfiguration 어노테이션과 속성값인 문자열 설정이다. @ContextConfiguration 은 지정된
// 클래스나 문자열을 이용해서 피ㅣㄹ요한 객체들을 스프링 객체로 등록하게 된다(흔히 스프링의 빈으로 등록된다고 표현하곤한다)
//@ContextConfiguration 에 사용하는 문자열은 'classpath:'나 'file'을 이용할 수 있으므로 이클립스에서 자동으로 생성된
// root-context.xml 경로를 지정할 수 있다.
//Log4j 는 Lombok 을 이용해서 로그를 기록하는 Logger를 변수로 생성한다. 별도의 Logger 객체의 선언 없이도Log4j 라이브러리와 설정이 존재한다면
// 바로 사용할 수 있다. 'Spring Legact Project'로 생성하는 경우 기본으로 Log4j 와 해당 설정이 완료되는 상태이기 때문에 별도의 처리 없이도
// 사용이 가능하다. 로그에 대한 설정은 src/main/resource와 src/test/resources 에 별도로 존재한다.
//@Autowired 는 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시이고, 스프링은 정상적으로 주입이 가능하다면 obj 변수에 Restaurant 타입의
// 객체를 주입하게된다 obj변수에 Restaurant 타입의 객체를 주입하게된다 testExit()에 선언되어있는 @Test는 JUnit 에서 테스트 대상을 표시하는 어노
// 테이션이다. 해당 메서드를 선택하고 JUnit 기능을 실행한다.
// assertNotNull()은 restaurant 변수가 null 이 아니어야만 테스트가 성공한다는 것을 의미한다. 테스트 작업은 프로젝트 초기에 설정해 두고 사용하는
// 습관을가지는것이 좋다.
// Run As>Junit Test를 실행해서 테스트 결과를 확인한다.

