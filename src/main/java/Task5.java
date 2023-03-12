import java.util.Arrays;
import java.util.Scanner;

/*
Во время разработки некоторой задачи Саша решил сгенерировать несколько новых тестов.
Каждый тест Саши должен представлять собой натуральное число, не меньшее l и не большее r.
Кроме того, натуральное число в тесте обязательно должно состоять из одинаковых цифр.

Например, число 999 подходит под это требование, а число 123 — нет.
Какое максимальное число различных тестов сможет создать Саша?
*/

public class Task5 {
    private static String[] data;
    private static long l;
    private static long r;
    private static boolean validationOK;

    public static void main(String[] args) {
        getData();
        inputDataValidation();
        initialize();
        solution();
    }
    private static void getData() {
        Scanner in = new Scanner(System.in);
        data = in.nextLine().split("\\s");
    }
    private static void inputDataValidation() {
        if (data.length != 2) {
            System.out.println("Invalid input data, please, enter 2 positive integers");
            validationOK = false;
        } else {
            try {
                parseInputDataArray();
            } catch (Exception e) {
                System.out.println("Invalid input data: 1 <= l, r <= 10^18");
                validationOK = false;
            }
        }
    }
    private static void parseInputDataArray() throws Exception {
        validationOK = Arrays.asList(data).stream().noneMatch(x -> Long.parseLong(x) < 1 || Long.parseLong(x) > 1.0E18);
        if (!validationOK) {
            System.out.println("Invalid input data: 1 <= l, r <= 10^18");
        }
    }
    private static void initialize() {
        if (validationOK) {
            l = Long.parseLong(data[0]);
            r = Long.parseLong(data[1]);
        }
    }
    private static void solution() {
        if (validationOK) {
            long count = 0;
            for (long k = 1; k < 18; ++k) {
                for (long u = 0; u++ < 9; ) {
                    long repdigit = (long) (u * ((Math.pow(10, k) - 1) / 9));
                    if (repdigit >= l && repdigit <= r) {
                        count++;
                    } else {
                        continue;
                    }
                }
            }
            System.out.println(count);
            System.out.println(Math.pow(10, 18));
        }
    }
}

