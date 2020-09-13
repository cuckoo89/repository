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
//���������� root-context.xml �� �������� �ε��Ǹ鼭 �о���̴� �����̹Ƿ�, �ַ� �̹� ������� Ŭ�������� �̿��ؼ� �������� ������ ����� �� ���ȴ�. �Ϲ�
//���� ��Ȳ�̶�� ������Ʈ�� ���� �ۼ��ϴ� Ŭ�������� ������̼��� �̿��ϴ� ��찡 ����, �ܺ� jar ���� ������ ����ϴ� Ŭ�������� <bean> �±׸� �̿��ؼ� �ۼ��ϴ�
//��찡 ��κ��̴�. �������� ���۵Ǹ�  root-context.xml �� �о �Ʒ��Ͱ��� ���·� id�� dataSource�� ��ü�� ó���ȴ�.

//�ʱ⿡ ������������ ������ ���� �ʴٸ� ���Ͱ��� ���� ������ ������ �׻� �׽�Ʈ�� �ۼ��ϴ� ������ �����°��� ���� src/test/java �� DataSourceTestsŬ����
//�� �ۼ��Ѵ�. �׽�Ʈ �ڵ�� �������� ������ ��ϵ� DataSource �� �̿��ؼ� Connection �� ����� ó���� �� �ִ��� Ȯ���� ���� �뵵�̴�. testConnection
//�������� ���� ���������� HikariCP�� ���۵ǰ�, ����Ǵ� �α׸� Ȯ���� �� �ִ�.
