package com.librarySystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_copy")
public class BookCopy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	long id;
	
	@Column(name = "unique_copy_number")
	String uniqueCopyNumber;

	@Column(name = "due_date")
	Date dueDate;

	@Column(name = "is_available")
	boolean isAvailable;

	@OneToOne
	@JoinColumn(name = "member_id")
	Member member;

	@ManyToOne
	Book book;

	public BookCopy() {
	}

	public BookCopy(long id, Date dueDate, boolean isAvailable, Member member, Book book, String uniqueCopyNumber) {
		super();
		this.id = id;
		this.dueDate = dueDate;
		this.isAvailable = isAvailable;
		this.member = member;
		this.book = book;
		this.uniqueCopyNumber = uniqueCopyNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUniqueCopyNumber() {
		return uniqueCopyNumber;
	}

	public void setUniqueCopyNumber(String uniqueCopyNumber) {
		this.uniqueCopyNumber = uniqueCopyNumber;
	}
	
	

}
