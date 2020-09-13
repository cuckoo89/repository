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

//TimeMapperTests Ŭ������ TimeMapper�� ���������� ����� ���������� �˾ƺ������� �׽�Ʈ �ڵ��Դϴ�. ���� �ڵ尡 ���������� �����Ѵٸ� ������ ���ο���
//TimeMapper Ÿ������ ������� ������ ��ü �� �� �����Ѵٴ� ���� �˴ϴ�.

// ���� �ڵ忡��timeMapper.getClass().getName�� ���� �����ϴ� Ŭ������ �̸��� Ȯ�����ִµ� �������� ���� ���߽� �������̽��� ����� �־��µ� ����������
//������ Ŭ������ ��������� �ͤ��� Ȯ���� �� �ִ�.
//�켱 ���⼭�� �������� �������̽��� �̿��ؼ� ��ü�� �����Ѵٴ� ��ǿ� �ָ��ؾ��Ѵ�. �׽�Ʈ�� �����ϸ� �Ʒ��Ͱ��� �αװ� ��ϵǴ°��� �� �� �ִ�.
//
