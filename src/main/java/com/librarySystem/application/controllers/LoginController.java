package com.librarySystem.application.controllers;

import com.librarySystem.application.views.ViewManager;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;
import com.librarySystem.controller.CredentialController;
import com.librarySystem.entity.Person;

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
			CredentialController loginC = ControllerFactory.getController(Controller.Credential);
			Person person = loginC.login(userName, password);
			view.showTree(person.getPermissions(), userName);
		} catch (Exception e) {
			view.showErrorAlert(e.getMessage());
		}
	}
	
}
