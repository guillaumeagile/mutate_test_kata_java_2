package fr.mutation.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Exercice {

    public Map<Integer, String> f1(int a1, List<Integer> a2) {
        HashMap<Integer, String> a7 = new HashMap<Integer, String>();
        int a5 = 0;
        StringBuilder a9 = new StringBuilder();
        //
        for (int a3 = 0;
             (
                     (a3 < a2.size() )
                     && (a3 < a1)
             );
             a3++
        ) {
            int a6 = a2.get(a3);
            int a10 = a6 - 1;
            if (
                    (a6 >= 0)
                 && ((a10) < 20)) {
                a9.append(a6).append(" ");
            } else {
                a5++;
            }
        }
        extracted(a9);
        a7.put(a5, a9.toString());
        return a7;
    }

    private static void extracted(StringBuilder str) {
        str.append("\n");
    }
}
