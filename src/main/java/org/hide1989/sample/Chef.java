package org.hide1989.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data

//�Ϲ������� ���������� ������ ������ Chef�� Ŭ������ �ƴ� �������̽��� �����ϴ� ���� ������, ������ �ּ����� �ڵ�
//�� ������ ������ �׽�Ʈ �غ��� ���� ���̹Ƿ� Ŭ������ �����Ѵ�.
public class Chef {

}
//Restaurant Ŭ������  Chef�� ���Թ޵��� �����Ѵ�. �̶� Lombok�� setter�� �����ϴ� ��ɰ� ������, toString()
//���� �ڵ����� �����ϵ��� @Data ������̼��� �̿��Ѵ�.