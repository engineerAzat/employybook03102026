public class Employee {

    private static int idCounter = 1;

    private String fullName; // Ф.И.О.
    private int department; // Отдел (от 1 до 5)
    private int salary; // Зарплата (от 50 до 450)
    private int id;

    public Employee(String fullName, int department, int salary) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник № " + id + ": " + fullName + ", Отдел: " + department + ", Зарплата: " + salary;
    }

    public void printShortInfo() {
        System.out.println("Ф.И.О.: " + fullName + ", Зарплата: " + salary);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return this.salary == employee.salary;
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(salary);
    }
}
