package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Board;
import org.zerock.domain.PageParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests{

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testInsert() {
		Board board=new Board();
		board.setTitle("영준이형 나이는?");
		board.setContent("30살");
		board.setWriter("MR.J");
		
		log.info(mapper.insert(board));
	}
	@Test
	public void testAll() {
		//log.info(mapper.getListAll());
		PageParam pageParam=new PageParam();
		pageParam.setPage(3);
		mapper.getList(pageParam).forEach(board->log.info(board));
	}
}
