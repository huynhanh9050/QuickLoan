package application.login_register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class RegisterPageController {

    @FXML
    private Button button_signUp;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputFullName;

    @FXML
    private TextField inputPassword;

    @FXML
    private CheckBox inputTerm;

    @FXML
    private TextField inputUsername;
    
    @FXML
    private AnchorPane pane1;

    private String email;
    private String username;
    private String password;
    private String fullname;
    

    @FXML
    void goToVerifyPage1(ActionEvent event) {
    	try {
    		email = inputEmail.getText();
      	  	username = inputUsername.getText();
      	  	
      	  	String password = inputPassword.getText();
      	  	if (password.length() < 8) {
              Alert alert = new Alert(AlertType.ERROR);
              alert.setTitle("Error");
              alert.setContentText("Mật khẩu phải có ít nhất 8 ký tự!");
              alert.show();
              return; // Dừng lại ở đây và không thực hiện bất kỳ thao tác nào tiếp theo
          }
      	  	
      	  	fullname = inputFullName.getText();
      	  	boolean term = isTermAccepted();
      	
      	
    		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("verifyPage1.fxml"));
			AnchorPane defaultView = loader.load();
			
			VerifyEmailController1 verifyEmailController1 = loader.getController();
			verifyEmailController1.setEmail(email);
			verifyEmailController1.setFullname(fullname);
			verifyEmailController1.setUsername(username);
			verifyEmailController1.setPassword(password);
			verifyEmailController1.setTerm(isTermAccepted());
			
			pane1.getChildren().addAll(defaultView);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public boolean isTermAccepted() {
        return inputTerm.isSelected();
    }
    
    public void setEmail(String email) {
    	inputEmail.setText(email);
    }
    public void setUsername(String username) {
    	inputUsername.setText(username);
    }
    public void setPassword(String password) {
    	inputPassword.setText(password);
    }
    public void setFullname(String fullname) {
    	inputFullName.setText(fullname);
    }
    public void setTerm(Boolean term) {
    	inputTerm.setSelected(term);
    }

}
