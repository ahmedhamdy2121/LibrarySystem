package com.librarySystem.application.controllers;

import com.librarySystem.entity.Address;
import com.librarySystem.entity.Member;
import com.librarySystem.application.views.ViewManager;
import com.librarySystem.controller.Controller;
import com.librarySystem.controller.ControllerFactory;
import com.librarySystem.controller.MemberController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditMemberController {
	
	@FXML
	private TextField memberIdTxt;
	
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
	
	@FXML
	private Button saveEditMemberBtn;
	
	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		view.showTree(0, "");
	}
	
	// function to search for a member
	public void searchMember(ActionEvent event) throws Exception {
		
		ViewManager view = ViewManager.getInstance();
		
		if (!memberIdTxt.getText().isEmpty()) {
			Member member = null;
			try {
				MemberController memberC = ControllerFactory.getController(Controller.Member);
				member = memberC.getMemberByID(Integer.parseInt(memberIdTxt.getText()));
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
			
			memberFirstNameTxt.setDisable(false);
			memberFirstNameTxt.setText(member.getFirstName());
			
			memberLastNameTxt.setDisable(false);
			memberLastNameTxt.setText(member.getLastName());
			
			memberAddressStreetTxt.setDisable(false);
			memberAddressStreetTxt.setText(member.getAddress().getStreet());
			
			memberCityTxt.setDisable(false);
			memberCityTxt.setText(member.getAddress().getCity());
			
			memberStateTxt.setDisable(false);
			memberStateTxt.setText(member.getAddress().getState());
			
			memberZipCodeTxt.setDisable(false);
			memberZipCodeTxt.setText(member.getAddress().getZip());
			
			memberPhoneNoTxt.setDisable(false);
			memberPhoneNoTxt.setText(member.getPhoneNumber());
			
			saveEditMemberBtn.setDisable(false);
		}
		else {
			view.showErrorAlert("Member ID is mandatory...");
		}
		
	}

	// function to save member information
	public void saveEditMember(ActionEvent event) throws Exception {
		
		ViewManager view = ViewManager.getInstance();
		
		if (!memberFirstNameTxt.getText().isEmpty() && !memberLastNameTxt.getText().isEmpty() && !memberAddressStreetTxt.getText().isEmpty() && 
				!memberCityTxt.getText().isEmpty() && !memberStateTxt.getText().isEmpty() && 
				!memberZipCodeTxt.getText().isEmpty() && !memberPhoneNoTxt.getText().isEmpty()) {
			
			Address address = new Address(memberAddressStreetTxt.getText(), memberCityTxt.getText(), 
					memberStateTxt.getText(), memberZipCodeTxt.getText());
			
			Member member = new Member(memberFirstNameTxt.getText(), memberLastNameTxt.getText(), memberPhoneNoTxt.getText(), address);
			
			try {
				
				MemberController memberC = ControllerFactory.getController(Controller.Member);
				memberC.editMember(member);
				
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
			
			view.showNoteAlert("Data Saved Successfully");
		}
		else {
			view.showErrorAlert("Member fields are mandatory...");
		}
		
	}
	
}
