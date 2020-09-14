package org.hide1989.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data

public class SampleDTOList {
	
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list= new ArrayList<>();
	}

}
//JavaScript �� �̿��ϴ� ��쿡�� encodeURIComponent()�� ���� ������� �ذ��� �� ������ ���� ������ ����� %5B %5D �� �����Ѵ�.
//���� URL�� ȣ���ϸ� ���������� �������� Sample DTO ��ü�� �����ϴ°��� �� �� �ִ�.
//��µ� ����� ���� 3���� SampleDTO ��ü�� ������ �ͤ��� �� ���ְ�, [] �ȿ� �ε�����ȣ�� �°� ��ü�� �Ӽ����� ���õ� ���� Ȯ���� �� �ִ�.

//@initBinder
//�Ķ���� �������� �ٸ� ���δ� binding �̶�� �Ѵ�. ��ȯ�� ������ �����ʹ� �ڵ����� ��ȯ������ ��쿡���󼭴� �Ķ���͸� ��ȯ�ؼ� ó���ؾ��ϴ� ��쵵 �����Ѵ�.
//������� ȭ�餷���� 2018-01-01 �� ���� ���ڿ������޵� �����͸� java.util.Date Ÿ������ ��ȯ�ϴ� �۾��� �׷��ϴ�. ������ Controller ������ �Ķ���͸�
//���ε� ��  �� �ڵ����� ȣ��Ǵ� @InitBinder �� �̿��ؼ� �̷��� ��ȯ�� ó���� �� �ִ�.
//org.hide1989.domain ��Ű���� TodoDTO��� Ŭ������ �ۼ��Ѵ�.