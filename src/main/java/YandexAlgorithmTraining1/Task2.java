package YandexAlgorithmTraining1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
���� ��� ����������� �����. �������� �� ��������� ����������� � ������ ���������.
���� ��� ��������, �������� ������ YES, ����� �������� ������ NO.

����������� � ��� ��� �����, �� ������� �� ����� ������.
*/

public class Task2 {
    private static int side1;
    private static int side2;
    private static int side3;

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            side1 = Integer.parseInt(reader.readLine());
            side2 = Integer.parseInt(reader.readLine());
            side3 = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution() {
        if (((side1 + side2) > side3) && ((side1 + side3) > side2) && ((side2 + side3) > side1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
