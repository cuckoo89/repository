package org.hide1989.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data

public class Restaurant {
	
	
	@Setter(onMethod_=@Autowired)
	private Chef chef;

}

//�ۼ��� �ڵ尡 �ǹ��ϴ� ���� Restaurant ��ü�� Chef Ÿ���� ��ü�� �ʿ���Ѵٴ� ��Ȳ�̴�.
//@Component �� ���������� �ش� Ŭ������ ������������ �����ؾ��ϴ� ������� ǥ���ϴ� ������̼��̰�
//@Satter �� �ڵ����� setChef()�� ������ �� �����Ѵ�.

//Setter ���� ���� onMathod �Ӽ��� setChef()�� @Autowired ������̼��� �߰��ϵ��� �Ѵ�.Lombok���� ������ Ŭ������
//���� ������ ��Ŭ������ ���� Ȯ���� �� �ִ�.
