package YandexTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
������ �������� � ��������� ���������� �����������, � ������� ���������� ������� ������� � ������������� ����������.
� ������ ���� n ���������� ������� �����������, ������������� � ���� ���. ���������� � ������ ���������� ���������
��������� ���������� �������. ���������� ������ �������, ����� �� ���� ����������� ���������� ���������� ����� �������.
� ���������, ����������� ������� ������������. �� ���� �������� �� �������� ������� �� ������ ����� ������� � ������
�� ������ k (1?k?n) �����������. �������� ��������, ��� ��� ������ �������� k ����� ���� �������.
��������� ������� ����� �������, ������ �� ����������� �������� ������� �� �����������.
������ ������ ��� ������, ����� �� �������� ������ ������� � �����������, �, ���� ��� ��������,
�� ��������� ����������� ���������� ��������, ������� �����������, ����� ����� �������.
*/

public class Test1 {
    private static int n;
    private static List<Integer> aList = new ArrayList<>();
    private static boolean validationOK;

    public static void main(String[] args) {
        getData();
        inputDataValidation();
        solution();
    }

    private static void getData() {
        try {
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            for (int i = 0; i < n; i++) {
                aList.add(in.nextInt());
            }
            validationOK = true;
        } catch (Exception e) {
            validationOK = false;
        }
    }

    private static void inputDataValidation() {
        if (validationOK) {
            if (aList.size() != n) {
                validationOK = false;
            } else {
                if (checkN() && checkList()) {
                    validationOK = true;
                } else {
                    validationOK = false;
                }

            }
        }
    }

    private static boolean checkN() {
        if (n >= 1 && n <= 1000000) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkList() {
        return validationOK = aList.stream().noneMatch(ai -> ai < 1 || ai > Math.pow(10, 9));
    }

    private static void solution() {
        if (validationOK) {
            List<Integer> init = List.copyOf(aList);
            Collections.sort(aList);
            if (init.equals(aList)) {
                aList.stream().distinct();
                int max = Collections.max(aList);
                int min = Collections.min(aList);
                System.out.println(max - min);
            } else {
                System.out.println(-1);
            }
        }
    }
}
