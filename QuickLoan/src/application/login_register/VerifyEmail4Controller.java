package application.login_register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class VerifyEmail4Controller {

    @FXML
    private Button buttonsetStarted;


    @FXML
    private AnchorPane pane5;

    private String username;
    private String password;
    
    @FXML
    void gotoLogin(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
        	AnchorPane defaulView = loader.load(); 
        	
        	LoginController loginController = loader.getController();
        	loginController.setUsername(username);
        	loginController.setPassword(password);
        	
        	pane5.getChildren().addAll(defaulView);
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public void setUsername(String username) {
    	this.username = username;
    }
    public void setPassword(String password) {
    	this.password = password;
    }

}
