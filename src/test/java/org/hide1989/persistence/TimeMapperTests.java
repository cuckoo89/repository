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

//TimeMapperTests Ŭ������ TimeMapper�� ���������� ����� ���������� �˾ƺ������� �׽�Ʈ �ڵ��Դϴ�. ���� �ڵ尡 ���������� �����Ѵٸ� ������ ���ο���
//TimeMapper Ÿ������ ������� ������ ��ü �� �� �����Ѵٴ� ���� �˴ϴ�.

// ���� �ڵ忡��timeMapper.getClass().getName�� ���� �����ϴ� Ŭ������ �̸��� Ȯ�����ִµ� �������� ���� ���߽� �������̽��� ����� �־��µ� ����������
//������ Ŭ������ ��������� �ͤ��� Ȯ���� �� �ִ�.
//�켱 ���⼭�� �������� �������̽��� �̿��ؼ� ��ü�� �����Ѵٴ� ��ǿ� �ָ��ؾ��Ѵ�. �׽�Ʈ�� �����ϸ� �Ʒ��Ͱ��� �αװ� ��ϵǴ°��� �� �� �ִ�.
//MyBatis �� �̿��ؼ� SQL�� ó���� �� ����������̼��� �̿��ϴ� ����� �е������� ���ϱ�� ������ SQL�� �����ϰų� ������� ��쿡�� ������̼� ���ٴ�
// XML�� �̿��ϴ� ����� �� ��ȣ�ϰ� �ȴ�. �����̵�MyBatis-Spring �� ��� Mapper �������̽��� XML�� ���ÿ� �̿��� �� �ִ�.

//XML�� �ۼ��ؼ� ����Ҷ����� XML ������ ��ġ�� XML ���Ͽ� �����ϴ� namespace �Ӽ��� �߿��ѵ� xml ������ ��ġ�� ��� Mapper �������̽��� �ִ°��� �ۼ��ϰų�
// ���� �׸�ó�� src/main/resource ������ XML�������� ������ ������ �� �ִ�. xml ������ ���� �� �̸��� ���� ��Ģ�� ������ ,�����ϴٸ� Mapper �������̽�
// ���� �̸��� �̿��ϴ� ���� �������� �����ش�.

//src/main/resource ���� �� ���� �׸��� ���� org ������ hide1989 ����,mapper ������ �����.(������ �����Ҷ� �ݵ�� �� ���� �ϳ��� ������ �����Ѵ�)
//���� �� ���� ������ ����� ����� �ν��� ���� �ʴ� ������ �߻��Ҽ� �����Ƿ� �����Ѵ�.

//MyBatis�� ���������� JDBC�� PreparedStatement�� �̿��ؼ�SQL �� ó���Ѵ�. ����  SQL �� ���޵Ǵ� �Ķ���ʹ� JDBC������ ���� '?'�� ġȯ�Ǽ� 
//ó���ȴ� .������ SQL�� ���'?'�� ������ ���� ������� �Ǿ����� Ȯ���ϱⰡ ���� �ʰ� ����� SQL�� ������ ��Ȯ�� Ȯ���ϱ�� ��ƴ�. �̷� ������ �ذ��ϱ� ���ؼ� SQL
//�� ��ȯ�ؼ� PreparedStatement �� ���� '?'�� ������� ó���Ǿ����� Ȯ���ϴ� ����� �߰��ϵ��� �Ѵ�.SQL�Τñ׸� ����� ���� ���ؼ��� log4jdbc
//-log4j2 ���̺귯���� ����ؾ� �Ѵ�.
//pom.xml �� ���̺귯���� �����Ѵ�.

//dataSource() �޼��忡�� ����Ǵ� �κ��� JDBC ����̹��� Ŭ������ 'net.sf.log4jdbc.sql.jdbcapi.DriverSpy' �μ����ϴ� �۾���
//JDBC ���� URL �κп��� �߰��� 'log4jdbc' ���ڿ��� �߰��Ǵ� �κ��̴�. �� �� ������ ����� �Ǿ����� �������� �����ͺ��̽��� �αװ� ���������� ��ϵ��� �ʴ´�.

// ������ ������ �� ������ �׽�Ʈ�ڵ带 �����غ��� �������� �޸� JDBC�� ���õ� �α׵��� ��µǴ� ���� �� �� �ֽ��ϴ�.

// �⺻ ������ �α״� info �����̱� ������ warn ������ ���� ���� ������ �α׸� ����ϰ� �����ϸ� �׽�Ʈ�ڵ带 ������ �� ������ ���� �α��� ���� �پ��°���
// Ȯ���Ҽ� �ִ�.