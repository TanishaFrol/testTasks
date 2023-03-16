import java.util.*;

public class Task4 {
    private static int amountNumber;
    private static int amountNumberToChange;
    private static int[] numbersOnTheList;
    private static long differenceSum = 0;

    public static void main(String[] args) {
        getData();
        solution();
    }

    public static void getData() {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split("\\s");
        amountNumber = Integer.parseInt(data[0]);
        amountNumberToChange = Integer.parseInt(data[1]);
        String[] list = in.nextLine().split("\\s");
        numbersOnTheList = new int[amountNumber];
        for (int i = 0; i < amountNumber; i++) {
            numbersOnTheList[i] = Integer.parseInt(list[i]);
        }
    }

    public static void solution() {
        List<Long> values = new ArrayList<>();
        for (int i = 0; i < amountNumber; i++) {
            int weight = 1;
            while (numbersOnTheList[i] > 0) {
                int actualNumber = numbersOnTheList[i] % 10;
                long increase = (9 - actualNumber) * weight;
                values.add(increase);
                weight *= 10;
                numbersOnTheList[i] /= 10;
            }
        }
        differenceSum = values.stream()
                .sorted(Comparator.reverseOrder())
                .limit(amountNumberToChange)
                .reduce(0l, Long::sum);
        System.out.println(differenceSum);
    }
}