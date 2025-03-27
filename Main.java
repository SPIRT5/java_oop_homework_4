import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(new Address("Россия", "Москва"), 2600);
        costPerAddress.put(new Address("Россия", "Нижний Новгород"), 3000);
        costPerAddress.put(new Address("Беларусь", "Минск"), 5500);
        costPerAddress.put(new Address("Беларусь", "Витебск"), 5000);

        Scanner scanner = new Scanner(System.in);
        int totalCost = 0;
        Set<String> uniqueCountries = new HashSet<>();

        while (true) {
            System.out.println("\nЗаполнение нового заказа.");
            System.out.print("Введите страну (или 'end' для завершения): ");
            String country = scanner.nextLine().trim();
            if (country.equalsIgnoreCase("end")) {
                break;
            }

            System.out.print("Введите город: ");
            String city = scanner.nextLine().trim();

            System.out.print("Введите вес (кг): ");
            String input = scanner.nextLine().trim();
            int weight;
            try {
                weight = Integer.parseInt(input);
                if (weight <= 0) {
                    System.out.println("Некорректный вес. Попробуйте снова.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод веса. Попробуйте снова.");
                continue;
            }

            Address address = new Address(country, city);
            if (costPerAddress.containsKey(address)) {
                int cost = costPerAddress.get(address) * weight;
                totalCost += cost;
                uniqueCountries.add(country);
                System.out.println("Стоимость доставки составит: " + cost + " руб.");
            } else {
                System.out.println("Доставки по этому адресу нет");
            }

            System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
            System.out.println("Количество уникальных стран с доставками: " + uniqueCountries.size());
        }
        scanner.close();
    }
}