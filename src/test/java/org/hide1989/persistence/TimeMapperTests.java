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
	
	@Test
	public void testGetTime2() {
		
		log.info("getTime2");
		log.info(timeMapper.getTime2());
	}

}

//TimeMapperTests 클래스는 TimeMapper가 정상적으로 사용이 가능한지를 알아보기위한 테스트 코드입니다. 위의 코드가 정상적으로 동작한다면 스프링 내부에는
//TimeMapper 타입으로 만들어진 스프링 객체 빈 가 존재한다는 뜻이 됩니다.

// 위의 코드에서timeMapper.getClass().getName은 실제 동작하는 클래스의 이름을 확인해주는데 실행결과를 보면 개발시 인터페이스만 만들어 주었는데 내부적으로
//적당한 클래스가 ㅁ나들어진 것ㅇ르 확인할 수 있다.
//우선 여기서는 스프링이 인터페이스를 이용해서 객체를 생성한다는 사실에 주목해야한다. 테스트를 실행하면 아래와같은 로그가 기록되는것을 볼 수 있다.
//MyBatis 를 이요해서 SQL을 처맇라 ㄸ ㅑㅐ어노테이션을 이용하는 방식이 압도적으로 편리하기는 하지만 SQL이 복잡하거나 길어지는 경우에는 어노테이션 보다는
// XML을 이용하는 방식을 더 선호하게 된다. 다행이도MyBatis-Spring 의 경우 Mapper 인터페이스와 XML을 동시에 이용할 수 있다.

//XML을 작성해서 사용할때에는 XML 파일의 위치와 XML 파일에 지정하는 namespace 속성이 중요한데 xml 파일의 위치의 경우 Mapper 인터페이스가 있는곳에 작성하거나
// 다음 그림처럼 src/main/resource 구조에 XML을저장할 폴더를 생성할 수 있다. xml 파일을 만들 때 이름에 대한 규칙은 없지만 ,가능하다면 Mapper 인터페이스
// 같은 이름을 이용하는 것이 가독성을 높여준다.

//src/main/resource 폴더 내 다음 그림과 같이 org 폴더와 hide1989 폴더,mapper 폴더를 만든다.(폴더를 생성할때 반드시 한 번에 하나씩 폴더를 생성한다)
//만일 한 번에 폴더를 만들면 제대로 인식이 되지 않는 문제가 발생할수 있으므로 주의한다.

//MyBatis는 내부적으로 JDBC의 PreparedStatement를 이용해서SQL 을 처리한다. 따라서  SQL 에 전달되는 파라미터는 JDBC에서와 같이 '?'로 치환되서 
//처리된다 .복잡한 SQL의 경우'?'로 나오는 값ㅇ ㅣ제대로 되었는지 확인하기가 쉽지 않고 실행된 SQL의 내용을 정확히 확인하기는 어렵다. 이런 문제를 해결하기 위해서 SQL
//을 변환해서 PreparedStatement 에 사용된 '?'가 어떤값으로 처리되었는지 확인하는 기능을 추가하도록 한다.SQL로ㅓ그를 제대로 보기 위해서는 log4jdbc
//-log4j2 라이브러리를 사용해야 한다.
//pom.xml 에 라이브러리를 설정한다.

//dataSource() 메서드에서 변경되는 부분은 JDBC 드라이버의 클래스를 'net.sf.log4jdbc.sql.jdbcapi.DriverSpy' 로수정하는 작업과
//JDBC 연결 URL 부분에서 중간에 'log4jdbc' 문자열이 추가되는 부분이다. 이 두 설정이 제대로 되어있지 ㅇ낳으면 데이터베이스의 로그가 정상적으로 기록되지 않는다.

// 설정을 변경한 후 기존의 테스트코드를 실행해보면 이전과는 달리 JDBC와 관련된 로그들이 출력되는 것을 볼 수 있습니다.

// 기본 설정의 로그는 info 레벨이기 때문에 warn 과같이 좀더 높은 레벨의 로그만 기록하게 수정하면 테스트코드를 실행할 때 이전에 비해 로그의 양이 줄어드는것을
// 확인할수 있다.