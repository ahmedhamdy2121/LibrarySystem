package com.librarySystem.controller;

import com.librarySystem.dao.MemberDao;
import com.librarySystem.dao.MemberDaoImpl;
import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public class MemberControllerImpl extends SystemImpl
        implements MemberController {

    @Override
    public Member createMember(Member member) throws LibrarySystemException {
        try {
            et.begin();

            MemberDao mDao = new MemberDaoImpl();
            Member updatedMember = mDao.add(member);

            et.commit();
            
            return updatedMember;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        }
    }

    @Override
    public Member getMemberByID(long memberID)
            throws LibrarySystemException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Member editMember(Member member) throws LibrarySystemException {
        // TODO Auto-generated method stub
        return null;
    }

}
