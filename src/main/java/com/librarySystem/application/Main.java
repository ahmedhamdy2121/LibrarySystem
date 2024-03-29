package com.librarySystem.application;
	
import com.librarySystem.application.views.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	ViewManager view = ViewManager.getInstance();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			view.loginScene(primaryStage, "/com/librarySystem/application/views/LoginView.fxml");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
