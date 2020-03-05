package com.librarySystem.application.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class BookCheckOutEntries {
	
	private SimpleStringProperty title;
	private SimpleStringProperty ISBN;
	private LocalDate checkOutDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	
	public BookCheckOutEntries(String title, String ISBN, Date checkOutDate, Date dueDate, Date returnDate) {
		this.title = new SimpleStringProperty(title);
		this.ISBN = new SimpleStringProperty(ISBN);
		this.checkOutDate = checkOutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.dueDate = dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.returnDate = returnDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public String getTitle() {
		return title.get();
	}
	public void setTitle(SimpleStringProperty title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN.get();
	}
	public void setISBN(SimpleStringProperty iSBN) {
		this.ISBN = iSBN;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
}
