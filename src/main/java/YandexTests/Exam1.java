package YandexTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
���� ����� �� ����� ����� ������� �� �������� ������������� � ����. ���������, � ���� �����-�� �������������
����������...� � ������� ���� � ����� ��������� ����� ����������� ���������� ��� ������ ����� �������.
���� �����, ��� ��� ���������� ����� ��������� N ����� � ��������� (������ ���� ����� ��������� ������ ����������
������). ��� ������� �� ���������� ����� �����������.
����� ������� �������� ���������� ��� ������ ������������ ������, ���� ��� ������� ��������������:
�	����� ����� ������������ �� ���� ������ S ����� K;
�	������ ������� ����� ��������� � ������ ��������� Si?1 � Si(2?i?K) �����������, ���� ������ ������� ��������� �� ��������� ����� ����������;
�	������������� ����� ���������� ����������� ��������� ��� ������ ������ �� �������� ����������.

��������, ����� ����� S ����� ABCAD, � ���������� �������� ��� ���� ������ AC � BD.
� ����� ������ ��� ������ ������ ����� ����� 3 ����������� ��������:
1.	S1=A � S2=B (��� 1 � ��� 2);
2.	S2=B � S3=C (��� 2 � ��� 1);
3.	S4=A � S5=D (��� 1 � ��� 2).
���, ��� ������� ������ � ������ ����� ��������, ���� ������ ��������� ������������� ��������� ��
���������� �� ��������� �� ������� ���������.
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

