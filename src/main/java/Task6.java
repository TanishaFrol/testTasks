import java.util.Scanner;

/*
�� ����������� ���������� ��������� �� ���� ��������. ������ ��������� � �������,
� ������� �� ��� ���� ���� ���� ai. ��������� �� �������� ���������� �� �������� �������-�������� �
��� ��������� � ������ ������ ������������ � ���� �������, � �������� � � ������.
� ������� �� ���������� �����, ������ �� ����������� �� �����.
������ ���������� ������� ��� ������ ��������. ������ ������ ��� ������� �� ������� � ������ �
����� �� ����� ���� ���� �������� ���������� ������� ���, ����� ������� ��������� ������ ��,
��� � �� �������� �������-������. ����� ������, �� ����� �������� ����� �������, ��� ������� ��� �������
� ������ ������ ����� �� ������ ��������, � � �������� � �� ��������.

�������� ��� ����� ������ ������.
*/

public class Task6 {
    private static String[] inputLine1;
    private static String[] inputLine2;
    private static int n;
    private static int[] heights;

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        inputLine1 = in.nextLine().split("\\s");
        n = Integer.parseInt(inputLine1[0]);

        inputLine2 = in.nextLine().split("\\s");
        heights = new int[n];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(inputLine2[i]);
        }
    }

    private static void solution() {
        int countFalseEvens = 0;
        int countFalseOdds = 0;
        int ai = 0;
        int aj = 0;
        for (int i = 0; i < heights.length; i = i + 2) {
            if (heights[i] % 2 == 0) {
                countFalseEvens++;
                ai = i + 1;
            }
        }
        for (int j = 1; j < heights.length; j = j + 2) {
            if (heights[j] % 2 != 0) {
                countFalseOdds++;
                aj = j + 1;
            }
        }
        if (countFalseEvens == 1 && countFalseOdds == 1) {
            System.out.println(ai + " " + aj);
        } else {
            System.out.println("-1 -1");
        }
    }
}

