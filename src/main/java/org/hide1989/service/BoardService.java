package org.hide1989.service;

import java.util.List;

import org.hide1989.domain.BoardVO;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify (BoardVO board);
	
	public boolean remove (Long bno);
	
	public List<BoardVO> getList();

}
