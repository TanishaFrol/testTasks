package YandexTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
К Новому-преновому году работники Тындекса построили N ледяных скульптур, i-я скульптура состоит из ai килограмм льда.
Но они не посоветовались с Кузей! А ведь Кузя знает, что идеальная скульптура состоит из
ровно X килограмм льда, не больше и не меньше.
Новый-преновый год уже совсем скоро, до него осталось всего T минут.
За одну минуту Кузя может выбрать одну скульптуру и добавить или удалить ровно 1 килограмм льда из неё.
Вас, как отличника художественной школы, Кузя просит найти максимальное количество идеальных скульптур в момент наступления праздника.
*/
public class Exam2 {
    private static int sculpturesNumber;
    private static int perfectIceAmount;
    private static long remainingMinutes;
    private static int[] iceInSculptures;
    private static List<Integer> difference = new ArrayList<>();
    private static int perfectSculpturesCount = 0;
    private static List<Integer> perfectSculptures = new ArrayList<>();

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            sculpturesNumber = Integer.parseInt(bufferedReader.readLine());
            iceInSculptures = new int[sculpturesNumber];
            iceInSculptures = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(num -> Integer.parseInt(num)).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution() {
        for (int i = 0; i < sculpturesNumber; i++) {
            difference.add(Math.abs(iceInSculptures[i] - perfectIceAmount));
        }
        findPerfectSculptures();
        System.out.println(perfectSculpturesCount);
        if (perfectSculpturesCount != 0) {
            for (int i = 0; i < perfectSculpturesCount; i++) {
                System.out.print(perfectSculptures.get(i) + " ");
            }
        }
    }
    private static void findPerfectSculptures() {
        int min = Collections.min(difference);
        int minIndex = difference.indexOf(min);
        if (remainingMinutes - min >= 0) {
            remainingMinutes = remainingMinutes - (long)min;
            perfectSculpturesCount++;
            perfectSculptures.add(minIndex + 1);
            difference.set(minIndex, Integer.MAX_VALUE);
            findPerfectSculptures();
        }
    }
}


