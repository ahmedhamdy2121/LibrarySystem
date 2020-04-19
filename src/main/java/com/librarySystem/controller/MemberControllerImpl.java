package com.librarySystem.controller;

import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.librarySystem.dao.GenericDAOImpl;
import com.librarySystem.dao.MemberDao;
import com.librarySystem.dao.MemberDaoImpl;
import com.librarySystem.entity.Address;
import com.librarySystem.entity.CheckoutRecord;
import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public class MemberControllerImpl extends LibrarySystemImpl
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
        
        
        EntityTransaction et = GenericDAOImpl.getTransaction();
        try {
            et.begin();

            MemberDao mDao = new MemberDaoImpl();
            
            CheckoutRecord record = new CheckoutRecord();
            record.setMember(member);
            record.setTotalFine(0);
            
            member.setCheckoutRecord(record);
            Member updatedMember = mDao.add(member);

            et.commit();
            
            return updatedMember;
            
        } catch (IllegalStateException | RollbackException e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
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
        
        EntityTransaction et = GenericDAOImpl.getTransaction();
        try {
            et.begin();

            MemberDao mDao = new MemberDaoImpl();
            Member member = mDao.getByIndex(memberID);

            et.commit();
            
            return member;
            
        } catch (IllegalStateException | RollbackException e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
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
        
        EntityTransaction et = GenericDAOImpl.getTransaction();
        try {
            et.begin();
            
            MemberDao mDao = new MemberDaoImpl();
            
            Member oldMember = mDao.getByIndex(member.getId());
            Address oldAddress = member.getAddress();
            oldMember.setPhoneNumber(member.getPhoneNumber());
            oldAddress.setCity(member.getAddress().getCity());
            oldAddress.setState(member.getAddress().getState());
            oldAddress.setStreet(member.getAddress().getStreet());
            oldAddress.setZip(member.getAddress().getZip());
            oldMember.setPhoneNumber(member.getPhoneNumber());
            		
            Member updatedMember = mDao.update(oldMember);

            et.commit();
            
            return updatedMember;
            
        } catch (IllegalStateException | RollbackException e) {
            if (et != null)
                et.rollback();
            throw new LibrarySystemException("Error happened while dealing "
                            + "with the database!");
        }
    }
}
