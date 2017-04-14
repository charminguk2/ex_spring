package com.ukyi.persistence;

import java.util.List;

import com.ukyi.domain.BoardVO;
import com.ukyi.domain.Criteria;

public interface BoardDAO {

	public void create(BoardVO vo)throws Exception;//�Խñ� ���
	public BoardVO read(int bno)throws Exception; //Ư���� �б�
	public void update(BoardVO vo)throws Exception;//�Խñ� ����
	public void delete(int bno)throws Exception; //Ư���� ����
	public List<BoardVO> listAll()throws Exception; //��ü�� ��ȸ
	public List<BoardVO> listCriteria(Criteria cri)throws Exception; //Ư�� ��������ȸ	
}