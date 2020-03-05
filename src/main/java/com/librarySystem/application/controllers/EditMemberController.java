package application.controllers;

import application.objectModel.Member;
import application.views.ViewManager;
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
		Member member = new Member("", "", "", "", "", "", "");
		
		if (!memberIdTxt.getText().isEmpty()) {
			
			try {
				
				// TODO call controller method search for member
				
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
			
			memberFirstNameTxt.setDisable(false);
			memberFirstNameTxt.setText(member.getFirstName());
			
			memberLastNameTxt.setDisable(false);
			memberLastNameTxt.setText(member.getLastName());
			
			memberAddressStreetTxt.setDisable(false);
			memberAddressStreetTxt.setText(member.getAddressStreet());
			
			memberCityTxt.setDisable(false);
			memberCityTxt.setText(member.getCity());
			
			memberStateTxt.setDisable(false);
			memberStateTxt.setText(member.getState());
			
			memberZipCodeTxt.setDisable(false);
			memberZipCodeTxt.setText(member.getZipCode());
			
			memberPhoneNoTxt.setDisable(false);
			memberPhoneNoTxt.setText(member.getPhoneNo());
			
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
			
			Member member = new Member(memberFirstNameTxt.getText(), memberLastNameTxt.getText(), memberAddressStreetTxt.getText(), memberCityTxt.getText(), 
					memberStateTxt.getText(), memberZipCodeTxt.getText(), memberPhoneNoTxt.getText());
			
			try {
				
				// TODO call controller method save member information
				
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
