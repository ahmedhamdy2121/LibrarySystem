package com.librarySystem.controller;

import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public interface MemberController extends System {
    
    /**
     * 
     * @param member
     * @return false if operation not succeeded
     * @throws LibrarySystemException
     */
    public boolean createMember(Member member) throws LibrarySystemException;
    
    /**
     * 
     * @param memberID
     * @return null if member not found
     * @throws LibrarySystemException
     */
    public Member getMemberByID(String memberID) 
            throws LibrarySystemException;
    
    /**
     * 
     * @param member
     * @return false if operation not succeeded
     * @throws LibrarySystemException
     */
    public boolean editMember(Member member) throws LibrarySystemException;
}
