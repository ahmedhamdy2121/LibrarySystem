package com.librarySystem.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	long id;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "lastN_name")
	String lastName;

	@Column(name = "phone_number")
	String phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	Address address;

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	CheckoutRecord checkoutRecord;

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	BookCopy bookCopy;

	public Member() {
	}

	public Member(String firstName, String lastName, String phoneNumber, Address address,
			CheckoutRecord checkoutRecord, BookCopy bookCopy) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.checkoutRecord = checkoutRecord;
		this.bookCopy = bookCopy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    @Override
    public String toString() {
        return "Member [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", phoneNumber=" + phoneNumber + ", address="
                + address + ", checkoutRecord=" + checkoutRecord
                + ", bookCopy=" + bookCopy + "]";
    }

}
