package application.objectModel;

import java.util.List;

public class Member {
	
	private long memberId;
	private String firstName;
	private String lastName;
	private String addressStreet;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNo;
	
	private List<CheckOutRecord> checkOutRecords;
	
	public List<CheckOutRecord> getCheckOutRecords() {
		return checkOutRecords;
	}

	public void setCheckOutRecords(List<CheckOutRecord> checkOutRecords) {
		this.checkOutRecords = checkOutRecords;
	}

	public Member (String firstName, String lastName, String addressStreet, String city, String state, String zipCode, String phoneNo) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddressStreet(addressStreet);
		this.setCity(city);
		this.setState(state);
		this.setZipCode(zipCode);
		this.setPhoneNo(phoneNo);
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

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	
	
	
}
