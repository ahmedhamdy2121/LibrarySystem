package application.objectModel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class BookOverdueList {

	private SimpleStringProperty copyNumber;
	private SimpleStringProperty memberId;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private LocalDate dueDate;
	
	public BookOverdueList(long copyNumber, long memberId, String firstName, String lastName, Date dueDate) {
		this.copyNumber = new SimpleStringProperty(String.valueOf(copyNumber));
		this.memberId = new SimpleStringProperty(String.valueOf(memberId));
		this.firstName = new SimpleStringProperty(String.valueOf(firstName));
		this.lastName = new SimpleStringProperty(String.valueOf(lastName));
		this.dueDate = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public String getCopyNumber() {
		return copyNumber.get();
	}
	public void setCopyNumber(SimpleStringProperty copyNumber) {
		this.copyNumber = copyNumber;
	}
	public String getMemberId() {
		return memberId.get();
	}
	public void setMemberId(SimpleStringProperty memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName.get();
	}
	public void setLastName(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
