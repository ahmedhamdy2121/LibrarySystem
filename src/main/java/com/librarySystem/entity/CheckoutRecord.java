package com.librarySystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
	double totalFine;

	@OneToOne
	@JoinColumn(name = "member_id")
	Member member;

	@OneToMany(mappedBy = "checkoutRecord", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	List<CheckoutEntry> checkoutEntryList;

	public CheckoutRecord() {
	}

	public CheckoutRecord(int totalFine, Member member, List<CheckoutEntry> checkoutEntryList) {
		this.totalFine = totalFine;
		this.member = member;
		this.checkoutEntryList = checkoutEntryList;
	}
	
	@PrePersist
    public void prePersist() {
		if(checkoutEntryList != null && !checkoutEntryList.isEmpty()) {
			checkoutEntryList.forEach((entry) -> totalFine += entry.getFine());
		}
    }
 
    @PreUpdate
    public void preUpdate() {
    	if(checkoutEntryList != null && !checkoutEntryList.isEmpty()) {
			checkoutEntryList.forEach((entry) -> totalFine += entry.getFine());
		}
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalFine() {
		return totalFine;
	}

	public void setTotalFine(double totalFine) {
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

    @Override
    public String toString() {
        return "CheckoutRecord [id=" + id + ", totalFine=" + totalFine
                + ", member=" + member + ", checkoutEntryList="
                + checkoutEntryList + "]";
    }

}
