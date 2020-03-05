package application.controllers;

import application.objectModel.Member;
import application.views.ViewManager;
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
			
			Member member = new Member(memberFirstNameTxt.getText(), memberLastNameTxt.getText(), memberAddressStreetTxt.getText(), memberCityTxt.getText(), 
					memberStateTxt.getText(), memberZipCodeTxt.getText(), memberPhoneNoTxt.getText());
			
			try {
				
				// TODO call controller method Add Member
				
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
			view.showNoteAlert("Data Saved Successfully");
		}
		else {
			view.showErrorAlert("Member fields are mandatory...");
		}
	}
	
}
