package fr.mutation.kata2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExerciceTests {



    // !!! pour comprendre comment marche une Map/HashMap en java, lisez ceci:  https://www.data-transitionnumerique.com/java-hashmap/

    @Test
    public void listeVide() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        //when
        Map<Integer, String> actual = exercice.f1(1, listeEntiers);
        //ASSERT
        Entry<Integer, String> dualResult = actual.entrySet().iterator().next();
        //dans le 1er element de la Map<Int, String> on trouve la clé qui est une entier qui contient le nombre d'entiers positifs trouvés
        // eton trouve dans la valeur <String> de cette map, la chaine de caractère


        Assertions.assertThat(dualResult.getKey()).isZero();


        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(dualResult.getValue()).isEqualTo("\n");
    }

    @Test
    public void listeAvecUnEntierPositif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(8);
        //when
        Map<Integer, String> actual = exercice.f1(1, listeEntiers);
        //then
        Entry<Integer, String> dualResult = actual.entrySet().iterator().next();
        Assertions.assertThat(dualResult.getKey()).isZero();
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(dualResult.getValue()).isEqualTo("8 \n");
    }

    // @Test
    public void listeAvecDeuxEntiersNegatifs() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-1);
        listeEntiers.add(-2);
        //when
        Map<Integer, String> actual = exercice.f1(2, listeEntiers);
        //then
        Entry<Integer, String> dualResult = actual.entrySet().iterator().next();
        Assertions.assertThat(dualResult.getKey()).isEqualTo(2);
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(dualResult.getValue()).isEqualTo("\n");
    }

    @Test
    public void listeAvecUnPositifEtUnNegatif() {  // ce test est-il utile?
        //given  / ARRANGE
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-9);
        listeEntiers.add(9);
        //when / ACT
        Map<Integer, String> actual = exercice.f1(2, listeEntiers);
        //then / ASSERT
        Entry<Integer, String> dualResult = actual.entrySet().iterator().next();
        Assertions.assertThat(dualResult.getKey()).isEqualTo( (2 - 1));
        Assertions.assertThat(dualResult.getValue()).isEqualTo("9 \n");
    }

    @Test
    public void listeAvecTroisPositifsEtUnNeg() {  // règle des 3 A
        //given  / ARRANGE
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(4);   //1
        listeEntiers.add(9);    //2
        listeEntiers.add(8);    //3
        listeEntiers.add(-8);   //4
        listeEntiers.add(-9);   // non pris en compte

        //when / ACT
        Map<Integer, String> actual = exercice.f1(4, listeEntiers);
        //then / ASSERT
        Entry<Integer, String> dualResult = actual.entrySet().iterator().next();
        Assertions.assertThat(dualResult.getKey()).isEqualTo(1);
        Assertions.assertThat(dualResult.getValue()).isEqualTo("4 9 8 \n");
    }
    
    // lancer les tests avec du code coverage
    // puis lancer les tests avec PItest: mvn test -P pitest

    //  EXERCICE 1:  Il reste trop de mutants en vie:  les corriger avec des nouveaux tests
    //  important: 1 nouveau test pour tuer 1 mutant à la fois

    // EXERCICE 2: monter pitest au niveau STRONGER


    @Test
    public void listeAvecTroisPositifsLimiteA2() {  //  EXERCICE 2:  Il reste un mutant en vie:  le corriger ici
        //given  / ARRANGE
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(1);
        listeEntiers.add(9);
        listeEntiers.add(8);

        //when / ACT
        Map<Integer, String> actual = exercice.f1(2, listeEntiers);
        //then / ASSERT
        Entry<Integer, String> dualResult = actual.entrySet().iterator().next();

    }



/*   EXERCICE 3 : une fois obtenu un Test Strength de 100%, trouvez quels sont les tests qui ne servent à rien...
    */

    // EXERCICE 4: finir le refactoring en nommant correctement les variables
    // et en supprimant les lignes inutiles ou stupides
}
