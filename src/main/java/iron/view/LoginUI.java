package iron.view;

import iron.controller.Authenticator;

public class LoginUI {
    private String inputUser;
    private String inputPass;
    private Authenticator authenticator;
    
    public LoginUI(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public String getInputUser() { return inputUser; }
    public void setInputUser(String inputUser) { this.inputUser = inputUser; }
    public String getInputPass() { return inputPass; }
    public void setInputPass(String inputPass) { this.inputPass = inputPass; }
    public Authenticator getAuthenticator() { return authenticator; }
    public void setAuthenticator(Authenticator authenticator) { this.authenticator = authenticator; }
    
    public void Login() {
        // TODO: Implement login sequence and set MainUI dashboard
    }
}