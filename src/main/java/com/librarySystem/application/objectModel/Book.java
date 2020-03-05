package application.objectModel;

import java.util.List;

public class Book {

	private String title;
	private String ISBN;
	private int availability;
	
	private List<BookCopy> bookCopies;
	
	public Book (String title, String ISBN, int availability) {
		this.setTitle(title);
		this.setISBN(ISBN);
		this.setAvailability(availability);
	}

	public String getTitle() {
		return title;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
}
