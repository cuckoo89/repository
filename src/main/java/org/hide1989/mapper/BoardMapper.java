package org.hide1989.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.hide1989.domain.BoardVO;

public interface BoardMapper {
	
	//@Select ("select * from tbl_board1 where bno >0 ")
	public List<BoardVO> getList();
	
	public void insert (BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);

}
