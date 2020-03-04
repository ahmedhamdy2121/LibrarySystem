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
@Table(name = "checkout_entry")
public class CheckoutEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	long id;

	@Column(name = "fine")
	double fine;

	@Column(name = "due_date")
	Date dueDate;

	@Column(name = "checkout_Date")
	Date checkoutDate;

	@Column(name = "return_date")
	Date returnDate;

	@OneToOne
	@JoinColumn(name = "copy_id")
	BookCopy bookCopy;

	@ManyToOne
	CheckoutRecord checkoutRecord;

	public CheckoutEntry() {
	}

	public CheckoutEntry(double fine, Date dueDate, Date checkoutDate, Date returnDate, BookCopy bookCopy) {
		this.fine = fine;
		this.dueDate = dueDate;
		this.checkoutDate = checkoutDate;
		this.returnDate = returnDate;
		this.bookCopy = bookCopy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
