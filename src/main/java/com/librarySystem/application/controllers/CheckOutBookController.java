package application.controllers;

import application.views.ViewManager;
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
	
	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		view.showTree(0, "");
	}
	
	public void checkOutBook(ActionEvent event) throws Exception {
		
		ViewManager view = ViewManager.getInstance();
		
		if (!bookISBNTxt.getText().isEmpty() && !memberIdTxt.getText().isEmpty()) {
			try {
				
				// TODO call controller add book copy method
				
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
		}
		else {
			view.showErrorAlert("Book ISBN and Member ID are mandatory");
		}
	}

}
