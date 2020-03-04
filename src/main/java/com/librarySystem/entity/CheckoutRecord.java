package com.librarySystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "checkout_record")
public class CheckoutRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	long id;

	@Column(name = "total_fine")
	int totalFine;

	@OneToOne
	@JoinColumn(name = "member_id")
	Member member;

	@OneToMany(mappedBy = "checkoutRecord", cascade = CascadeType.ALL, orphanRemoval = true)
	List<CheckoutEntry> checkoutEntryList;

	public CheckoutRecord() {
	}

	public CheckoutRecord(long id, int totalFine, Member member, List<CheckoutEntry> checkoutEntryList) {
		super();
		this.id = id;
		this.totalFine = totalFine;
		this.member = member;
		this.checkoutEntryList = checkoutEntryList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTotalFine() {
		return totalFine;
	}

	public void setTotalFine(int totalFine) {
		this.totalFine = totalFine;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<CheckoutEntry> getCheckoutEntryList() {
		return checkoutEntryList;
	}

	public void setCheckoutEntryList(List<CheckoutEntry> checkoutEntryList) {
		this.checkoutEntryList = checkoutEntryList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
