package application.login_register;


import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class VerifyEmail2Controller implements Initializable {

	@FXML
	private AnchorPane pane3;
	
    @FXML
    private TextField otpField1;

    @FXML
    private TextField otpField2;

    @FXML
    private TextField otpField3;

    @FXML
    private TextField otpField4;

    @FXML
    private Button verifyOTP;
    
    private String username;
    private String fullname;
    private String password;
    private String email;
    private boolean term;
    
    private String verificationCode;

    @FXML
    void sendOTP(ActionEvent event) {
    	String enteredOTP = concatenateOTP();
    	if(enteredOTP.equals(verificationCode)) {
    		System.out.println("true");
            try {
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("verifyPage3.fxml"));
                AnchorPane verifyView = loader.load();
                
                VerifyEmail3Controller verifyController3 = loader.getController();
                verifyController3.setEmail(email);
                verifyController3.setUsername(username);
                verifyController3.setPassword(password);
                verifyController3.setFullname(fullname);
                verifyController3.setTerm(true);
                
                pane3.getChildren().setAll(verifyView);
			} catch (Exception e) {
				
			}
        } else {
            System.out.println("failed");
        }
    }
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	setOTPFieldListener(otpField1, otpField2, null); // Không có ô trước đó cho ô đầu tiên
	    setOTPFieldListener(otpField2, otpField3, otpField1);
	    setOTPFieldListener(otpField3, otpField4, otpField2);
	    setOTPFieldListener(otpField4, null, otpField3); // Không có ô phía sau cho ô cuối cùng
	}
    private void setOTPFieldListener(TextField currentField, TextField nextField, TextField previousField) {
        currentField.textProperty().addListener((observable, oldValue, newValue) -> {
        	if (!newValue.matches("\\d*")) {
                currentField.setText(oldValue); // Nếu không phải ký tự Latin không dấu, quay trở lại giá trị trước đó
            }else if (newValue.length() > 1) {
                currentField.setText(newValue.substring(0, 1)); // Chỉ cho phép 1 ký tự
            } else if (newValue.length() == 1 && nextField != null) {
                nextField.requestFocus(); // Di chuyển con trỏ sang ô tiếp theo
            }
        });
        currentField.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case BACK_SPACE:
                    if (currentField.getText().isEmpty() && previousField != null) {
                        previousField.requestFocus(); // Di chuyển con trỏ đến ô phía trước
                    }
                    break;
                case ENTER:
                    if (nextField != null) {
                        nextField.requestFocus(); // Di chuyển con trỏ sang ô tiếp theo
                    }
                    break;
                default:
                    break;
            }
        });
    }
	private String concatenateOTP() {
		return otpField1.getText() + otpField2.getText() + otpField3.getText() + otpField4.getText();
	}
	
    public void setUsername(String username) {
    	this.username = username;
    }
    public void setFullname(String fullname) {
    	this.fullname = fullname;
    }
    public void setPassword(String password) {
    	this.password = password;
    }

    public void setEmail(String email) {
    	this.email = email;
    }
    public void setTerm(boolean term) {
    	this.term = term;
        System.out.println("Term is set to: " + term); // Thêm dòng này để kiểm tra

    }
    public void setVerificationCode(String verificationCode) {
    	this.verificationCode = verificationCode;
    }
	
}
