package application.controllers;

import application.views.ViewManager;
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
				
				// TODO call controller add book copy method
				
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
			
		}
		else {
			view.showErrorAlert("Book Fields are mandatory...");
		}
	}
	
}
