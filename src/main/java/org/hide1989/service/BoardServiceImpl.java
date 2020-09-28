package org.hide1989.service;

import java.util.List;

import org.hide1989.domain.BoardVO;
import org.hide1989.domain.Criteria;
import org.hide1989.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


	
	@Log4j
	@Service
	@AllArgsConstructor
	
	public class BoardServiceImpl implements BoardService {
		
		//spring 4.3 이상에서 자동 처리
		private BoardMapper mapper;
		
	   @Override
		public void register(BoardVO board) {
			// TODO Auto-generated method stub
		   
		   log.info("register..."+ board);
		   
		   mapper.insertSelectKey(board);
			
		}

		@Override
		public BoardVO get(Long bno) {
		log.info("get..." + bno);
		return mapper.read(bno);
		}

		@Override
		public boolean modify(BoardVO board) {
			// TODO Auto-generated method stub
			
			log.info("modify......"+board);
			return mapper.update(board) == 1;
		}

		@Override
		public boolean remove(Long bno) {
			// TODO Auto-generated method stub
			
			log.info("delete......"+ bno);
			return mapper.delete(bno) == 1;
		}

	/*
	 * @Override public List<BoardVO> getList() { // TODO Auto-generated method stub
	 * log.info("getList.....");
	 * 
	 * return mapper.getList(); }
	 */
		
		@Override
		public List<BoardVO> getList(Criteria cri) {
			// TODO Auto-generated method stub
			log.info("get List with criteria:" + cri);
			
			return mapper.getListWithPaging(cri);
		}
		
	}


