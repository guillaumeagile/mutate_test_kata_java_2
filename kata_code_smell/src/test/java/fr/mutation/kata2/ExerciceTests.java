package fr.mutation.kata2;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junitparams.JUnitParamsRunner;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class ExerciceTests {

    @Before
    public void initialise() {
    }

    // !!! pour comprendre comment marche une Map/HashMap en java, lisez ceci:  https://www.data-transitionnumerique.com/java-hashmap/

    @Test
    public void listeVide() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        //when
        Map<Integer, String> actual = exercice.f1(1, listeEntiers);
        //ASSERT
        Entry<Integer, String> firstResult = actual.entrySet().iterator().next();
        //dans le 1er element de la Map<Int, String> on trouve la clé qui est une entier qui contient le nombre d'entiers positifs trouvés
        // eton trouve dans la valeur <String> de cette map, la chaine de caractère

        assertThat(firstResult.getKey(), is(0));

        Assertions.assertThat(firstResult.getKey()).isZero();  //cette ligne c'est la même chose que la précédente, choisissez l'écriture qui vous plait le plus

        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("\n");
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
        Entry<Integer, String> firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isZero();
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("8 \n");
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
        Entry<Integer, String> firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isEqualTo(2);
        //2e verification:  que contient la chaine de caractère?
        Assertions.assertThat(firstResult.getValue()).isEqualTo("\n");
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
        Entry<Integer, String> firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isEqualTo(1);
        Assertions.assertThat(firstResult.getValue()).isEqualTo("9 \n");
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
        Entry<Integer, String> firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isEqualTo(1);
        Assertions.assertThat(firstResult.getValue()).isEqualTo("4 9 8 \n");
    }

    @Test
    public void listeAvecTroisPositifsLimiteA2() {  // Il reste, un mutant en vie:  le corriger ici
        //given  / ARRANGE
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(1);
        listeEntiers.add(9);
        listeEntiers.add(8);

        //when / ACT
        Map<Integer, String> actual = exercice.f1(2, listeEntiers);
        //then / ASSERT
        Entry<Integer, String> firstResult = actual.entrySet().iterator().next();
        Assertions.assertThat(firstResult.getKey()).isZero();
        Assertions.assertThat(firstResult.getValue()).isEqualTo("1 9 \n");
    }

/*   EXERCICE : une fois obtenue un Test Strength de 100%, trouvez quels sont les tests qui ne servent à rien...
    */
}
