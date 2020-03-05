package com.librarySystem.dao;

import com.librarySystem.entity.Book;
import com.librarySystem.entity.Member;

public interface MemberDao extends GenericDAO<Member>{
	
	public void remove(long index);

	public Member getByIndex(long index);

}
