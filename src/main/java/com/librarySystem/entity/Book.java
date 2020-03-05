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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    
    public static final int BORROW_DURATION__7 = 7;
    public static final int BORROW_DURATION__21 = 21;

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "isbn", unique = true)
	String isbn;
	
	@Column(name = "borrow_duration")
	int borrowDuration;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	List<Author> authors;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	List<BookCopy> bookCopyList;
	
	@Transient
	int bookCopies;

	public Book() {
	}

	public Book(String title, String isbn, List<Author> authors, List<BookCopy> bookCopyList, int borrowDuration) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.bookCopyList = bookCopyList;
		this.borrowDuration = borrowDuration;
	}

	public Book(String title, String isbn, List<Author> authors, int bookCopies) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.borrowDuration = 7;
		this.bookCopies = bookCopies;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<BookCopy> getBookCopyList() {
		return bookCopyList;
	}

	public void setBookCopyList(List<BookCopy> bookCopyList) {
		this.bookCopyList = bookCopyList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getBorrowDuration() {
		return borrowDuration;
	}

	public void setBorrowDuration(int borrowDuration) {
		this.borrowDuration = borrowDuration;
	}

	public int getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(int bookCopies) {
		this.bookCopies = bookCopies;
	}
	
	

//    @Override
//    public String toString() {
//        return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn
//                + ", borrowDuration=" + borrowDuration + ", authors=" + authors
//                + ", bookCopyList=" + bookCopyList + "]";
//    }

}
