package YandexTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Кузя снова не успел сдать реферат по языковым разнообразиям в срок. «Наверное, у меня какая-то неоптимальная
клавиатура...» — подумал Кузя и решил изобрести самую оптимальную клавиатуру для набора одним пальцем.
Кузя решил, что его клавиатура будет содержать N рядов с клавишами (разные ряды могут содержать разные количества
клавиш). Все клавиши на клавиатуре будут уникальными.
Чтобы оценить качество клавиатуры для набора определённого текста, Кузя ввёл понятие «разнорядности»:
•	Пусть текст представляет из себя строку S длины K;
•	Назовём переход между соседними в тексте символами Si?1 и Si(2?i?K) разнорядным, если данные символы находятся на различных рядах клавиатуры;
•	Разнорядность равна количеству разнорядных переходов при наборе текста на заданной клавиатуре.

Например, пусть текст S равен ABCAD, а клавиатура содержит два ряда клавиш AC и BD.
В таком случае при наборе текста будет ровно 3 разнорядных перехода:
1.	S1=A в S2=B (ряд 1 в ряд 2);
2.	S2=B в S3=C (ряд 2 в ряд 1);
3.	S4=A в S5=D (ряд 1 в ряд 2).
Вас, как лучшего игрока в Тетрис среди знакомых, Кузя просит вычислить разнорядность созданной им
клавиатуры на последнем из Кузиных рефератов.
*/

public class Exam1 {
    private static int N;
    private static int K;
    private static int[] cList;
    private static int[] rList;
    private static int[] sList;

    private static Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(bufferedReader.readLine());
            cList = new int[N];
            cList = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(num -> Integer.parseInt(num)).toArray();
            rList = new int[N];
            rList = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(num -> Integer.parseInt(num)).toArray();
            for(int i = 0; i < N; i++) {
                hashmap.put(cList[i], rList[i]);
            }
            K = Integer.parseInt(bufferedReader.readLine());
            sList = new int[K];
            sList = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(num -> Integer.parseInt(num)).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution() {
        int lastRow = hashmap.get(sList[0]);
        int count = 0;
        for (int i = 0; i < K; i++) {
            if (lastRow != hashmap.get(sList[i])) {
                count++;
                lastRow = hashmap.get(sList[i]);
            }
        }
        System.out.println(count);
    }
}

