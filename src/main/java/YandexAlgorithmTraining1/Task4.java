package YandexAlgorithmTraining1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task4 {
    private static double a;
    private static double b;
    private static double c;

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            a = Double.parseDouble(reader.readLine());
            b = Double.parseDouble(reader.readLine());
            c = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void solution() {
        double x;
        if (c < 0) {
            System.out.println("NO SOLUTION");
        } else if (a == 0 && b == 0 && c == 0) {
            System.out.println("MANY SOLUTIONS");
        } else if (a == 0 && b == (c * c)) {
            System.out.println("MANY SOLUTIONS");
        } else if (a == 0 && b != (c * c)) {
            System.out.println("NO SOLUTION");
        } else {
            x = (c * c - b) / a;
            if (x %1 != 0 || (a * x + b) < 0) {
                System.out.println("NO SOLUTION");
            } else {
                System.out.println((int)x);
            }
        }
    }
}

