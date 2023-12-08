package interfaceLine;

import domain.Kindergarden;
import manager.KindergardenDAO;;

import java.util.Scanner;

public class Interface {
    private KindergardenDAO kindergardenDAO;
    private Scanner scanner;

    public Interface() {
        kindergardenDAO = new KindergardenDAO();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the TV Program Manager!");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("listName")) {
                System.out.println(kindergardenDAO.getAllPrograms());
            } else if (command.equals("addChildren")) {
                System.out.print("Введите ФИО ребенка: ");
                String name = scanner.nextLine();
                System.out.print("Введите возраст ребенка: ");
                Integer age = Integer.valueOf(scanner.nextLine());
                System.out.print("Введите пол ребенка: ");
                String gender = scanner.nextLine();
                System.out.print("Введите название группы: ");
                String group_name = scanner.nextLine();
                System.out.print("Введите номер группы: ");
                Integer group_number = Integer.valueOf(scanner.nextLine());

                Kindergarden kindergarden = new Kindergarden(name, age, gender, group_name, group_number);
                kindergardenDAO.addProgram(kindergarden);
                System.out.println("Программа обновлена успешно!");
            } else if (command.equals("update")) {
                System.out.print("Введите ID ребенка: ");
                int id = Integer.parseInt(scanner.nextLine());

                // Check if the program with the given ID exists in the database
                // If not, display an error message

                System.out.print("Введите ФИО ребенка: ");
                String name = scanner.nextLine();
                System.out.print("Введите пол ребенка: ");
                String gender = scanner.nextLine();
                System.out.print("Введите возраст ребенка: ");
                Integer age = Integer.valueOf(scanner.nextLine());
                System.out.print("Введите название группы: ");
                String group_name = scanner.nextLine();
                System.out.print("Введите номер группы: ");
                Integer group_number = Integer.valueOf(scanner.nextLine());

                Kindergarden updatedKindergarden = new Kindergarden(name, age, gender, group_name, group_number);
                updatedKindergarden.setId(id);
                kindergardenDAO.updateProgram(updatedKindergarden);
                System.out.println("Программа обновлена успешно!");
            } else if (command.equals("delete")) {
                System.out.print("Введите ID ребенка для удаления: ");
                int id = Integer.parseInt(scanner.nextLine());

                // Check if the program with the given ID exists in the database
                // If not, display an error message

                kindergardenDAO.deleteProgram(id);
                System.out.println("Удаление успешно!");
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}