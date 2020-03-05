package application.objectModel;

import java.util.Date;

public class CheckOutEntry {

	private double fine;
	private Date checkOutDate;
	private Date dueDate;
	private Date returnDate;
	
	private BookCopy bookCopy;
	private CheckOutRecord checkOutRecord;

	public CheckOutRecord getCheckOutRecord() {
		return checkOutRecord;
	}

	public void setCheckOutRecord(CheckOutRecord checkOutRecord) {
		this.checkOutRecord = checkOutRecord;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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
	
}
