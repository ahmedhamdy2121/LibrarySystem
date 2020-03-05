package com.librarySystem.application.controllers;

import com.librarySystem.entity.Member;
import com.librarySystem.application.views.ViewManager;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;
import com.librarySystem.controller.MemberController;
import com.librarySystem.entity.Address;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddMemberController {
	
	@FXML
	private TextField memberFirstNameTxt;
	
	@FXML
	private TextField memberLastNameTxt;
	
	@FXML
	private TextField memberAddressStreetTxt;
	
	@FXML
	private TextField memberCityTxt;
	
	@FXML
	private TextField memberStateTxt;
	
	@FXML
	private TextField memberZipCodeTxt;
	
	@FXML
	private TextField memberPhoneNoTxt;
	
	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		view.showTree(0, "");
	}
	
	// function to add save the new Member
	public void saveAddMember(ActionEvent event) throws Exception {
		
		ViewManager view = ViewManager.getInstance();
		
		if (!memberFirstNameTxt.getText().isEmpty() && !memberLastNameTxt.getText().isEmpty() && !memberAddressStreetTxt.getText().isEmpty() && 
				!memberCityTxt.getText().isEmpty() && !memberStateTxt.getText().isEmpty() && 
				!memberZipCodeTxt.getText().isEmpty() && !memberPhoneNoTxt.getText().isEmpty()) {
			
			Address address = new Address(memberAddressStreetTxt.getText(), memberCityTxt.getText(), 
					memberStateTxt.getText(), memberZipCodeTxt.getText());
			
			Member member = new Member(memberFirstNameTxt.getText(), memberLastNameTxt.getText(), memberPhoneNoTxt.getText(), address);
			
			try {				
				MemberController memberC = ControllerFactory.getController(Controller.Member);
				member = memberC.createMember(member);				
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
			
			memberFirstNameTxt.setText("");
			memberLastNameTxt.setText("");
			memberAddressStreetTxt.setText("");
			memberCityTxt.setText("");
			memberStateTxt.setText("");
			memberZipCodeTxt.setText("");
			memberPhoneNoTxt.setText("");
			view.showNoteAlert("Member was created successfully with ID : " + member.getId());
		}
		else {
			view.showErrorAlert("Member fields are mandatory...");
		}
	}
	
}
