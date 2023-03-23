import java.util.Scanner;

/*
� ���� ���������� ���� �� ������. �� ���� �������� n ������ ��������� ��������.
��� ������� ���������� �� ������ ������, � ����� ������� ����� ������������ ������ �� ���������� �������� �
���������, ��� ��� �������� ���������� ����� �����������. ����������� ������� ������� �������� ����� 1 ������.
������ ���� �� ����������� �����, ��������� ���� �������. ������ ����� �������� � ����� �������,
�� ���� �� ��� ������� ���� ����� t �����. � ������������ ����� �������� ��� � ������ ����,
�� ������� ����� ��������� �� ����� ����.
� ����� ���� ���� ���������:
    ��������� �� ����� �� ������������ ����.
            ���������, ��� ���� ����������� �� ����� ���� �� 0 �����.
    �������� ���� �������� ��������, ����������� ����� ������� �� ��������.
            ���������, ��� �������� �� ����� ���������� ���������.
    � ������ t ����� �������� ������� ���� �������, ������� ��������� ����.
    ������ ����������� ���������� ���������� ��������.
�������� ���� ��������� ��� ������ �� �����.
*/

public class Task3 {
    private static String[] inputLine1;
    private static String[] inputLine2;
    private static String[] inputLine3;
    private static int employeesCount;
    private static int t;
    private static int[] floors;
    private static int togoNumber;
    private static Scanner in;

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        in = new Scanner(System.in);
        inputLine1 = in.nextLine().split("\\s");
        employeesCount = Integer.parseInt(inputLine1[0]);
        t = Integer.parseInt(inputLine1[1]);
        inputLine2 = in.nextLine().split("\\s");
        floors = new int[employeesCount];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = Integer.parseInt(inputLine2[i]);
        }
        inputLine3 = in.nextLine().split("\\s");
        togoNumber = Integer.parseInt(inputLine3[0]);
    }
    private static void solution() {
        int maxFloor = floors[floors.length - 1];
        int minFloor = floors[0];
        int togoFirstFloor = floors[togoNumber - 1];
        if ((togoFirstFloor - minFloor) <= t || (maxFloor - togoFirstFloor) <= t) {
            System.out.println(Math.abs(maxFloor - minFloor));
        } else {
            if ((maxFloor - togoFirstFloor) < (togoFirstFloor - minFloor)) {
                System.out.println(maxFloor - minFloor + maxFloor - togoFirstFloor);
            } else {
                System.out.println(maxFloor - minFloor + togoFirstFloor - minFloor);
            }
        }
    }
}