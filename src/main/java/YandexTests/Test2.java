package YandexTests;
/*
� �������� n ����� � �� ��� ������ ����� � ������ � ������ ����. ������� ������ (A � F) ��������� � ����,
����������� (C � D) � � �������. �� ����������� �������� ������ �� ������, ���� ��� ���� ����������.
��� ������ ������ �����, �� ���� �� ����� ���� � �� ����� �������: ����� ��� ������.
��������, ������ �� ���� ���������� ����� ����� �� ������ B � C, �� �� ����� ����� �� ������ C � D,
������ ��� ��� ��������� ��������, � ����� �� ����� ����� �� ������ A � C, ������ ��� ����� ��� �������� �� �����.
����� ����, ���� �� ���������� ������ ������ ����� �������������� � �� ����� ����� ���� � ����, ���� � �������.
������� ��, ������ ������ �� ���������� ����� ������ ����� � ���� � ��� ����� ������� �������,
���� ����� ��� ������ ������ �� �������� ����� �������. ��� ������ ������ ���������� ����������,
���� �� ����� � ��������, ���������� ��� ���.

������ �����
������ ������ �������� �����
n (1<=n<=100) � ���������� ����� � ��������. ����� � n ������� �������� ����������� �������� � �������� �� �����
(�� ������� �� n-��), ��� ��������� . (�����) ���������� ��������� �����, ��������� # (�������) ���������� �������
�����, � ��������� _ (������ �������������) ��������� ������ ����� �������� C � D ������� ����.
��������� ������ �������� ����� m (1<=m<=100) � ���������� ����� ����������. ����� � m ������� ���������� ��������
����� ����������. ������ �������� �����: num side position, ��� num � ���������� ���������� (����� 1, 2 ��� 3),
side � �������� ������� �������� (������ left ��� right), position � �������� ����� ��������������� ���������
(������ aisle ��� window).

������ ������
���� ������ ����� ����� �� �����, ��������������� �� �����������, �� �������� ������ Passengers can take seats:
� ������ �� ���� � ������� rowletter, ������������� �� ����������� ����� �����. ����� �������� � n ������� ������������
�������� � ��������, � �������, ��������� ����, ������ �����, ������� ������� ������� ����������, ������ ���� ���������� �������� X.
���� ������ �� ����� ����� �����, ��������������� �� �����������, �� �������� ������ Cannot fulfill passengers requirements.
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test2 {
    private static int rowsNumber;
    private static List<StringBuilder> rowsList = new ArrayList<>();
    private static int passengerGroupsNumber;
    private static List<String> wishList = new ArrayList<>();
    private static int[][] leftRows;
    private static int[][] rightRows;

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        rowsNumber = in.nextInt();
        in.nextLine();
        for (int i = 0; i < rowsNumber; i++) {
            rowsList.add(new StringBuilder(in.nextLine()));
        }
        passengerGroupsNumber = in.nextInt();
        in.nextLine();
        for (int i = 0; i < passengerGroupsNumber; i++) {
            wishList.add(in.nextLine());
        }
    }

    private static void solution() {
        createLeftRowsArray();
        createRightRowsArray();
        for (int i = 0; i < wishList.size(); i++) {
            String[] passengerWish = wishList.get(i).split("\\s");
            findPlace(Integer.parseInt(passengerWish[0]), passengerWish[1], passengerWish[2]);
        }
    }

    private static void createLeftRowsArray() {
        leftRows = new int[rowsNumber][3];
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < 3; j++) {
                if (String.valueOf(rowsList.get(i)).split("")[j].equals(".")) {
                    leftRows[i][j] = 0;
                } else {
                    leftRows[i][j] = 1;
                }
            }
        }
    }

    private static void createRightRowsArray() {
        rightRows = new int[rowsNumber][3];
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < 3; j++) {
                if (String.valueOf(rowsList.get(i)).split("")[j + 4].equals(".")) {
                    rightRows[i][j] = 0;
                } else {
                    rightRows[i][j] = 1;
                }
            }
        }
    }

    private static void findPlace(int passengersCount, String side, String position) {
        if (side.equals("left")) {
            findInLeftRaw(passengersCount, position);
        }
        else {
            findInRightRaw(passengersCount, position);
        }
    }

    private static void findInLeftRaw(int passengersCount, String position) {
        if (position.equals("window")) {
            findNearLeftWindow(passengersCount);
        } else {
            findNearLeftAisle(passengersCount);
        }
    }

    private static void findNearLeftAisle(int passengersCount) {
        int count = 0;
        int row = 0;
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 2; j > 2 - passengersCount; j--) {
                if (count == passengersCount) {
                    break;
                }
                if (j == 2) {
                    count = 0;
                }
                if (leftRows[i][j] == 0) {
                    count++;
                    row = i + 1;
                } else {
                    count = 0;
                }
            }
        }
        if (count == passengersCount) {

            switch (passengersCount) {
                case 1:
                    System.out.printf("Passengers can take seats: %sC%n", row);
                    leftRows[row - 1][2] = 1;
                    rowsList.get(row - 1).replace(2, 3, "X");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(2, 3, "#");
                    break;
                case 2:
                    System.out.printf("Passengers can take seats: %sB %sC%n", row, row);
                    leftRows[row - 1][2] = 1;
                    leftRows[row - 1][1] = 1;
                    rowsList.get(row - 1).replace(1, 3, "XX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(1, 3, "##");
                    break;
                case 3:
                    System.out.printf("Passengers can take seats: %sA %sB %sC%n", row, row, row);
                    leftRows[row - 1][2] = 1;
                    leftRows[row - 1][1] = 1;
                    leftRows[row - 1][0] = 1;
                    rowsList.get(row - 1).replace(0, 3, "XXX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(0, 3, "###");
                    break;
            }
        } else {
            System.out.println("Cannot fulfill passengers requirements");
        }
    }

    private static void findNearLeftWindow(int passengersCount) {
        int count = 0;
        int row = 0;
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < passengersCount; j++) {
                if (count == passengersCount) {
                    break;
                }
                if (j == 0) {
                    count = 0;
                }
                if (leftRows[i][j] == 0) {
                    count++;
                    row = i + 1;
                } else {
                    count = 0;
                }
            }
        }
        if (count == passengersCount) {
            switch (passengersCount) {
                case 1:
                    System.out.printf("Passengers can take seats: %sA%n", row);
                    leftRows[row - 1][0] = 1;
                    rowsList.get(row - 1).replace(0, 1, "X");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(0, 1, "#");
                    break;
                case 2:
                    System.out.printf("Passengers can take seats: %sA %sB%n", row, row);
                    leftRows[row - 1][0] = 1;
                    leftRows[row - 1][1] = 1;
                    rowsList.get(row - 1).replace(0, 2, "XX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(0, 2, "##");
                    break;
                case 3:
                    System.out.printf("Passengers can take seats: %sA %sB %sC%n", row, row, row);
                    leftRows[row - 1][0] = 1;
                    leftRows[row - 1][1] = 1;
                    leftRows[row - 1][2] = 1;
                    rowsList.get(row - 1).replace(0, 3, "XXX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(0, 3, "###");
                    break;
            }
        } else {
            System.out.println("Cannot fulfill passengers requirements");
        }
    }

    private static void findInRightRaw(int passengersCount, String position) {
        if (position.equals("window")) {
            findNearRightWindow(passengersCount);
        } else {
            findNearRightAisle(passengersCount);
        }
    }

    private static void findNearRightWindow(int passengersCount) {
        int count = 0;
        int row = 0;
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 2; j > 2 - passengersCount; j--) {
                if (count == passengersCount) {
                    break;
                }
                if (j == 2) {
                    count = 0;
                }
                if (rightRows[i][j] == 0) {
                    count++;
                    row = i + 1;
                } else {
                    count = 0;
                }
            }
        }
        if (count == passengersCount) {
            switch (passengersCount) {
                case 1:
                    System.out.printf("Passengers can take seats: %sF%n", row);
                    rightRows[row - 1][2] = 1;
                    rowsList.get(row - 1).replace(6, 7, "X");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(6, 7, "#");
                    break;
                case 2:
                    System.out.printf("Passengers can take seats: %sE %sF%n", row, row);
                    rightRows[row - 1][2] = 1;
                    rightRows[row - 1][1] = 1;
                    rowsList.get(row - 1).replace(5, 7, "XX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(5, 7, "##");
                    break;
                case 3:
                    System.out.printf("Passengers can take seats: %sD %sE %sF%n", row, row, row);
                    rightRows[row - 1][2] = 1;
                    rightRows[row - 1][1] = 1;
                    rightRows[row - 1][0] = 1;
                    rowsList.get(row - 1).replace(4, 7, "XXX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(4, 7, "###");
                    break;
            }
        } else {
            System.out.println("Cannot fulfill passengers requirements");
        }
    }

    private static void findNearRightAisle(int passengersCount) {
        int count = 0;
        int row = 0;
        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < passengersCount; j++) {
                if (count == passengersCount) {
                    break;
                }
                if (j == 0) {
                    count = 0;
                }
                if (rightRows[i][j] == 0) {
                    count++;
                    row = i + 1;
                } else {
                    count = 0;
                }
            }
        }
        if (count == passengersCount) {
            switch (passengersCount) {
                case 1:
                    System.out.printf("Passengers can take seats: %sD%n", row);
                    rightRows[row - 1][0] = 1;
                    rowsList.get(row - 1).replace(4, 5, "X");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(4, 5, "#");
                    break;
                case 2:
                    System.out.printf("Passengers can take seats: %sD %sE%n", row, row);
                    rightRows[row - 1][0] = 1;
                    rightRows[row - 1][1] = 1;
                    rowsList.get(row - 1).replace(4, 6, "XX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(4, 6, "##");
                    break;
                case 3:
                    System.out.printf("Passengers can take seats: %sD %sE %sF%n", row, row, row);
                    rightRows[row - 1][0] = 1;
                    rightRows[row - 1][1] = 1;
                    rightRows[row - 1][2] = 1;
                    rowsList.get(row - 1).replace(4, 7, "XXX");
                    for (StringBuilder str : rowsList) {
                        System.out.println(str);
                    }
                    rowsList.get(row - 1).replace(4, 7, "###");
                    break;
            }
        } else {
            System.out.println("Cannot fulfill passengers requirements");
        }
    }
}
