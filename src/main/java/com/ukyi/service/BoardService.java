package com.ukyi.service;

import java.util.List;

import com.ukyi.domain.BoardVO;
import com.ukyi.domain.Criteria;

public interface BoardService {
   //p185설명
	
	public void regist(BoardVO board)throws Exception;//등록(입력)
	public BoardVO read(int bno)throws Exception;//특정 조회
	public void modify(BoardVO board)throws Exception;//수정
	public void remove(int bno)throws Exception;//삭제
	public List<BoardVO> listAll()throws Exception;//전체 조회
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;//특정 페이지 조회
}
