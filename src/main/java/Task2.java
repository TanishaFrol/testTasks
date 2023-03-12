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
    private static boolean noInputDataException;

    public static void main(String[] args) {
        getData();
        inputDataValidation();
        solution();
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        try {
            N = in.nextInt();
            noInputDataException = true;
        } catch (Exception e) {
            System.out.println("Invalid input data: 1 <= N <= 2*10^9");
            noInputDataException = false;
        }
    }

    private static void inputDataValidation() {
        if (noInputDataException) {
            if (N < 1 || N > 2 * Math.pow(10, 9)) {
                System.out.println("Invalid input data, the number of pieces cannot be less than 1 and more than 2*10^9");
                validationOK = false;
            } else {
                validationOK = true;
            }
        }
    }

    private static void solution() {
        if (validationOK) {
            int x = 0;
            int y = 1;

            while (y < N) {
                x += 1;
                y *= 2;
            }
            System.out.println(x);
        }
    }
}
