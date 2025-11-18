package collections;

import java.util.*;
import java.util.stream.Collectors;

public class UserCollections {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alina", 35),
                new User("Slava", 36),
                new User("Ira", 54),
                new User("Tania", 45),
                new User("Alina", 35),
                new User("Slava", 51),
                new User("Alla", 74)
        );

        Set<String> namesSartA = users.stream().map(User::getName)
                .filter(name -> name.startsWith("A")).collect(Collectors.toSet());
        System.out.println(namesSartA);

        List<String> namesSartAlist = users.stream().map(User::getName)
                .filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println(namesSartAlist);

        /// ///
        Set<User> uniqu, un2 = new HashSet<>();

        Map<String, Integer> duplicates = new HashMap<>();
        /*for (User user : users) {
            if (!uniqu.add(user)) {
                duplicates.put(user.getName(), user.getAge());
            }
        }
        System.out.println(uniqu);
        System.out.println(String.format("Duplicates: %s", duplicates));*/

        //  duplicates = users.stream().filter(user -> !uniqu.add(user)).collect(Collectors.toMap(User::getName, User::getAge));
        //  System.out.println(duplicates);

        List<String> namesA = users.stream().map(User::getName).distinct().
                filter(u -> u.startsWith("A")).collect(Collectors.toList());
        System.out.println(namesA);

        List<String> names1 = Arrays.asList("alina", "bohdan", "alina", "oksana");
        List<String> upperCse = names1.stream().distinct().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCse);

        Map<Integer, List<User>> grouped = users.stream().collect(Collectors.groupingBy(User::getAge));
        for (Map.Entry<Integer, List<User>> entry : grouped.entrySet()) {
            System.out.println(String.format("%s -> %s", entry.getKey(), entry.getValue()));
        }
        System.out.println("All users more then 18 years old");
        Boolean bool = users.stream().allMatch(u -> u.getAge() > 18);
        System.out.println(bool);

        System.out.println("oldest user");
        System.out.println(users.stream().max(Comparator.comparing(User::getAge)).stream().collect(Collectors.toList()));

        //Map<String, Integer>
        System.out.println("Map of users");
        Map<String, Integer> mappedUsers = users.stream().collect(Collectors.toMap(User::getName, User::getAge, (exist, replace) -> replace));
        System.out.println(mappedUsers);

        //Порахувати кількість користувачів старше 40
        System.out.println(String.format("Count Users have age > 40: %s", users.stream().filter(u -> u.getAge() > 40).count()));

        Map<Integer, Long> gropedByAge = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        Map<String, Long> gropedByName = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.counting()));

        System.out.println(String.format("Groped by age %s", gropedByAge));
        System.out.println(String.format("Groped by name %s", gropedByName));

        //Вивести тільки ті імена, які зустрічаються більше 1 разу
        Map<String, List<User>> gropedByNameNew = users.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(gropedByNameNew);
        var a = gropedByNameNew.entrySet().stream().filter(e -> e.getValue().size() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(a);

        //Задача 1: Знайти всіх користувачів, яким більше ніж 30 років

        System.out.println(users.stream().filter(u -> u.getAge() > 30).collect(Collectors.toList()));
        //Знайти імена всіх користувачів

        System.out.println(users.stream().map(User::getName).toList());
        //Чи є хоча б один користувач віком 25 років
        System.out.println(users.stream().anyMatch(u -> u.getAge() == 25));

        //Задача 4: Порахувати скільки користувачів мають вік > 30
        System.out.println(users.stream().filter(u -> u.getAge() > 30).count());

        //Задача 5: Знайти користувача з найбільшим віком
        System.out.println(users.stream().max(Comparator.comparing(User::getAge)).stream().collect(Collectors.toList()));

        //Задача 6: Згрупувати користувачів за віком

        Map<Integer, List<User>> gropedByAge1 = users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(String.format("Groped by age: %s", gropedByAge1));

        //Задача 7: Отримати середній вік користувачів and Округлити середній вік до цілого collectingAndThen

        Long avgInt = users.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(User::getAge), Math::round));
        System.out.println(avgInt);

        users.stream().filter(u -> u.getAge() > 18)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list ->{
                            if (list.isEmpty()) {
                                throw new IllegalStateException("No adult users found");
                            }
                            return Collections.unmodifiableList(list);
                        }
                    ));

        System.out.println("*************************** Потрібно відібрати всіх користувачів, яким більше 18 років, і повернути список їхніх імен.");
        System.out.println(users.stream().filter(u->u.getAge()>18).map(User::getName).collect(Collectors.toList()));

        System.out.println("Є список користувачів. Потрібно знайти ім’я найстаршого користувача.\n" +
                "Якщо список порожній — повернути \"No users\".");

        System.out.println(users.stream().max(Comparator.comparing(User::getAge)).map(User::getName).orElse("No user"));

        Map<Integer, List<String>> gropedNamesOfUsers = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
Map<Integer, Long> countedByAge = users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
users.stream().filter(u->u.getAge()>=18).min(Comparator.comparing(User::getAge)).map(User::getName).orElse("No adult");
    }


}
