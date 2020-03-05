package com.librarySystem.application.controllers;

import java.util.ArrayList;
import java.util.List;

import com.librarySystem.application.views.ViewManager;
import com.librarySystem.controller.BookController;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;
import com.librarySystem.entity.Address;
import com.librarySystem.entity.Author;
import com.librarySystem.entity.Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookController {
	
	private List<Author> authorsList;
	
	@FXML
	private Button addAutherBtn;
	
	@FXML
	private Button saveAddBookBtn;
	
	@FXML
	private TextField bookTitleTxt;
	
	@FXML
	private TextField bookISBNTxt;
	
	@FXML
	private TextField bookAvailableTxt;
	
	@FXML
	private TextField autherFirstNameTxt;
	
	@FXML
	private TextField autherLastNameTxt;
	
	@FXML
	private TextField autherAddressStreetTxt;
	
	@FXML
	private TextField autherCityTxt;
	
	@FXML
	private TextField autherStateTxt;
	
	@FXML
	private TextField autherZipCodeTxt;
	
	@FXML
	private TextField autherPhoneNoTxt;
	
	@FXML
	private TextField autherShortBioTxt;
	
	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		this.authorsList.clear();
		view.showTree(0, "");
	}
	
	public void addAuther(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		
		if (!bookTitleTxt.getText().isEmpty() && !bookISBNTxt.getText().isEmpty() && !bookAvailableTxt.getText().isEmpty()) {
			try {
				Integer.parseInt(bookAvailableTxt.getText());
				this.authorsList = new ArrayList<Author>();
				autherFirstNameTxt.setDisable(false);
				autherLastNameTxt.setDisable(false);
				autherAddressStreetTxt.setDisable(false);
				autherCityTxt.setDisable(false);
				autherStateTxt.setDisable(false);
				autherZipCodeTxt.setDisable(false);
				autherPhoneNoTxt.setDisable(false);
				autherShortBioTxt.setDisable(false);
				saveAddBookBtn.setDisable(false);
				addAutherBtn.setDisable(true);
			} catch (Exception e) {
				view.showErrorAlert("Availability must be a number");
			}
		}
		else {
			view.showErrorAlert("Book fields are mandatory...");
		}
	}
	
	// function to add save the new Book
	public void saveAddBook(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		
		if (!autherFirstNameTxt.getText().isEmpty() && !autherLastNameTxt.getText().isEmpty() && !autherAddressStreetTxt.getText().isEmpty() && 
			!autherCityTxt.getText().isEmpty() && !autherStateTxt.getText().isEmpty() && 
			!autherZipCodeTxt.getText().isEmpty() && !autherPhoneNoTxt.getText().isEmpty() && !autherShortBioTxt.getText().isEmpty()) {
			bookTitleTxt.setDisable(true);
			bookISBNTxt.setDisable(true);
			bookAvailableTxt.setDisable(true);

			Address address = new Address(autherAddressStreetTxt.getText(), autherCityTxt.getText(), 
					autherStateTxt.getText(), autherZipCodeTxt.getText());
			
			Author author = new Author(autherFirstNameTxt.getText(), autherLastNameTxt.getText(), autherPhoneNoTxt.getText(), 
					autherShortBioTxt.getText(), address);
			
			this.authorsList.add(author);
			Book book = new Book(bookTitleTxt.getText(), bookISBNTxt.getText(), authorsList, Integer.parseInt(bookAvailableTxt.getText()));
			try {
				BookController bookC = ControllerFactory.getController(Controller.Book);
				bookC.addNewBook(book);		
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
			
			autherFirstNameTxt.setText("");
			autherLastNameTxt.setText("");
			autherAddressStreetTxt.setText("");
			autherCityTxt.setText("");
			autherStateTxt.setText("");
			autherZipCodeTxt.setText("");
			autherPhoneNoTxt.setText("");
			autherShortBioTxt.setText("");
			view.showNoteAlert("Data Saved Successfully");
		}
		else {
			view.showErrorAlert("Please fill all auther mandatory fields...");
		}
	}
	
}
