package org.hide1989.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
public class DataSourceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection();
				){
			log.info(session);
			log.info(con);
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConnection() {
		
		try (Connection con= dataSource.getConnection()){
			log.info(con);
			
		}catch(Exception e){
			fail(e.getMessage());
			
		}
	}

}
//스프링에서 root-context.xml 은 스프링이 로딩되면서 읽어들이는 문서이므로, 주로 이미 만들어진 클래스들을 이용해서 스프링의 빈으로 등록할 때 사용된다. 일반
//적인 상황이라면 프로젝트에 직접 작성하는 클래스들은 어노테이션을 이용하는 경우가 많고, 외부 jar 파일 등으로 사용하는 클래스들은 <bean> 태그를 이용해서 작성하는
//경우가 대부분이다. 스프링이 시작되면  root-context.xml 을 읽어서 아래와같은 형태로 id가 dataSource인 객체가 처리된다.

//초기에 스프링에대한 경험이 많지 않다면 위와같이 빈은 정의한 다음에 항상 테스트를 작성하는 습관을 가지는것이 좋다 src/test/java 에 DataSourceTests클래스
//를 작성한다. 테스트 코드는 슬프링에 빈으로 등록된 DataSource 를 이용해서 Connection 을 제대로 처리할 수 있는지 확인해 보는 용도이다. testConnection
//을실행해 보면 내부적으로 HikariCP가 시작되고, 종료되는 로그를 확인할 수 있다.
