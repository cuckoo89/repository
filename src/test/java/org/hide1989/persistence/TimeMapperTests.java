package org.hide1989.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.hide1989.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Setter(onMethod_ =@Autowired)
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	

}

//TimeMapperTests 클래스는 TimeMapper가 정상적으로 사용이 가능한지를 알아보기위한 테스트 코드입니다. 위의 코드가 정상적으로 동작한다면 스프링 내부에는
//TimeMapper 타입으로 만들어진 스프링 객체 빈 가 존재한다는 뜻이 됩니다.

// 위의 코드에서timeMapper.getClass().getName은 실제 동작하는 클래스의 이름을 확인해주는데 실행결과를 보면 개발시 인터페이스만 만들어 주었는데 내부적으로
//적당한 클래스가 ㅁ나들어진 것ㅇ르 확인할 수 있다.
//우선 여기서는 스프링이 인터페이스를 이용해서 객체를 생성한다는 사실에 주목해야한다. 테스트를 실행하면 아래와같은 로그가 기록되는것을 볼 수 있다.
//
