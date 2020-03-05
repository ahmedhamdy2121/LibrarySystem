package com.librarySystem.dao;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Member;

public class MemberDaoImpl extends GenericDAOImpl<Member> implements MemberDao {
	
	@Override
	public void remove(long index) {
		em.remove(getByIndex(index));
	}

	@Override
	public Member getByIndex(long index) {
		return (Member) em.find(Member.class, index);
	}

}
