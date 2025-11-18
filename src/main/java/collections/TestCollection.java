package collections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "John", "Anna", "Mike", "John");
        System.out.println(names.stream().distinct().toList());

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> mappedList = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mappedList);

        List<String> words1 = Arrays.asList("elephant", "cat", "dog", "hippo");
        System.out.println(Arrays.toString(words1.stream().min(Comparator.comparing(String::length)).stream().toArray()));

     //   4. Знайти перше слово, що починається з "A"
        List<String> names1 = Arrays.asList("Bob", "Alice", "Anna", "Mike");
        System.out.println(names1.stream().filter(s->s.startsWith("A")).toList());

        //5. Об’єднати список рядків в один рядок через кому
        List<String> parts = Arrays.asList("QA", "Dev", "PM");
        System.out.println(String.join(",", parts));

        //6. Отримати список квадратів чисел, але без повторів
        List<Integer> numbers = Arrays.asList(2, 3, 3, 4, 5, 2);
        System.out.println(numbers.stream().map(n->n*n).distinct().toList());

        //7. Відсортувати список рядків за довжиною (від меншої до більшої)
        List<String> names2 = Arrays.asList("John", "Alexander", "Ann", "Bob");
        System.out.println(names2.stream().sorted(Comparator.comparingInt(String::length)).toList());
    }


}
