package controller;

import authManager.AuthPresentation;
import employeeManager.domain.EmployeeManager;
import inputManager.InputManager;
import authManager.domain.AuthManager;

public class Controller {

    private final InputManager inputManager;
    private final AuthManager authManager;
    private final AuthPresentation authPresentation;
    private final EmployeeManager employeeManager;

    private final ApplicationState controllerState = new ApplicationState();


    public Controller(InputManager inputManager, EmployeeManager employeeManager, AuthManager userManager, AuthPresentation authPresentation) {
        this.inputManager = inputManager;
        this.employeeManager = employeeManager;
        this.authManager = userManager;
        this.authPresentation = authPresentation;
    }

    public void startApplication() {
        while (true) {
            if (controllerState.isSystemUp) {
                if (controllerState.isAuthenticated) {
                    listAdminOptions();
                } else {
                    listAuthOptions();
                }
            } else {
                break;
            }
        }
    }

    private void listAdminOptions() {
        String listing = """
                Welcome. Please make a chose.
                Your options:
                1. List all employees
                2. Add an employee
                3. Fire an employee
                4. Salary raise to an employee
                0. Logout
                To make the chose insert the number of the option.
                """;
        int selection = inputManager.getIntWithDescription(listing);

        switch (selection) {
            case 1 -> employeeManager.listEmployees();
            case 2 -> employeeManager.addEmployee();
            case 3 -> employeeManager.fireEmployee();
            case 4 -> employeeManager.salaryRaiseToSingleEmployee();
            case 0 -> {
                authPresentation.logout();
                updateAuthentication();
            }
            default -> System.out.println("There is no such options...");
        }
    }

    private void listAuthOptions() {
        String listing = """
                Welcome. Please make a selection.\s
                Your options:\s
                1. Login
                2. Create new boss account
                3. Exit
                To make the chose insert the number of the option.""";
        int selection = inputManager.getIntWithDescription(listing);

        switch (selection) {
            case 1 -> {
                authPresentation.login();
                updateAuthentication();
            }
            case 2 -> {
                authPresentation.register();
                updateAuthentication();
            }
            case 3 -> shutDownSystem();
            default -> System.out.println("There is no such options...");
        }
    }

    private void updateAuthentication() {
        controllerState.isAuthenticated = authManager.getIsAuthenticated();
    }

    private void shutDownSystem() {
        controllerState.isSystemUp = false;
    }
}

