package YandexTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Андрей работает в секретной химической лаборатории, в которой производят опасную кислоту с удивительными свойствами.
У Андрея есть n бесконечно больших резервуаров, расположенных в один ряд. Изначально в каждом резервуаре находится
некоторое количество кислоты. Начальство Андрея требует, чтобы во всех резервуарах содержался одинаковый объем кислоты.
К сожалению, разливающий аппарат несовершенен. За одну операцию он способен разлить по одному литру кислоты в каждый
из первых k (1?k?n) резервуаров. Обратите внимание, что для разных операций k могут быть разными.
Поскольку кислота очень дорогая, Андрею не разрешается выливать кислоту из резервуаров.
Андрей просит вас узнать, можно ли уравнять объемы кислоты в резервуарах, и, если это возможно,
то посчитать минимальное количество операций, которое потребуется, чтобы этого достичь.
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
