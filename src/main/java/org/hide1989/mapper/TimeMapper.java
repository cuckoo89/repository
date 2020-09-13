package org.hide1989.mapper;

import org.apache.ibatis.annotations.Select;


public interface TimeMapper {
	
	@Select("Select sysdate FROM dual")
	public String getTime();
	
	public String getTime2();

}
//Mapper�� �ۼ��ϴ� �۾��� XML�� �̿��� ���� ������, �̹����� �ּ����� �ڵ带 �ۼ��ϴ� Mapper �������̽��� ����Ѵ�.
//org.hide1989.mapper ��� ��Ű���� �����, TimeMapper��� �������̽��� �߰��Ѵ�. 
//TimeMapper �������̽����� MyBatis�� ������̼��� �̿��ؼ� SQL �� �޼��忡 �߰��Ѵ�.
//Mapper�� �ۼ��� �־��ٸ� MyBatis�� �����Ҷ� Mapper�� �̽��� ���� �ֵ��� root-context.xml�� �߰����� ������ �ʿ��ϴ�. ���� ������ �����
//<mybatis:scan> dlfksms xormfmf dldydgksms rjtdlek. root-context.xml������ ����. �Ʒ�����  Namespaces �׸񿡼� 
//mybatis-spring ���� �����Ѵ�.