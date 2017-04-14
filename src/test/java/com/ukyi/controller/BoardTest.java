package com.ukyi.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ukyi.domain.BoardVO;
import com.ukyi.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardTest {
	
	@Inject
	private BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardTest.class);
	
	
	@Test
	public void	testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("새글제목");
		board.setContent("새글내용");
		board.setWriter("새글작성자");
		dao.create(board);
	}
	
	@Test
	public void testRead() throws Exception{
		logger.info(dao.read(10).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(20);
		board.setTitle("수정된제목");
		board.setContent("수정된내용");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(3);
	}
}
