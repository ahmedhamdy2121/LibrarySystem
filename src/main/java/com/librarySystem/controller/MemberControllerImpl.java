package com.librarySystem.controller;

import com.librarySystem.dao.GenericDAOImpl;
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
        
        // validation
        if (member == null)
            throw new LibrarySystemException("Member is null");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.ADMIN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
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
        } finally{
            GenericDAOImpl.close();
        }
    }

    @Override
    public Member getMemberByID(long memberID)
            throws LibrarySystemException {

        // validation
        if (memberID < 0)
            throw new LibrarySystemException("Member ID can't be negative");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.LIBRARIAN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();

            MemberDao mDao = new MemberDaoImpl();
            Member member = mDao.getByIndex(memberID);

            et.commit();
            
            return member;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        } finally{
            GenericDAOImpl.close();
        }
    }

    @Override
    public Member editMember(Member member) throws LibrarySystemException {
        
        // validation
        if (member == null)
            throw new LibrarySystemException("Member is null");
        if (! (currentLoggedUser != null 
                && (currentLoggedUser.getPermissions() 
                        == Privilege.ADMIN.getValue() 
                || currentLoggedUser.getPermissions() 
                        == Privilege.BOTH.getValue())))
            throw new LibrarySystemException("Current logged user doen't have "
                    + "the privilege to execute this function");
        
        try {
            et.begin();

            MemberDao mDao = new MemberDaoImpl();
            Member updatedMember = mDao.update(member);

            et.commit();
            
            return updatedMember;
            
        } catch (Exception e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        } finally{
            GenericDAOImpl.close();
        }
    }

}
