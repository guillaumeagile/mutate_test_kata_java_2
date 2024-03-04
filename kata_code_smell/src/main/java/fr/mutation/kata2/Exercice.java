package fr.mutation.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Exercice {


    public Result f2(int a1, List<Integer> a2) {
        int a5 = 0;
        StringBuilder a9 = new StringBuilder();
        for (int a3 = 0; a3 < a2.size() && a3 < a1; a3++) {
            int a6 = a2.get(a3);
            int a10 = a6 - 1;
            if (a6 >= 0 && (a10) < 20) {
                a9.append(a6).append(" ");
            } else {
                a5++;
            }
        }
        a9.append("\n");

        return new Result(a5, a9.toString());
    }
}
