package com.librarySystem.application.controllers;

import com.librarySystem.application.views.ViewManager;
import com.librarySystem.controller.BookController;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookCopyController {

	@FXML
	private Button saveAddBookCopyBtn;
	
	@FXML
	private TextField bookISBNTxt;
	
	@FXML
	private TextField bookAdditionalCopiesTxt;
	
	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		view.showTree(0, "");
	}
	
	// function to add a new Book copy
	public void saveAddBookCopy(ActionEvent event) throws Exception {
		
		ViewManager view = ViewManager.getInstance();
		
		if (!bookISBNTxt.getText().isEmpty() && !bookAdditionalCopiesTxt.getText().isEmpty()) {
			try {
				Integer.parseInt(bookAdditionalCopiesTxt.getText());
			} catch (Exception e) {
				view.showErrorAlert("Additional copies must be a number");
			}
			
			try {				
				BookController bookC = ControllerFactory.getController(Controller.Book);
				bookC.addNewCopy(bookISBNTxt.getText(), Integer.parseInt(bookAdditionalCopiesTxt.getText()));
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
			
		}
		else {
			view.showErrorAlert("Book Fields are mandatory...");
		}
	}
	
}
