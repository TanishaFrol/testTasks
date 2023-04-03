import java.util.Scanner;

/*
���� ������ �� ����� �����, ������� �� ����� ��������� � ���������.
��� ����� �� ����� ��������� ����� �� N ������ ������.
����������, ����� ����� ������ ������ �������.
�������������, ����� ������� N-1 ������ ����� ����� ������ ����������.
�� ����������� � ����-������ ���� ��������� � � ����� �� ���� ��������
������� ������ ��������, ���� ��� ���� ���������� �������
(����� ������, ���� �� ��� �� ������� ������� ������ �������� �� ���,
���� ��� ������� ����� �� ����� ������)?
���������, ��� ����� ��� �������� �������� �������, � ��� ������� �������� � ��������� ���������.
�����������, ��� �����. ��������, ���� ���� ����� �� ��������� ����� �� 4 �����,
�� ��� �� �������� ����� ��������� � ������� �� �������� �� ����� �� ��� ���������,
� ����� ��������� �� ��� ��������� � �������� ��� ������� ������������.
��� ���� ����� N, ��������� �������, ����� ����������� ������ �������� ����� ��������.
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