package com.librarySystem.application.controllers;

import com.librarySystem.application.views.ViewManager;
import com.librarySystem.controller.BookController;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CheckOutBookController {
	
	@FXML
	private Button checkOutBookBtn;
	
	@FXML
	private TextField bookISBNTxt;
	
	@FXML
	private TextField memberIdTxt;
	
	@FXML
	private TextField daysTxt;
	
	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		view.showTree(0, "");
	}
	
	public void checkOutBook(ActionEvent event) throws Exception {
		
		ViewManager view = ViewManager.getInstance();
		
		if (!bookISBNTxt.getText().isEmpty() && !memberIdTxt.getText().isEmpty() && !daysTxt.getText().isEmpty() && 
				("7".equals(daysTxt.getText()) || "21".equals(daysTxt.getText())) ){
			try {
				BookController bookC = ControllerFactory.getController(Controller.Book);
				bookC.checkoutBook(Long.parseLong(memberIdTxt.getText()), bookISBNTxt.getText());
				view.showNoteAlert("Checked out Successfully");
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
		}
		else {
			view.showErrorAlert("Book ISBN and Member ID are mandatory");
		}
	}

}
