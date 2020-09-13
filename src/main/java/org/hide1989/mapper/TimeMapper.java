package org.hide1989.mapper;

import org.apache.ibatis.annotations.Select;


public interface TimeMapper {
	
	@Select("Select sysdate FROM dual")
	public String getTime();
	
	public String getTime2();

}
//Mapper를 작성하는 작업은 XML을 이용할 수도 있지만, 이번에는 최소한의 코드를 작성하는 Mapper 인터페이스를 사용한다.
//org.hide1989.mapper 라는 패키지를 만들고, TimeMapper라는 인터페이스를 추가한다. 
//TimeMapper 인터페이스에는 MyBatis의 어노테이션을 이용해서 SQL 을 메서드에 추가한다.
//Mapper를 작성해 주었다면 MyBatis가 동작할때 Mapper를 이식할 ㄸ수 있도록 root-context.xml에 추가적인 설정이 필요하다. 가장 간단한 방식은
//<mybatis:scan> dlfksms xormfmf dldydgksms rjtdlek. root-context.xml파일을 열고. 아래쪽의  Namespaces 항목에서 
//mybatis-spring 텝을 선택한다.