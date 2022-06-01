import authManager.AuthPresentation;
import controller.Controller;
import employeeManager.domain.EmployeeManagerImpl;
import inputManager.InputManager;
import inputManager.InputManagerImpl;
import authManager.domain.AuthManager;
import authManager.domain.AuthManagerImpl;
import util.RandomManager;


public class Main {

    public static void main(String[] args) {

        // dependency declaration
        RandomManager randomManager = new RandomManager();
        InputManager inputManager = new InputManagerImpl();
        AuthManager authManager = new AuthManagerImpl(randomManager);
        AuthPresentation authPresentation = new AuthPresentation(authManager, inputManager);
        EmployeeManagerImpl employeeManager = new EmployeeManagerImpl(inputManager, randomManager);

        // creating controller
        Controller controller = new Controller(inputManager, employeeManager, authManager, authPresentation);

        // starting application
        controller.startApplication();
    }

}

/* """

    *empl -> employee

    Employee EmployeeManager.Administrator System

    // DONE
    Add employee to the system
    Remove empl
    pay rise to a single empl

    // TODO
    total monthly cost of empls
    pay rise to a empl type


    // TODO convert kotlin

    // TODO separate ui layer



""" */
