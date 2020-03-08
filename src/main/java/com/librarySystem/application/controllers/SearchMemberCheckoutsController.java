package com.librarySystem.application.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.librarySystem.application.dto.BookCheckOutEntries;
import com.librarySystem.entity.BookCopy;
import com.librarySystem.entity.CheckoutEntry;
import com.librarySystem.entity.Member;
import com.librarySystem.application.views.ViewManager;
import com.librarySystem.controller.BookController;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchMemberCheckoutsController {

	private List<BookCheckOutEntries> bookEntriesList;

	@FXML
	private TextField memberIdTxt;

	@FXML
	private TextField firstNameTxt;

	@FXML
	private TextField lastNameTxt;

	@FXML
	private TextField streetTxt;

	@FXML
	private TextField cityTxt;

	@FXML
	private TextField stateTxt;

	@FXML
	private TextField zipCodeTxt;

	@FXML
	private TextField phoneNumberTxt;

	@FXML
	private TableView<BookCheckOutEntries> tableView;

	@FXML
	private TableColumn<BookCheckOutEntries, String> bookTitleColumn;

	@FXML
	private TableColumn<BookCheckOutEntries, String> bookISBNColumn;

	@FXML
	private TableColumn<BookCheckOutEntries, LocalDate> checkOutDateColumn;

	@FXML
	private TableColumn<BookCheckOutEntries, LocalDate> dueDateColumn;

	@FXML
	private TableColumn<BookCheckOutEntries, LocalDate> returnDateColumn;

	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		view.showTree(0, "");
	}

	// function to search for member checkouts
	public void searchMemberCheckouts() {

		ViewManager view = ViewManager.getInstance();

		if (!memberIdTxt.getText().isEmpty()) {

			try {
				BookController bookC = ControllerFactory.getController(Controller.Book);
				Member member = bookC.viewCheckoutRecord(Long.parseLong(memberIdTxt.getText()));

				firstNameTxt.setText(member.getFirstName());
				lastNameTxt.setText(member.getLastName());
				streetTxt.setText(member.getAddress().getStreet());
				cityTxt.setText(member.getAddress().getCity());
				stateTxt.setText(member.getAddress().getState());
				zipCodeTxt.setText(member.getAddress().getZip());
				phoneNumberTxt.setText(member.getPhoneNumber());

				bookTitleColumn.setCellValueFactory(new PropertyValueFactory<BookCheckOutEntries, String>("title"));
				bookISBNColumn.setCellValueFactory(new PropertyValueFactory<BookCheckOutEntries, String>("ISBN"));
				checkOutDateColumn
						.setCellValueFactory(new PropertyValueFactory<BookCheckOutEntries, LocalDate>("checkOutDate"));
				dueDateColumn.setCellValueFactory(new PropertyValueFactory<BookCheckOutEntries, LocalDate>("dueDate"));
				returnDateColumn
						.setCellValueFactory(new PropertyValueFactory<BookCheckOutEntries, LocalDate>("returnDate"));

				tableView.setItems(getCheckOutRecords(member));
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
		} else {
			view.showErrorAlert("Member ID is mandatory...");
		}
	}

	// function to get the chick out records from a member
	public ObservableList<BookCheckOutEntries> getCheckOutRecords(Member member) {

		ObservableList<BookCheckOutEntries> bookEntries = FXCollections.observableArrayList();
		bookEntriesList = new ArrayList<BookCheckOutEntries>();

		//for (CheckoutEntry entry : member.getCheckoutRecord().getCheckoutEntryList()) {
		for (int i =0; i<member.getCheckoutRecord().getCheckoutEntryList().size(); i+=2) {	
			CheckoutEntry entry = member.getCheckoutRecord().getCheckoutEntryList().get(i);
			BookCopy copy = entry.getBookCopy();
			
			Date returnDate = new Date();
			if (entry.getReturnDate() == null)
				returnDate = entry.getDueDate();
			else
				returnDate = entry.getReturnDate();
				
			BookCheckOutEntries bookCheckOutEntry = new BookCheckOutEntries(
					copy.getBook().getTitle(), copy.getBook().getIsbn(),
					entry.getCheckoutDate(), entry.getDueDate(), returnDate);
			
			bookEntries.add(bookCheckOutEntry);
			bookEntriesList.add(bookCheckOutEntry);
		}
		/*
		 * // TODO the below for loop will be removed for (int i=0; i<5; i++) {
		 * BookCheckOutEntries bookCheckOutEntry = new BookCheckOutEntries("Book title",
		 * "Book ISBN", new Date(), new Date(), new Date());
		 * bookEntries.add(bookCheckOutEntry); bookEntriesList.add(bookCheckOutEntry); }
		 */
		return bookEntries;
	}

	public void printMemberCheckouts() {

		String nameFormat = " %1$-20s |  %2$-20s |";
		String dateFormat = " %3$tb %3$td, %3$tY  |  %4$tb %4$td, %4$tY  | %5$tb %5$td, %5$tY  %n";
		String format = nameFormat.concat(dateFormat);

		for (BookCheckOutEntries bookEntry : this.bookEntriesList) {
			System.out.printf(format, bookEntry.getTitle(), bookEntry.getISBN(), bookEntry.getCheckOutDate(),
					bookEntry.getDueDate(), bookEntry.getReturnDate());
		}
	}

}
