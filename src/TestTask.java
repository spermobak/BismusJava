import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestTask {

    static void firstTask() {
        System.out.print("Введите число: ");
        try {
            var numb = reader().trim();
            if (!numb.isEmpty()) {
                if (isDouble(numb)) {
                    if (Double.parseDouble(numb) > 7) {
                        System.out.println("Привет");
                    } else {
                        System.out.println("Введенное число меньше 7");
                    }
                } else {
                    System.out.println("Видимо вы ввели что-то кроме числа или не число вовсе");
                }
            } else {
                System.out.println("Вы ничего не ввели");
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
    }

    static void secondTask() {
        System.out.print("Введите имя: ");
        try {
            String name = reader();
            if (!name.isEmpty()) {
                if (Objects.equals(name, "Вячеслав")) {
                    System.out.println("Привет " + name);
                } else {
                    System.out.println("Нет такого имени");
                }
            } else {
                System.out.println("Вы ничего не ввели");
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
    }

    static void thirdTask() {
        System.out.println("Чтобы ввести свой массив введите: own\nЧтобы ввести массив случайной величины со случайными элементми введите: random");
        try {
            String answer = reader();
            if (!answer.isEmpty()) {
                if (answer.equals("own")) {
                    System.out.println("Введите элементы массив через проблел: ");
                    readArray(reader());
                } else if (answer.equals("random")) {
                    int[] array = randomIntArray();
                    System.out.println("Массив: " + Arrays.toString(array));
                    multiplesOfThree(array);
                } else {
                    System.out.println("Вы ввели что-то отличное от пунктов выбора");
                }

            } else {
                System.out.println("Вы ничего не ввели");
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
    }


    static String reader() throws IOException {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            return br.readLine();
//        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    static int[] randomIntArray() {
        int rand = (int) (Math.random() * 20) + 1;
        int[] array = new int[rand];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 + 1);
        }
        return array;
    }

    static void multiplesOfThree(int[] array) {
        List<Integer> listMultiples = new ArrayList<>();
        for (int j : array) {
            if (j % 3 == 0)
                listMultiples.add(j);
        }
        if (!listMultiples.isEmpty()) {
            System.out.println("Элементы кратные 3: " + listMultiples);
        } else {
            System.out.println("Не нйдено элементов удовлетворяющих  условию");
        }
    }

    static void readArray(String string) {
        if (!string.isEmpty() && string.matches("^[0-9\\s]+$")) {
            multiplesOfThree(toArray(string));
        } else {
            System.out.println("Вы ничего не ввели или ввели что-то помимо цифр и пробела");
        }
    }

    static int[] toArray(String string) {
        String[] elem = string.split(" ");
        int[] array = new int[elem.length];
        for (int i = 0; i < elem.length; i++) {
            array[i] = Integer.parseInt(elem[i]);
        }
        return array;
    }

    static void menu() {
        System.out.print("""
                _______________
                1 - Составить алгоритм: если введенное число больше 7, то вывести 'Привет'
                2 - Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести 'Привет Вячеслав', если нет, то вывести 'Нет такого имени'
                3 - Составить алгоритм: на входе есть числовой массив, необходимо вывести элементы массива кратные 3
                Введите номер задания:\s""");
        try {
            String answer = reader();
            if (answer.matches("^[1-3]+$")) {
                switch (answer) {
                    case "1" -> firstTask();
                    case "2" -> secondTask();
                    case "3" -> thirdTask();
                }
            } else {
                System.out.println("Вы ввели что-то отличное от пунктов выбора");
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }

    }

    public static void main(String[] args) {
        menu();
    }
}
