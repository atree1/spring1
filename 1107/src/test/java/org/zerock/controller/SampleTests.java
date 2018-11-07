package org.zerock.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.config.RootConfig;
import org.zerock.mapper.TimeMapper;
import org.zerock.service.SampleBean;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class SampleTests {
	
	@Setter(onMethod_=@Autowired)
	private SampleBean bean;
	
	@Setter(onMethod_=@Autowired)
	private DataSource ds;
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper mapper;
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
	@Test
	public void testCon() {
		try(Connection con=ds.getConnection();) {
			
			log.info(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testExist() {
		log.info("------------------------");
		log.info("------------------------");
		log.info(bean);
		log.info("------------------------");
		log.info("------------------------");
	}
  	
	@Test
	public void testTransaction() {
		log.info("------------------------");
		log.info("------------------------");
		bean.doB("2지하철 전자책 체험관은 경의중앙선 다.서울 홍대입구역 맞이방에서 운영하며 전용 단말기로 2018년 대한민국 전자출판대상 수상작을 포함한 전자책을 무료로 읽을 수 있\r\n" );
		log.info("------------------------");
		log.info("------------------------");
	}
}
