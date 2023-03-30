import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.console;

public class Main {

    private static HashMap<String,String> channels = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static void fillByDefault () {
        channels.put("1", "1+1");
        channels.put("2", "Новий канал");
        channels.put("3", "СТБ");
        channels.put("4", "Discovery");
        channels.put("5", "Mega");
        channels.put("6", "Плюс");
        channels.put("7", "ICTV");
        channels.put("8", "Перший");
        channels.put("9", "M1");
        channels.put("10", "Toronto");
    }

    private static void showMenu() {
        System.out.println("Виберіть опцію: ");
        System.out.println("0: Відобразити всі телеканали");
        System.out.println("1: Добавити телеканал");
        System.out.println("2: Пошук телеканалу");
        System.out.println("3: Видалити телеканал");

        String option = scanner.nextLine();

        switch (option) {
            case "0":
                for (Map.Entry<String, String> entry : channels.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                showMenu();
                break;
            case "1":
                System.out.println("Введіть номер телеканалу");
                String number = scanner.nextLine();
                System.out.println("Введіть назву телеканалу");
                String name = scanner.nextLine();
                channels.put(number, name);
                System.out.println("Телеканал додано");
                showMenu();
                break;
            case "2":
                System.out.println("Введіть номер телеканалу");
                String searchNumber = scanner.nextLine();
                if (channels.containsKey(searchNumber)) {
                    System.out.println(searchNumber + ": " + channels.get(searchNumber));
                } else {
                    System.out.println("Телеканалу з таким номером не знайдено");
                }
                showMenu();
                break;
            case "3":
                System.out.println("Введіть номер телеканалу який хочете видалити: ");
                String removeNumber = scanner.nextLine();
                if (channels.containsKey(removeNumber)) {
                    channels.remove(removeNumber);
                    System.out.println("Телеканал успішно видалено");
                } else {
                    System.out.println("Телеканалу з таким номером не знайдено");
                }
                showMenu();
                break;
            default:
                System.out.println("Невірна опція. Спробуйте ще раз.");
                showMenu();
                break;
        }
    }
    public static void main(String[] args) {
        fillByDefault();
        if (!channels.isEmpty())
            System.out.println("Кількість телеканалів: " + channels.size());
        showMenu();
    }

}