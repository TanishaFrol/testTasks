import java.util.Arrays;
import java.util.Scanner;

/*
����� ��������� � ���������� ��������� �������.
����������� ����� ����� ���������� A ������ � �����.
�� ��� ��������� ����� �������� B �������� ��������-�������.
���� ����� ������ �� ����� �������, �� ������ ���������
�������� ����� ������ ��� C ������.
����� ��������� ��������� D �������� ��������-������� � ��������� �����.
�������� ��� ���������, �� ������� ������ ��� ��������� ��������.
*/
public class Task1 {
    private static String[] data;
    private static int A;
    private static int B;
    private static int C;
    private static int D;
    private static boolean validationOK;

    public static void main(String[] args) {
        getData();
        inputDataValidation();
        initialize();
        solution();
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        data = in.nextLine().split("\\s");
    }

    private static void inputDataValidation() {
        if (data.length != 4) {
            System.out.println("Invalid input data, please, enter 4 positive integers");
            validationOK = false;
        } else {
            try {
                parseInputDataArray();
            } catch (Exception e) {
                System.out.println("Invalid input data: 1 <= A,B,C,D <= 100");
                validationOK = false;
            }
        }
    }

    private static void parseInputDataArray() throws Exception {
        validationOK = Arrays.asList(data).stream().noneMatch(x -> Integer.parseInt(x) < 1 || Integer.parseInt(x) > 100);
        if (!validationOK) {
            System.out.println("Invalid input data: 1 <= A,B,C,D <= 100");
        }
    }

    private static void initialize() {
        if (validationOK) {
            A = Integer.parseInt(data[0]);
            B = Integer.parseInt(data[1]);
            C = Integer.parseInt(data[2]);
            D = Integer.parseInt(data[3]);
        }
    }

    private static void solution() {
        if (validationOK) {
            if (B >= D) {
                System.out.print(A);
            } else {
                System.out.print(A + (D - B) * C);
            }
        }
    }
}
