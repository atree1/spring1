package org.zerock.mapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
	
	PageParam pageParam=new PageParam();
	
	log.info(mapper.count(pageParam));
	}
}
