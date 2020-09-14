package org.hide1989.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data

public class TodoDTO {
	
	private String title;
	
	@DateTimeFormat(pattern ="yyyy/MM/dd")
	private Date dueDate;

}
//TodoDTO ���� Ư���ϰ� dueDate ������ Ÿ���� java.util.Date Ÿ���̴�. ���� ����ڰ�'2018-01-01' �� ���� ������ �����͸� ��ȯ�ϰ��� �Ҷ�
//�������߻��ϰ� �ȴ�. �̷��� ������ ������ �ذ�å�� @InitBinder�� �̿��ϴ� ���̴�.

//@DateTimePormat
//InitBinder �� �̿��ؼ� ��¥�� ��ȯ�� ���� ������, �Ķ���ͷ� ���Ǵ�  �ν��Ͻ� ������ @DateTimeFormat �� �����ص� �����ϴ�(@DateTimeFormat
//�� �̿��ϴ� ��쿡�� @InitBinder �� �ʿ����� �ʴ�.)
//ModelAttribute�� ������ ���޹��� �Ķ���͸� Model�� ��Ƽ� �����ϵ��� �� �� �ʿ��� ������̼��̴�. @ModelAttribute�� �ɸ� �Ķ���ʹ� Ÿ�Կ� �������
//������ Model�� ��Ƽ� ���޵ǹǷ�, �Ķ���ͷ� ���޵� �����͸� �ٽ� ȭ�鿡 ����ؤ����� ��쿡 �����ϰ� ���ȴ�.

//������ �ڵ忡�� int Ÿ���� �����Ͱ� ȭ����� ���޵��� �ʾ����Ƿ� @ModelAttribute�� �߰��ϸ� ��������ư ���°� �ȴ�.