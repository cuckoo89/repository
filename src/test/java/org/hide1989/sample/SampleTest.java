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

// �׽�Ʈ�ڵ�� �켱 ���� �׽�Ʈ �ڵ尡 �������� �����ϴ� ������ �� ���̶�� ���� @Runwith ������̼����� ǥ���Ѵ�.
// �������� ���� �߿��� ������ @ContextConfiguration ������̼ǰ� �Ӽ����� ���ڿ� �����̴�. @ContextConfiguration �� ������
// Ŭ������ ���ڿ��� �̿��ؼ� �ǤӤ����� ��ü���� ������ ��ü�� ����ϰ� �ȴ�(���� �������� ������ ��ϵȴٰ� ǥ���ϰ��Ѵ�)
//@ContextConfiguration �� ����ϴ� ���ڿ��� 'classpath:'�� 'file'�� �̿��� �� �����Ƿ� ��Ŭ�������� �ڵ����� ������
// root-context.xml ��θ� ������ �� �ִ�.
//Log4j �� Lombok �� �̿��ؼ� �α׸� ����ϴ� Logger�� ������ �����Ѵ�. ������ Logger ��ü�� ���� ���̵�Log4j ���̺귯���� ������ �����Ѵٸ�
// �ٷ� ����� �� �ִ�. 'Spring Legact Project'�� �����ϴ� ��� �⺻���� Log4j �� �ش� ������ �Ϸ�Ǵ� �����̱� ������ ������ ó�� ���̵�
// ����� �����ϴ�. �α׿� ���� ������ src/main/resource�� src/test/resources �� ������ �����Ѵ�.
//@Autowired �� �ش� �ν��Ͻ� ������ ���������κ��� �ڵ����� ������ �޶�� ǥ���̰�, �������� ���������� ������ �����ϴٸ� obj ������ Restaurant Ÿ����
// ��ü�� �����ϰԵȴ� obj������ Restaurant Ÿ���� ��ü�� �����ϰԵȴ� testExit()�� ����Ǿ��ִ� @Test�� JUnit ���� �׽�Ʈ ����� ǥ���ϴ� ���
// ���̼��̴�. �ش� �޼��带 �����ϰ� JUnit ����� �����Ѵ�.
// assertNotNull()�� restaurant ������ null �� �ƴϾ�߸� �׽�Ʈ�� �����Ѵٴ� ���� �ǹ��Ѵ�. �׽�Ʈ �۾��� ������Ʈ �ʱ⿡ ������ �ΰ� ����ϴ�
// �����������°��� ����.
// Run As>Junit Test�� �����ؼ� �׽�Ʈ ����� Ȯ���Ѵ�.

