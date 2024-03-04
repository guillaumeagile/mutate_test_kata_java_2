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
        Result dualResult = exercice.f2(1, listeEntiers);
        //ASSERT

        Assertions.assertThat(dualResult.a()).isZero();

        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(dualResult.b()).isEqualTo("\n");
    }

    @Test
    public void listeAvecUnEntierPositif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(8);
        //when
        Result dualResult = exercice.f2(1, listeEntiers);
        //then
        Assertions.assertThat(dualResult.a()).isZero();
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(dualResult.b()).isEqualTo("8 \n");
    }

    @Test
    public void listeAvecDeuxEntiersNegatifs() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-1);
        listeEntiers.add(-2);
        //when
        Result dualResult = exercice.f2(2, listeEntiers);
        //then
        Assertions.assertThat(dualResult.a()).isEqualTo(2);
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(dualResult.b()).isEqualTo("\n");
    }

    @Test
    public void listeAvecUnPositifEtUnNegatif() {  // ce test est-il utile?
        //given  / ARRANGE
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-9);
        listeEntiers.add(9);
        //when / ACT
        Result dualResult = exercice.f2(2, listeEntiers);
        //then / ASSERT
        Assertions.assertThat(dualResult.a()).isEqualTo( (2 - 1));
        Assertions.assertThat(dualResult.b()).isEqualTo("9 \n");
    }

    @Test
    public void listeAvec2PositifsEt0Neg() {  // règle des 3 A
        //given  / ARRANGE
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(4);   //1
        listeEntiers.add(9);    //2

        //when / ACT
        Result dualResult = exercice.f2(1, listeEntiers);
        //then / ASSERT
        Assertions.assertThat(dualResult.a()).isZero();
        Assertions.assertThat(dualResult.b()).isEqualTo("4 \n");
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
        Result dualResult = exercice.f2(4, listeEntiers);
        //then / ASSERT
        Assertions.assertThat(dualResult.a()).isEqualTo(1);
        Assertions.assertThat(dualResult.b()).isEqualTo("4 9 8 \n");
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
        Result dualResult = exercice.f2(2, listeEntiers);
        //then / ASSERT


    }



/*   EXERCICE 3 : une fois obtenu un Test Strength de 100%, trouvez quels sont les tests qui ne servent à rien...
    */

    // EXERCICE 4: finir le refactoring en nommant correctement les variables
    // et en supprimant les lignes inutiles ou stupides
}
