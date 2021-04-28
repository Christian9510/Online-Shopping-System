package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;
    
    @FXML
    private Button btnLogout;
    
    public void login() throws IOException
    {
    	String Username = txtUsername.getText();
    	String Password = txtPassword.getText();
    	
    	Alert message = new Alert(AlertType.INFORMATION);
    	if(Username.equals("admin")&&Password.equals("1234"))
    	{
//    		message.setContentText("Welcome "+Username);
//    		message.setTitle("Welcome");
//    		message.show();
    		btnLogin.getScene().getWindow().hide();
    		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainApplication.fxml"));
			Scene scene = new Scene(root,379,227);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
//			primaryStage.setResizable(false);
			primaryStage.setTitle("Welcome");
			primaryStage.show();
			
    	}
    	else
    	{
    		message.setContentText("Invalid Login Details");
    		message.setTitle("Unsuccessful Login");
    		message.show();
    	}
    	
    	txtPassword.setText("");
    	txtUsername.setText("");
    }
    
    public void cancelLogin()
    {
    	Platform.exit();
    }
    
    public void logout() throws IOException
    {
    	btnLogout.getScene().getWindow().hide();
    	
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root,379,227);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Login");
		primaryStage.show();
    }
}
