package application.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.objectModel.BookCopy;
import application.objectModel.BookOverdueList;
import application.views.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OverDueListController {

	@FXML
	private TextField bookISBNTxt;
	
	@FXML
	private TextField bookTitleTxt;
	
	@FXML
	private TableView<BookOverdueList> tableView;
	
	@FXML
	private TableColumn<BookOverdueList, String> bookCopyNoColumn;
	
	@FXML
	private TableColumn<BookOverdueList, String> memberIdColumn;
	
	@FXML
	private TableColumn<BookOverdueList, String> firstNameColumn;
	
	@FXML
	private TableColumn<BookOverdueList, String> lastNameColumn;
	
	@FXML
	private TableColumn<BookOverdueList, LocalDate> dueDateColumn;
	
	public void BackAction(ActionEvent event) throws Exception {
		ViewManager view = ViewManager.getInstance();
		view.showTree(0, "");
	}
	
	// function to search for overdue list
	public void searchOverdueList() {
		
		ViewManager view = ViewManager.getInstance();
		
		if (!bookISBNTxt.getText().isEmpty()) {
			
			try {
				List<BookCopy> bookCopies = new ArrayList<BookCopy>();
				
				// TODO call controller method search for check outs
				
				//if (bookCopies.size() != 0) {
					bookCopyNoColumn.setCellValueFactory(new PropertyValueFactory<BookOverdueList, String>("copyNumber"));
					memberIdColumn.setCellValueFactory(new PropertyValueFactory<BookOverdueList, String>("memberId"));
					firstNameColumn.setCellValueFactory(new PropertyValueFactory<BookOverdueList, String>("firstName"));
					lastNameColumn.setCellValueFactory(new PropertyValueFactory<BookOverdueList, String>("lastName"));
					dueDateColumn.setCellValueFactory(new PropertyValueFactory<BookOverdueList, LocalDate>("dueDate"));
					
					tableView.setItems(getOverdueList(bookCopies));
				/*}
				else {
					view.showErrorAlert("No Data found for the given ISBN");
				}*/
			} catch (Exception e) {
				view.showErrorAlert(e.getMessage());
			}
		}
		else {
			view.showErrorAlert("Book ISBN is mandatory...");
		}
		
	}
	
	// function to get the chick out records from a member
	public ObservableList<BookOverdueList> getOverdueList(List<BookCopy> bookCopies) {
		
		ObservableList<BookOverdueList> bookOverdueList = FXCollections.observableArrayList();
		
		// TODO the below line to be removed
		bookTitleTxt.setText("Book Title");
		
		/*
		bookTitleTxt.setText(bookCopies.get(0).getBook().getTitle());
		
		for (BookCopy copy : bookCopies) {
			BookOverdueList bookOverdue = 
					new BookOverdueList(copy.getCopyNumber(), copy.getMember().getMemberId(), 
					copy.getMember().getFirstName(), copy.getMember().getLastName(), copy.getDueDate());
			
			bookOverdueList.add(bookOverdue);
		}
		*/
		// TODO the below for loop will be removed
		for (int i=0; i<5; i++) {
			long val1 = 12345;
			long val2 = 6789;
			BookOverdueList bookOverdue = new BookOverdueList(val1, val2, "Mohamed", "ElSayed", new Date());
			bookOverdueList.add(bookOverdue);
		}
		return bookOverdueList;
	}
	
}
