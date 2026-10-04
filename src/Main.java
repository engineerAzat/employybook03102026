//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook();

        System.out.println("--- Наполнение книги сотрудников (Вызываем 11 раз) ---");

        System.out.println("1. Иванов: " + book.addEmployee("Иванов Иван Иванович", 1, 120));
        System.out.println("2. Петров: " + book.addEmployee("Петров Петр Петрович", 1, 200));
        System.out.println("3. Сидоров: " + book.addEmployee("Сидоров Сидор Сидорович", 2, 80));
        System.out.println("4. Кузнецов: " + book.addEmployee("Кузнецов Алексей Николаевич", 2, 360));
        System.out.println("5. Смирнова: " + book.addEmployee("Смирнова Анна Викторовна", 3, 140));
        System.out.println("6. Попов: " + book.addEmployee("Попов Дмитрий Сергеевич", 3, 400));
        System.out.println("7. Васильев: " + book.addEmployee("Васильев Игорь Олегович", 4, 90));
        System.out.println("8. Соколов: " + book.addEmployee("Соколов Максим Андреевич", 4, 250));
        System.out.println("9. Новикова: " + book.addEmployee("Новикова Елена Владимировна", 5, 310));
        System.out.println("10. Федоров: " + book.addEmployee("Федоров Артем Игоревич", 5, 170));


        System.out.println("\n--- 1. Проверяем список всех сотрудников ---");
        book.printAllEmployees();

        System.out.println("\n--- 2. Проверяем среднюю зарплату ---");
        System.out.println("Средняя ЗП: " + book.getAverageSalary());

        System.out.println("\n--- 3. Проверяем налоги (PROPORTIONAL) ---");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\n--- 3. Проверяем налоги (PROGRESSIVE) ---");
        book.printTaxes("PROGRESSIVE");

        System.out.println("\n--- 4. Индексируем зарплату 1-го отдела на 10% ---");
        book.indexSalaryInDepartment(1, 10);
        book.printAllEmployees(); // Посмотрим, выросла ли ЗП у Иванова и Петрова

        System.out.println("\n--- 5. Ищем первого в отделе 2 с ЗП > 100 ---");
        book.printFirstWithHighSalary(2, 100);

        System.out.println("\n--- 6. Выводим первых 2 сотрудников с ЗП < 150 ---");
        book.printEmployeesWithLowSalary(150, 2);

        System.out.println("\n--- 7. Проверяем бухгалтерское совпадение ---");

        Employee testEmployee = new Employee("Кто То", 3, 80);
        System.out.println("Есть ли в компании сотрудник с ЗП 80? " + book.hasEmployeeBySalary(testEmployee));

        System.out.println("\n--- 8. Ищем сотрудника по ID 5 ---");
        Employee found = book.getEmployeeById(5);
        if (found != null) {
            System.out.println("Найдено: " + found);
        } else {
            System.out.println("Сотрудник не найден");
        }
    }
}