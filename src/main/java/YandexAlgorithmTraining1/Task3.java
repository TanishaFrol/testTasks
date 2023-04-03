package YandexAlgorithmTraining1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Телефонные номера в адресной книге мобильного телефона имеют один из следующих форматов:
        +7<код><номер>, 8<код><номер>, <номер>,
где <номер> — это семь цифр, а <код> — это три цифры или три цифры в круглых скобках.
Если код не указан, то считается, что он равен 495. Кроме того, в записи телефонного номера может стоять знак “-”
между любыми двумя цифрами (см. пример). На данный момент в адресной книге телефона Васи записано всего три
телефонных номера, и он хочет записать туда еще один. Но он не может понять, не записан ли уже такой номер
в телефонной книге. Помогите ему! Два телефонных номера совпадают, если у них равны коды и равны номера.
Например, +7(916)0123456 и 89160123456 — это один и тот же номер.
*/

public class Task3 {
    private static List<String> telNumberList = new ArrayList<>();
    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            telNumberList.add(reader.readLine());
            while (reader.ready()) {
                telNumberList.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void solution() {
        editNumbers();
        String newTelNumber = telNumberList.get(0);
        String newTelCodeNumber;
        String shortNewTelNumber;
        if (newTelNumber.length() == 10) {
            newTelCodeNumber = telNumberList.get(0).substring(0, 3);
            shortNewTelNumber = telNumberList.get(0).substring(3);
        } else {
            newTelCodeNumber = "495";
            shortNewTelNumber = telNumberList.get(0);
        }
        findSameNumbers(newTelNumber, newTelCodeNumber, shortNewTelNumber);
    }
    private static void editNumbers() {
        for (int i = 0; i < telNumberList.size(); i++) {
            String editedNumber = telNumberList.get(i).replaceAll("-", "").replaceAll("\\(", "").replaceAll("\\)", "");
            if (editedNumber.startsWith("+7")) {
                editedNumber = editedNumber.substring(2);
            } else if (editedNumber.startsWith("8") && editedNumber.length() == 11) {
                editedNumber = editedNumber.substring(1);
            }
            telNumberList.set(i, editedNumber);
        }
    }
    private static void findSameNumbers(String newTelNumber, String newTelCodeNumber, String shortNewTelNumber) {
        for (int i = 1; i < telNumberList.size(); i++) {
            if (telNumberList.get(i).length() == 10 && newTelNumber.length() == 10) {
                if (telNumberList.get(i).equals(newTelNumber)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (telNumberList.get(i).length() == 10 && newTelNumber.length() != 10) {
                if (telNumberList.get(i).equals(newTelCodeNumber+shortNewTelNumber)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (telNumberList.get(i).length() == 7 && newTelCodeNumber.equals("495")) {
                if (telNumberList.get(i).equals(shortNewTelNumber)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
