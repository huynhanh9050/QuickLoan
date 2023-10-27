package application.entities;

public class UserSession {
    private static UserSession instance;

    
    private int id;

    private UserSession(int id) {
        
        this.id = id;
    }

    //phiên bản 2 đối số
    public static UserSession getInstace(int id) {
        if (instance == null) {
            instance = new UserSession( id);
        }
        return instance;
    }
    
    //phiên bản không đối số
    public static UserSession getInstace() {
        if (instance == null) {
            throw new IllegalStateException("Session has not been initialized. Call getInstace(String, int) first.");
        }
        return instance;
    }

    

    public int getUserId() {
        return id;
    }
    public void endSession() {
    	instance = null;
    }
  //kiểm tra session
    public static boolean isInitialized() {
        return instance != null;
    }

    
}
