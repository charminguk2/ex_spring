package com.ukyi.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ukyi.domain.BoardVO;
import com.ukyi.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
    //BoardDAOImpl��ü ���� : ����xml�� ������Ʈ�� ȣ�� ---> sql�� ����
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.ukyi.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return null;
	}
}





