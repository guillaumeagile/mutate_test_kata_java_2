package LPRO_DQL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Exercice {

    public Map<Integer, String> f1(int a1, List<Integer> a2) {
        HashMap<Integer, String> a7 = new HashMap<Integer, String>();
        int a5 = 0;
        String a9 = "";
        for (int a3 = 0; a3 < a2.size() && a3 < a1; a3++) {
            int a6 = a2.get(a3);
            if (a6 >= 0) {
                a9 = a9 + (a6 + " ");
            } else {
                a5++;
            }
        }
        a9 += ("\n");
        a7.put(a5, a9);
        return a7;
    }
}
