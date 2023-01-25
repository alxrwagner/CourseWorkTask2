import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inputText();
    }

    public static void inputText(){
        System.out.println("Введите текст: ");
        String text = sc.nextLine();
        System.out.println("Количество слов тексте: " + Stream.of(text.split(" ")).count());
        Map<String, Integer> repeatWords = Stream.of(text.split(" ")).collect(Collectors.toMap(s -> s, s-> 1, Integer::sum));

        repeatWords.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(e -> System.out.println(e.getValue() + " - " + e.getKey()));

    }
}