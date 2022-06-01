package employeeManager.datamodel;

public record Employee(int id, String name, String field, double salary) {
    public void listEmployee() {
        String info = String.format("""
                Employee %d:
                Name: %s
                Field: %s
                Salary: %.0f
                """, this.id, this.name, this.field, this.salary);
        System.out.println(info);
    }
}
