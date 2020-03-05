package com.librarySystem.controller;

import com.librarySystem.entity.Member;

/**
 * @author ahmed hamdy
 *
 */
public interface MemberController extends LibrarySystem {
    
    /**
     * 
     * @param member
     * @return null if member is not added
     * @throws LibrarySystemException
     */
    public Member createMember(Member member) throws LibrarySystemException;
    
    /**
     * 
     * @param memberID
     * @return null if member not found
     * @throws LibrarySystemException
     */
    public Member getMemberByID(long memberID) 
            throws LibrarySystemException;
    
    /**
     * 
     * @param member
     * @return null if operation not succeeded
     * @throws LibrarySystemException
     */
    public Member editMember(Member member) throws LibrarySystemException;
}
