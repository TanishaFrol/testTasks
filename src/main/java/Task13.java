import java.util.Scanner;

/*
�� ����������� ������ ����� �������� ��� ����� �����, �� ������� -32000 � �� ������� 32000.
�� ����������� ����� ������ ����������� ����� ���� �����.
����� �������� �� ������ � ������. ���������� ������� ����� ������ � ����� ���� �����������.
������ ������ � ����� �����������.
*/

public class Task13 {
    private static short A;
    private static short B;
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
            A = in.nextShort();
            B = in.nextShort();
            noInputDataException = true;
        } catch (Exception e) {
            System.out.println("Invalid input data: -32000 <= A,B <= 32000");
            noInputDataException = false;
        }
    }
    private static void inputDataValidation() {
        if (noInputDataException) {
            if (A < -32000 || A > 32000 || B < -32000 || B > 32000) {
                System.out.println("Invalid input data: -32000 <= A,B <= 32000");
                validationOK = false;
            } else {
                validationOK = true;
            }
        }
    }

    private static void solution() {
        if (validationOK) {
            System.out.print(A + B);
        }
    }
}

