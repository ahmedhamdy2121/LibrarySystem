package application.controllers;

import application.views.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private Button loginBtn;
	
	@FXML
	private TextField userNameTxt;
	
	@FXML
	private TextField passwordTxt;
	
	public void login(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		String userName = userNameTxt.getText();
		String password = passwordTxt.getText();
		
		try {
			
			// TODO call controller for login method
			
			view.showTree(3, userName);
		} catch (Exception e) {
			view.showErrorAlert(e.getMessage());
		}
		
		// TODO to be removed
		if (userName.equals("mohamed") && password.equals("123456")) {
			view.showTree(3, userName);
		}
		else {
			view.showErrorAlert("Invalid Login");
		}
	}
	
}
