public class EmployeeBook {

    private final Employee[] employees = new Employee[10];

    public void printAllEmployees() {
        for (Employee emp : employees) {

            if (emp != null) {

                System.out.println(emp.toString());
            }
        }
    }

    public double getAverageSalary() {
        int sum = 0;
        int count = 0;

        for (Employee emp : employees) {

            if (emp == null) {
                break;
            }
            sum += emp.getSalary();
            count++;
        }
        if (count == 0) {
            return 0;
        } else {
            return (double) sum / count;
        }
    }

    public void printTaxes(String taxType) {
        System.out.println("--- Расчет налогов по схеме: " + taxType + " ---");
        for (Employee emp : employees) {
            if (emp == null) {
                continue;
            }
            double tax = 0;

            switch (taxType) {
                case "PROPORTIONAL":
                    tax = emp.getSalary() * 0.13;
                    break;

                case "PROGRESSIVE":

                    int salary = emp.getSalary();
                    if (salary <= 150) {
                        tax = salary * 0.13;
                    } else if (salary <= 350) {
                        tax = salary * 0.17;
                    } else {
                        tax = salary * 0.21;
                    }
                    break;

                default:
                    System.out.println("Ошибка: Неизвестный тип налога!");
                    return;
            }
            System.out.println(emp.getFullName() + " ЗП: " + emp.getSalary() + ") -> Налог: " + tax);
        }


    }

    public void indexSalaryInDepartment(int department, double indexPersent) {
        for (Employee emp : employees) {
            if (emp == null || emp.getDepartment() != department) {
                continue;
            }
            int currentSalary = emp.getSalary();

            int newSalary = (int) (currentSalary + (1 + indexPersent / 100));

            emp.setSalary(newSalary);
        }
    }

    public void printFirstWithHighSalary(int department, int minSalary) {
        for (int i = 0;i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp != null && emp.getDepartment() == department && emp.getSalary() > minSalary) {

                System.out.println("Порядковый номер в списке:" + (i + 1) + ". ");
                emp.printShortInfo();
                break;
            }
        }
    }

    public void printEmployeesWithLowSalary(int maxWage, int employeeNumber) {
        int i = 0;
        int count = 0;

        while (i < employees.length) {
            if (count == employeeNumber) {
                break;
            }

            Employee emp = employees[i];

            if (emp != null && emp.getSalary() < maxWage) {
                emp.printShortInfo();
                count++;
            }
            i++;
        }
    }

    public boolean hasEmployeeBySalary(Employee targetEmployee) {
        if (targetEmployee == null) {
            return false;
        }
        for (Employee emp : employees) {
            if (emp != null && emp.equals(targetEmployee)) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }

        return null;
    }


}
