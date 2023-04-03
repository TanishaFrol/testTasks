package YandexAlgorithmTraining1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
� �����, ��� �������� ����������� ����, ���������� ����������� ������ ����. ���� ����������� ���������� ������ ��������� � ����������.
� ������������ ���� ����� ���� ��� ����������� ���������: �������� ����������� � ����� ������.

����������� ����� �������� � ��������� ������� �������:

�freeze� � ����������. � ���� ������ ����������� ����� ������ ��������� �����������. ���� ����������� � ������� � ��� �� ������ ��������, �� �� �����������.
�heat� � ������. � ���� ������ ����������� ����� ������ ����������� �����������. ���� ����������� � ������� � ��� �� ������ ��������, �� �� �����������.
�auto� � �������������� �����. � ���� ������ ����������� ����� ��� �����������, ��� � ��������� ����������� � ������� �� ��������.
�fan� � ����������. � ���� ������ ����������� ������������ ������ ���������� ������� � �� �������� ����������� � �������.

����������� ���������� ������, ������� ��� ��������� �� ���������� ����� ������ �� �� ��� ������� ����������� � ������� �� ��������.
��������� �������� ���������, ������� �� �������� ����������� � ������� troom, ������������� �� ������������ �������� ����������� tcond �
������ ������ ���������� �����������, ������� ����������� � ������� ����� ���.
*/
public class Task1 {
    private static int roomTemp;
    private static int condTemp;
    private static String condMode;
    private static int[] inputData;
    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputData = new int[2];
            inputData = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(num -> Integer.parseInt(num)).toArray();
            roomTemp = inputData[0];
            condTemp = inputData[1];
            condMode = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution() {
        if (condMode.equals("freeze")) {
            freeze();
        } else if (condMode.equals("heat")) {
            heat();
        } else if (condMode.equals("auto")) {
            auto();
        }  else if (condMode.equals("fan")) {
            fan();
        }
    }
    private static void freeze() {
        if (roomTemp < condTemp) {
            System.out.println(roomTemp);
        } else {
            System.out.println(condTemp);
        }
    }
    private static void heat() {
        if (roomTemp > condTemp) {
            System.out.println(roomTemp);
        } else {
            System.out.println(condTemp);
        }
    }
    private static void auto() {
        System.out.println(condTemp);
    }

    private static void fan() {
        System.out.println(roomTemp);
    }
}
