import java.util.Arrays;
import java.util.Scanner;

/*
У Кати насыщенный день на работе. Ей надо передать n разных договоров коллегам.
Все встречи происходят на разных этажах, а между этажами можно перемещаться только по лестничным пролетам —
считается, что это улучшает физическую форму сотрудников. Прохождение каждого пролета занимает ровно 1 минуту.
Сейчас Катя на парковочном этаже, планирует свой маршрут. Коллег можно посетить в любом порядке,
но один из них покинет офис через t минут. С парковочного этажа лестницы нет — только лифт,
на котором можно подняться на любой этаж.
В итоге план Кати следующий:
    Подняться на лифте на произвольный этаж.
            Считается, что лифт поднимается на любой этаж за 0 минут.
    Передать всем коллегам договоры, перемещаясь между этажами по лестнице.
            Считается, что договоры на этаже передаются мгновенно.
    В первые t минут передать договор тому коллеге, который планирует уйти.
    Пройти минимальное количество лестничных пролетов.
Помогите Кате выполнить все пункты ее плана.
*/
public class Task3 {
    private static String[] inputLine1;
    private static String[] inputLine2;
    private static String[] inputLine3;
    private static int[] floors;
    private static int employeesNumber;
    private static int t;
    private static int togoNumber;
    private static boolean validationOK;


    public static void main(String[] args) {
        getData();
        inputDataValidation();
        initialize();
        solution();
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        inputLine1 = in.nextLine().split("\\s");
        in.nextLine();
        inputLine2 = in.nextLine().split("\\s");
        in.nextLine();
        inputLine3 = in.nextLine().split("\\s");
    }

    private static void inputDataValidation() {
        checkInputLine1();
        checkInputLine2();
        checkInputLine3();
    }

    private static void checkInputLine1() {
        if (inputLine1.length != 2) {
            System.out.println("Invalid input data, please, enter 2 positive integers");
            validationOK = false;
        } else {
            try {
                validationOK = Arrays.asList(inputLine1).stream().noneMatch(x -> Integer.parseInt(x) < 2 || Integer.parseInt(x) > 100);
                if (!validationOK) {
                    System.out.println("Invalid input data: 2 <= n,t <= 100");
                }
            } catch (Exception e) {
                System.out.println("Invalid input data: 2 <= n,t <= 100");
                validationOK = false;
            }
        }
    }

    private static void checkInputLine2() {
        if (validationOK) {
            long floorsNumberWithoutRepeats = Arrays.asList(inputLine2).stream().distinct().count();
            int floorsCount = Integer.parseInt(inputLine1[0]);
            if (inputLine2.length != floorsCount) {
                System.out.println("Invalid input data");
                validationOK = false;
            } else if (inputLine2.length != floorsNumberWithoutRepeats) {
                System.out.println("Invalid input data");
                validationOK = false;
            } else {
                try {
                    validationOK = Arrays.asList(inputLine2).stream().noneMatch(x -> Integer.parseInt(x) < 1 || Integer.parseInt(x) > 100);
                    if (!validationOK) {
                        System.out.println("Invalid input data: 1 <= each floor <= 100");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input data: 1 <= each floor <= 100");
                    validationOK = false;
                }
            }
        }
    }

    private static void checkInputLine3() {
        if (validationOK) {
            if (inputLine3.length != 1) {
                System.out.println("Invalid input data, please, enter 1 positive integer");
                validationOK = false;
            } else {
                try {
                    validationOK = Arrays.asList(inputLine3).stream().noneMatch(x -> Integer.parseInt(x) < 1 || Integer.parseInt(x) > inputLine2.length);
                    if (!validationOK) {
                        System.out.println("Invalid input data: 1 <= x <= floors number");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input data: 1 <= x <= floors number");
                    validationOK = false;
                }
            }
        }
    }

    private static void initialize() {
        if (validationOK) {
            employeesNumber = Integer.parseInt(inputLine1[0]);
            t = Integer.parseInt(inputLine1[1]);
            floors = new int[employeesNumber];
            for (int i = 0; i < floors.length; i++) {
                floors[i] = Integer.parseInt(inputLine2[i]);
            }
            togoNumber = Integer.parseInt(inputLine3[0]);
        }
    }

    private static void solution() {
        if (validationOK) {
            int maxFloor = floors[floors.length - 1];
            int minFloor = floors[0];
            int togoFirstFloor = floors[togoNumber - 1];
            if ((togoFirstFloor - minFloor) <= t || (maxFloor - togoFirstFloor) <= t) {
                System.out.println(maxFloor - minFloor);
            } else {
                if ((maxFloor - togoFirstFloor) < (togoFirstFloor - minFloor)) {
                    System.out.println(maxFloor - minFloor + maxFloor - togoFirstFloor);
                } else {
                    System.out.println(maxFloor - minFloor + togoFirstFloor - minFloor);
                }
            }
        }
    }
}