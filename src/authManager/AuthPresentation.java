package authManager;

import authManager.domain.AuthManager;
import inputManager.InputManager;

public class AuthPresentation {
    private final AuthManager authManager;
    private final InputManager inputManager;

    public AuthPresentation(AuthManager authManager, InputManager inputManager) {
        this.authManager = authManager;
        this.inputManager = inputManager;
    }

    public void login() {
        String name = inputManager.getStringWithDescription("Enter your name: ");
        String password = inputManager.getStringWithDescription("Enter your password: ");

        boolean isSuccess = authManager.login(name, password);

        if (!isSuccess){
            System.out.println("Login failed!");
        }
    }

    public void register() {
        String name = inputManager.getStringWithDescription("Enter new name: ");
        String password = inputManager.getStringWithDescription("Enter new password: ");

        authManager.register(name, password);
        System.out.println("Welcome " + name + " !");
    }

    public void logout() {
        authManager.logout();
        System.out.println("Logged out from account !");
    }
}
