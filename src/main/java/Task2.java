import java.util.Scanner;

/*
¬ан€ принес на кухню рулет, который он хочет разделить с коллегами.
ƒл€ этого он хочет разрезать рулет на N равных частей.
–азумеетс€, рулет можно резать только поперек.
—оотвественно,  ост€ сделает N-1 разрез ножом через равные промежутки.
ѕо возвращению с кофе-брейка ¬ан€ задумалс€ Ч а можно ли было обойтись
меньшим числом движений, будь нож ¬ани бесконечно длинным
(иначе говор€, если он мог бы сделать сколько угодно разрезов за раз,
если эти разрезы лежат на одной пр€мой)?
—читаетс€, что места дл€ разрезов намечены заранее, и все разрезы делаютс€ с ювелирной точностью.
ќказываетс€, что можно. Ќапример, если ¬ан€ хотел бы разделить рулет на 4 части,
он мог бы обойтись двум€ разрезами Ч сначала он разделил бы рулет на две половинки,
а потом совместил бы две половинки и разрезал обе пополам одновременно.
¬ам дано число N, требуетс€ сказать, каким минимальным числом разрезов можно обойтись.
*/

public class Task2 {
    private static int N;
    private static boolean validationOK;

    public static void main(String[] args) {
        while (true) {
            getData();
            inputDataValidation();
            solution();
        }
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        try {
            N = in.nextInt();
            validationOK = true;
        } catch (Exception e) {
            System.out.println("Invalid input data: 1 <= N <= 2*10^9");
            validationOK = false;
        }
    }

    private static void inputDataValidation() {
        if (validationOK) {
            if (N < 1 || N > 2 * Math.pow(10, 9)) {
                System.out.println("Invalid input data: 1 <= N <= 2*10^9");
                validationOK = false;
            } else {
                validationOK = true;
            }
        }
    }

    private static void solution() {
        if (validationOK) {
            System.out.println((int) Math.ceil(log2(N)));
        }
    }

    public static double log2(int x) {
        return Math.log(x) / Math.log(2);
    }
}