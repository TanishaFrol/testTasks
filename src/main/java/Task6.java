import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
На физкультуре происходит разбиение по двум командам. Ребята выстроены в шеренгу,
у каждого из них есть свой рост ai. Разбиение по командам произойдет по принципу «четный-нечетный» —
все школьники с четным ростом отправляются в одну команду, а нечетные — в другую.
В отличие от привычного урока, ребята не выстроились по росту.
Вместо привычного порядка они встали случайно. Теперь физрук Яша смотрит на шеренгу и думает —
может ли ровно одна пара учеников поменяться местами так, чтобы команды оказались такими же,
как и по принципу «первый-второй». Иначе говоря, он хочет получить такой порядок, при котором все ученики
с четным ростом стоят на четных позициях, а с нечетным — на нечетных.

Помогите Яше найти нужную замену.
*/
public class Task6 {
    private static String[] data;
    private static int n;
    private static int[] heights;
    private static boolean validationOK;

    public static void main(String[] args) {
        getData();
        inputDataValidation();
        initialize();
        solution();
    }
    private static void getData() {
        Scanner in = new Scanner(System.in);
        try {
            n = in.nextInt();
            in.nextLine();
            in.nextLine();
            data = in.nextLine().split("\\s");
            validationOK = true;
        } catch (Exception e) {
            System.out.println("Invalid input data: 2 <= n <= 1000");
            validationOK = false;
        }
    }
    private static void inputDataValidation() {
        if (validationOK) {
            if (n < 2 || n > 1000) {
                System.out.println("Invalid input data: 2 <= n <= 1000");
                validationOK = false;
            } else if (data.length != n) {
                System.out.println("Invalid input data");
                validationOK = false;
            } else {
                try {
                    parseInputDataArray();
                } catch (Exception e) {
                    System.out.println("Invalid input data: 1 <= ai <= 10^9");
                    validationOK = false;
                }
            }
        }
    }
    private static void parseInputDataArray() throws Exception {
        validationOK = Arrays.asList(data).stream().noneMatch(x -> Integer.parseInt(x) < 1 || Integer.parseInt(x) > Math.pow(10, 9));
        if (!validationOK) {
            System.out.println("Invalid input data: 1 <= ai <= 10^9");
        }
    }
    private static void initialize() {
        if (validationOK) {
            heights = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                heights[i] = Integer.parseInt(data[i]);
            }
        }
    }
    private static void solution() {
        if (validationOK) {
            List<Integer> evens = new ArrayList<>();
            List<Integer> odds = new ArrayList<>();
            int countFalseEvens = 0;
            int countFalseOdds = 0;
            int ai = 0;
            int aj = 0;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i]%2 == 0) {
                    odds.add(heights[i]);
                } else {
                    evens.add(heights[i]);
                }
            }
            if ((Math.abs(odds.size() - evens.size()) > 1) || odds.size() > evens.size()) {
                System.out.println("-1 -1");
            } else {
                for (int i = 0; i < heights.length; i=i+2) {
                    if (heights[i]%2 == 0) {
                        countFalseEvens++;
                        ai = i + 1;
                    }
                }
                for (int j = 1; j < heights.length; j=j+2) {
                    if (heights[j]%2 != 0) {
                        countFalseOdds++;
                        aj = j + 1;
                    }
                }
                if (countFalseEvens == 1 && countFalseOdds == 1) {
                    System.out.println(ai + " " + aj);
                } else {
                    System.out.println("-1 -1");
                }
            }
        }
    }
}

