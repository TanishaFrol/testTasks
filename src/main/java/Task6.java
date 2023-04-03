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
    private static String[] inputLine1;
    private static String[] inputLine2;
    private static int n;
    private static int[] heights;

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        inputLine1 = in.nextLine().split("\\s");
        n = Integer.parseInt(inputLine1[0]);

        inputLine2 = in.nextLine().split("\\s");
        heights = new int[n];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(inputLine2[i]);
        }
    }

    private static void solution() {
        int countFalseEvens = 0;
        int countFalseOdds = 0;
        int ai = 0;
        int aj = 0;
        for (int i = 0; i < heights.length; i = i + 2) {
            if (heights[i] % 2 == 0) {
                countFalseEvens++;
                ai = i + 1;
            }
        }
        for (int j = 1; j < heights.length; j = j + 2) {
            if (heights[j] % 2 != 0) {
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

