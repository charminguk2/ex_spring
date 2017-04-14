package com.ukyi.service;

import java.util.List;

import com.ukyi.domain.BoardVO;
import com.ukyi.domain.Criteria;

public interface BoardService {
   //p185����
	
	public void regist(BoardVO board)throws Exception;//���(�Է�)
	public BoardVO read(int bno)throws Exception;//Ư�� ��ȸ
	public void modify(BoardVO board)throws Exception;//����
	public void remove(int bno)throws Exception;//����
	public List<BoardVO> listAll()throws Exception;//��ü ��ȸ
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;//Ư�� ������ ��ȸ
}
