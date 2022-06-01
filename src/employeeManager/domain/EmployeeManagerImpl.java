package employeeManager.domain;

import employeeManager.datamodel.Employee;
import inputManager.InputManager;
import util.RandomManager;

import java.util.ArrayList;
import java.util.List;

import static employeeManager.EmployeeDataSetKt.employeeDataSet;


public class EmployeeManagerImpl implements EmployeeManager {
    private final InputManager inputManager;
    private final RandomManager randomManager;


    private final ArrayList<Employee> employeeDatabase = employeeDataSet;
    // employee list of all employees, kinda employee database of the system


    public EmployeeManagerImpl(InputManager inputManager, RandomManager randomManager) {
        this.inputManager = inputManager;
        this.randomManager = randomManager;
    }


    @Override
    public void listEmployees() {
        employeeDatabase.forEach(Employee::listEmployee);
    }


    @Override
    public void addEmployee() {
        String name = inputManager.getStringWithDescription("Input employee name: ");
        String field = inputManager.getStringWithDescription("Input employee field: ");
        double salary = inputManager.getDoubleWithDescription("Input employee salary: ");
        int id = randomManager.generateId();

        Employee employee = new Employee(id, name, field, salary);
        employeeDatabase.add(employee);
        employee.listEmployee();
    }


    @Override
    public void fireEmployee() {
        int employeeId = inputManager.getIntWithDescription("Input employee Id to fire!");

        List<Employee> filterResult = getEmployeeById(employeeId);

        if (!filterResult.isEmpty()) {
            Employee selectedEmployee = filterResult.get(0);
            employeeDatabase.remove(selectedEmployee);
            System.out.println("Employee " + selectedEmployee.name() + " has been fired!");
        } else {
            System.out.println("There is no employee with this given id!");
        }
    }

    @Override
    public void salaryRaiseToSingleEmployee() {
        int employeeId = inputManager.getIntWithDescription("Input employee Id to salary raise!");
        double salaryRaiseAmount = inputManager.getDoubleWithDescription("Input salary amount to raise!");

        List<Employee> filterResult = getEmployeeById(employeeId);


        if (!filterResult.isEmpty()) {
            Employee selectedEmployee = filterResult.get(0);
            double newSalaryAmount = selectedEmployee.salary() + salaryRaiseAmount;
            Employee updatedEmployee =  new Employee(selectedEmployee.id(), selectedEmployee.name(), selectedEmployee.field(), newSalaryAmount);

            employeeDatabase.remove(selectedEmployee);
            employeeDatabase.add(updatedEmployee);

            System.out.println("Salary raise successful!");
        } else {
            System.out.println("There is no employee with this given id!");
        }
    }

    private List<Employee> getEmployeeById(int id) {
        return employeeDatabase.stream().filter(employee -> employee.id() == id).toList();
    }
}
