package com.ukyi.persistence;

import java.util.List;

import com.ukyi.domain.BoardVO;
import com.ukyi.domain.Criteria;

public interface BoardDAO {

	public void create(BoardVO vo)throws Exception;//게시글 등록
	public BoardVO read(int bno)throws Exception; //특정글 읽기
	public void update(BoardVO vo)throws Exception;//게시글 수정
	public void delete(int bno)throws Exception; //특정글 삭제
	public List<BoardVO> listAll()throws Exception; //전체글 조회
	public List<BoardVO> listCriteria(Criteria cri)throws Exception; //특정 페이지조회	
}