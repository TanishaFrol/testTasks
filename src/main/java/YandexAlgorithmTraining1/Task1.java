package YandexAlgorithmTraining1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
В офисе, где работает программист Петр, установили кондиционер нового типа. Этот кондиционер отличается особой простотой в управлении.
У кондиционера есть всего лишь два управляемых параметра: желаемая температура и режим работы.

Кондиционер может работать в следующих четырех режимах:

«freeze» — охлаждение. В этом режиме кондиционер может только уменьшать температуру. Если температура в комнате и так не больше желаемой, то он выключается.
«heat» — нагрев. В этом режиме кондиционер может только увеличивать температуру. Если температура в комнате и так не меньше желаемой, то он выключается.
«auto» — автоматический режим. В этом режиме кондиционер может как увеличивать, так и уменьшать температуру в комнате до желаемой.
«fan» — вентиляция. В этом режиме кондиционер осуществляет только вентиляцию воздуха и не изменяет температуру в комнате.

Кондиционер достаточно мощный, поэтому при настройке на правильный режим работы он за час доводит температуру в комнате до желаемой.
Требуется написать программу, которая по заданной температуре в комнате troom, установленным на кондиционере желаемой температуре tcond и
режиму работы определяет температуру, которая установится в комнате через час.
*/
public class Task1 {
    private static int roomTemp;
    private static int condTemp;
    private static String condMode;
    private static int[] inputData;
    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputData = new int[2];
            inputData = Arrays.stream(bufferedReader.readLine().split("\\s")).mapToInt(num -> Integer.parseInt(num)).toArray();
            roomTemp = inputData[0];
            condTemp = inputData[1];
            condMode = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution() {
        if (condMode.equals("freeze")) {
            freeze();
        } else if (condMode.equals("heat")) {
            heat();
        } else if (condMode.equals("auto")) {
            auto();
        }  else if (condMode.equals("fan")) {
            fan();
        }
    }
    private static void freeze() {
        if (roomTemp < condTemp) {
            System.out.println(roomTemp);
        } else {
            System.out.println(condTemp);
        }
    }
    private static void heat() {
        if (roomTemp > condTemp) {
            System.out.println(roomTemp);
        } else {
            System.out.println(condTemp);
        }
    }
    private static void auto() {
        System.out.println(condTemp);
    }

    private static void fan() {
        System.out.println(roomTemp);
    }
}
