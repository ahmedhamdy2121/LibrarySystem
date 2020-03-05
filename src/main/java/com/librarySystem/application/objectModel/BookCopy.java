package application.objectModel;

import java.util.Date;

public class BookCopy {
	
	private long copyNumber;
	private Date dueDate;
	private boolean isAvailable;
	
	private Book book;
	private Member member;
	
	public long getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(long copyNumber) {
		this.copyNumber = copyNumber;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
