package com.librarySystem.application.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ViewManager {
	
	private String userNameLogin;
	private int userPermission;
	private Stage stage;
	private static ViewManager viewInstance = null; 
	private String applicationCSS = "/com/librarySystem/application/application.css";
	  
    private ViewManager() { 
        this.setStage(new Stage());
        this.userNameLogin = "";
        this.userPermission = 0;
    } 
    
    // static method to create instance of Singleton class 
    public static ViewManager getInstance() { 
        if (viewInstance == null) 
        	viewInstance = new ViewManager(); 
  
        return viewInstance; 
    } 
	
    public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	// function to load the login window
	public void loginScene(Stage primaryStage, String FxmlPath) {
		
        this.stage = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource(FxmlPath));
			Scene scene = new Scene(root);
			this.stage.setTitle("Library System");
			scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
			this.stage.setScene(scene);
			this.stage.setResizable(false);
			this.stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	// function to show error alert
	public void showErrorAlert(String errorMessage) {
    
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setResizable(false);
        alert.setContentText(errorMessage);
        alert.setHeaderText(null);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }
	
	// function to show information alert
	public void showNoteAlert(String errorMessage) {
    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Note");
        alert.setResizable(false);
        alert.setContentText(errorMessage);
        alert.setHeaderText(null);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

	// function to show the tree
	public void showTree(int permission, String userName) {
		
		try {
			if (!userName.isEmpty() && permission != 0) {
				this.userNameLogin = userName;
				this.userPermission = permission;
			}
			TreeView<String> tree;
			TreeItem<String> treeRoot = new TreeItem<String>("Library System");
			treeRoot.setExpanded(true);
			buildTree(treeRoot, this.userPermission);
			tree = new TreeView<String>(treeRoot);
			tree.getStyleClass().add("myTree"); 
			tree.setShowRoot(true);
			tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
				if (newValue != null) {
					manageTreeActions(newValue.getValue());
				}
			});
			
			StackPane layout = new StackPane();
			layout.setStyle("-fx-background-color: #5e5959;");
			layout.getChildren().add(tree);
			Scene scene = new Scene(layout, 600, 700);
			this.stage.setTitle("Library System - Welcome " + this.userNameLogin);
			scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
			this.stage.setScene(scene);
			this.stage.setResizable(false);
			this.stage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	private TreeItem<String> makeTreeBranch(String title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<String>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}
	
	private void buildTree(TreeItem<String> treeRoot, int permission) {
		// case of Administrator
		if (permission == 1) {
			TreeItem<String> book, member; 
			book = makeTreeBranch("Manage Book", treeRoot);
			makeTreeBranch("Add New Book", book);
			makeTreeBranch("Add Book Copy", book);
			
			member = makeTreeBranch("Manage Member", treeRoot);
			makeTreeBranch("Add New Member", member);
			makeTreeBranch("Edit Member Information", member);
		}
		// case of Librarian
		else if (permission == 2) {
			TreeItem<String> checkOut, query; 
			checkOut = makeTreeBranch("Check Out", treeRoot);
			makeTreeBranch("Checkout a Book", checkOut);
			
			query = makeTreeBranch("Query Members", treeRoot);
			makeTreeBranch("Search for member checkouts", query);
			makeTreeBranch("Checkout for overdue book copy", query);
		}
		// case of Both 
		else if (permission == 3) {
			TreeItem<String> book, member, checkOut, query; 
			book = makeTreeBranch("Manage Book", treeRoot);
			makeTreeBranch("Add New Book", book);
			makeTreeBranch("Add Book Copy", book);
			
			member = makeTreeBranch("Manage Member", treeRoot);
			makeTreeBranch("Add New Member", member);
			makeTreeBranch("Edit Member Information", member);
			
			checkOut = makeTreeBranch("Check Out", treeRoot);
			makeTreeBranch("Checkout a Book", checkOut);
			
			query = makeTreeBranch("Query Members", treeRoot);
			makeTreeBranch("Search for member checkouts", query);
			makeTreeBranch("Checkout for overdue book copy", query);
		}
	}
	
	// function to manage tree actions
	public void manageTreeActions(String treeAction) {
		
		if (treeAction.equals("Add New Book")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/com/librarySystem/application/views/AddBook.fxml"));
				Scene scene = new Scene(root);
				this.stage.setTitle("Library System");
				scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
				this.stage.setScene(scene);
				this.stage.setResizable(false);
				this.stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (treeAction.equals("Add Book Copy")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/com/librarySystem/application/views/AddBookCopy.fxml"));
				Scene scene = new Scene(root);
				this.stage.setTitle("Library System");
				scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
				this.stage.setScene(scene);
				this.stage.setResizable(false);
				this.stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (treeAction.equals("Add New Member")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/com/librarySystem/application/views/AddMember.fxml"));
				Scene scene = new Scene(root);
				this.stage.setTitle("Library System");
				scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
				this.stage.setScene(scene);
				this.stage.setResizable(false);
				this.stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (treeAction.equals("Edit Member Information")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/com/librarySystem/application/views/EditMember.fxml"));
				Scene scene = new Scene(root);
				this.stage.setTitle("Library System");
				scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
				this.stage.setScene(scene);
				this.stage.setResizable(false);
				this.stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (treeAction.equals("Checkout a Book")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/com/librarySystem/application/views/CheckOutBook.fxml"));
				Scene scene = new Scene(root);
				this.stage.setTitle("Library System");
				scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
				this.stage.setScene(scene);
				this.stage.setResizable(false);
				this.stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (treeAction.equals("Search for member checkouts")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/com/librarySystem/application/views/SearchMemberCheckouts.fxml"));
				Scene scene = new Scene(root);
				this.stage.setTitle("Library System");
				scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
				this.stage.setScene(scene);
				this.stage.setResizable(false);
				this.stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (treeAction.equals("Checkout for overdue book copy")) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/com/librarySystem/application/views/OverDueList.fxml"));
				Scene scene = new Scene(root);
				this.stage.setTitle("Library System");
				scene.getStylesheets().add(getClass().getResource(this.applicationCSS).toExternalForm());
				this.stage.setScene(scene);
				this.stage.setResizable(false);
				this.stage.show();	
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
