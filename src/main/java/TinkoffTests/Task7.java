package TinkoffTests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
В школе перед Новым Годом устраивают игру в Тайного Санту. Каждому ученику i выдается ученик ai,
которому он должен подарить подарок. Костя, как администратор игры, определил каждому школьнику свое число ai.
Но потом его коллега Маша спросила: А правда ли, что если начать цепочку подарков от школьника 1 к школьнику a1,
потом a1 и так далее, то цепочка замкнется на школьнике 1, после того, как задействует всех остальных учеников
ровно по одному разу?
Костя не знает, правда это или нет, но он собирается изменить ровно одно число ai, чтобы получить конфигурацию,
которая устроит Машу. Помогите ему с этим.

3
1 2 3
3
3 1 3
3
1 3 1
6
3 4 2 5 1 2

*/

public class Task7 {
    private static String[] inputLine1;
    private static String[] inputLine2;
    private static int n;
    private static int[] receivers;
    private static int cycleCounter;

    public static void main(String[] args) {
        getData();
        solution();
    }

    private static void getData() {
        Scanner in = new Scanner(System.in);
        inputLine1 = in.nextLine().split("\\s");
        n = Integer.parseInt(inputLine1[0]);

        inputLine2 = in.nextLine().split("\\s");
        receivers = new int[n];
        for (int i = 0; i < receivers.length; i++) {
            receivers[i] = Integer.parseInt(inputLine2[i]);
        }
    }

    private static void solution() {
        class Top {
            int number;
            int grade;
            Top(int number) {
                this.number = number;
                this.grade = 0;
            }
            @Override
            public String toString() {
                return "Top{" + number + ", " + grade + '}';
            }
        }

        List<Top> tops = new ArrayList<>();
        for (int i = 0; i < receivers.length; i++) {
            tops.add(new Top(i + 1));
        }

        //System.out.println("Çàïîëíÿåì ëèñò âåðøèíàìè: " + tops);

        for (int i = 0; i < receivers.length; i++) {
            tops.get(receivers[i] - 1).grade++;
        }

        //System.out.println("Ïðîñòàâëÿåì ó âåðøèí ñòåïåíè: " + tops);

        int countTops = 0;
        for (Top t : tops) {
            if (t.grade != 1) {
                countTops++;
            }
        }
        //System.out.println("Ñ÷èòàåì, ó êàêèõ âåðøèí ñòåïåíè íå ðàâíû åäèíèöå, åñëè èõ êîëè÷åñòâî íå äâà, òî ðåøåíèÿ íåò");
        if (countTops == 2) {
            int topX = tops.stream().filter(x -> x.grade == 0).findFirst().get().number;
            int topY = tops.stream().filter(x -> x.grade == 2).findFirst().get().number;
            //System.out.println("Ñìîòðèì, ó êàêîé âåðøèíû ñòåïåíü ðàâíà 0: x = " + topX + "\nÑìîòðèì, ó êàêîé âåðøèíû ñòåïåíü ðàâíà 2: y = " + topY);
            List<Integer> wrongPositions = new ArrayList<>();
            for (int i = 0; i < receivers.length; i++) {
                if (receivers[i] == topY) {
                    wrongPositions.add(i);
                }
            }
            //System.out.println("Íàõîäèì â èñõîäíîì ìàññèâå èíäåêñû â êîòîðûõ çàïèñàíû çíà÷åíèÿ ðàâíûå âåðøèíå ñî ñòåïåíüþ 2 ");
            //System.out.println("è ìåíÿåì â èñõîäíîì ìàññèâå îäèí èç òàêèõ èíäåêñîâ íà çíà÷åíèå âåðøèíû ñ íóëåâîé ñòåïåíüþ");
            receivers[wrongPositions.get(0)] = topX;
            //System.out.println("íîâûé ìàññèâ: " + Arrays.toString(receivers));
            //System.out.println("ïðîâåðÿåì öèêëè÷íîñòü");
            repeat(0, 0);
            if (cycleCounter == receivers.length) {
                System.out.println(wrongPositions.get(0) + 1 + " " + topX);
            } else {
                //System.out.println("\nåðâûé âàðèàíò íå ïîäîøåë, ïðîáóåì âòîðîé");
                receivers[wrongPositions.get(0)] = topY;
                receivers[wrongPositions.get(1)] = topX;
                //System.out.println("íîâûé ìàññèâ: " + Arrays.toString(receivers));
                //System.out.println("ïðîâåðÿåì öèêëè÷íîñòü");
                cycleCounter = 0;
                repeat(0, 0);
                if (cycleCounter == receivers.length) {
                    System.out.println(wrongPositions.get(1) + 1 + " " + topX);
                } else {
                    System.out.println("-1 -1");
                }
            }
        } else {
            System.out.println("-1 -1");
        }
    }

    static void repeat(int temp, int c) {
        int tempNext = receivers[temp] - 1;
        cycleCounter++;
        //System.out.print("( " + temp + " " + cycleCounter + " )");
        if (tempNext != 0 && cycleCounter < receivers.length) {
            repeat(tempNext, cycleCounter);
        }
    }
}
