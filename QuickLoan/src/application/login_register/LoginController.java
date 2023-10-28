package application.login_register;

import java.net.URL;
import java.util.ResourceBundle;

import org.mindrot.jbcrypt.BCrypt;

import application.entities.Account;
import application.entities.UserSession;
import application.model.AccountModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {


    @FXML
    private Button button_forgetPassword;
	
	@FXML
	private Button buttonEye;

    @FXML
    private ImageView eyeIcon;
    
    @FXML
    private Button button_singin;

    @FXML
    private PasswordField inputPassword;
    
    @FXML
    private TextField visiblePasswordField;


    @FXML
    private TextField inputUsername;

    @FXML
    private AnchorPane pane1;
    
    private String username;
    private String password;
    
    private final Image eyeOpen = new Image(getClass().getResourceAsStream("/application/login_register/libs/eye-line.png"));
    private final Image eyeClosed = new Image(getClass().getResourceAsStream("/application/login_register/libs/eye-off-line.png"));


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		eyeIcon.setImage(eyeOpen);
		
	}
	@FXML
    void forgetPassword(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("forgetPasswordPage1.fxml"));
			AnchorPane defaultView = loader.load();
			
			pane1.getChildren().addAll(defaultView);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@FXML
	void sginIn(ActionEvent event) {
		String username = inputUsername.getText();
		String password = inputPassword.getText();
		
		if (inputPassword.getLength() < 8) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Mật khẩu phải có ít nhất 6 ký tự!");
            alert.show();
            return;
        }
		AccountModel accountModel = new AccountModel();
        Account account = accountModel.findByUsername(username);

        if (account != null && BCrypt.checkpw(password, account.getPassword()) && account.getRole().equals("user")) {
            
        	UserSession.getInstace(account.getId());
     	
       
        	if (UserSession.isInitialized()) {
        	    System.out.println("Session ID da duoc lay, ngon roi anh em");
        	} else {
        	    UserSession.getInstace(account.getId());
        	    System.out.println("Lấy Session ID mới");
        	}

        //login cho admin để ở đây

        	
        } else {
            // Đăng nhập thất bại
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Tên đăng nhập hoặc mật khẩu không đúng!");
            alert.show();
        }
	    }
	  
    @FXML
    void togglePasswordVisibility(ActionEvent event) {
    	if(inputPassword.isVisible()) {
    		visiblePasswordField.setText(inputPassword.getText());
    		visiblePasswordField.setVisible(true);
    		inputPassword.setVisible(false);
    		eyeIcon.setImage(eyeOpen);
    	}else {
    		visiblePasswordField.setText(inputPassword.getText());
    		visiblePasswordField.setVisible(false);
    		inputPassword.setVisible(true);
    		eyeIcon.setImage(eyeClosed);
    	}
    }
    public void setUsername(String username) {
    	inputUsername.setText(username);
    }
    public void setPassword(String password) {
    	inputPassword.setText(password);
    }


}
