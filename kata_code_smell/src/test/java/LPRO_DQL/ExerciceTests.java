package LPRO_DQL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
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
        final var actual = exercice.f1(1, listeEntiers);
        //ASSERT
        var firstResult = actual.entrySet().iterator().next();
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
        listeEntiers.add(1);
        //when
        final var actual = exercice.f1(1, listeEntiers);
        var firstResult = actual.entrySet().iterator().next();
        //then
        Assertions.assertThat(firstResult.getKey()).isZero();
    }

    @Test
    public void listeAvecUnEntierNegatif() {
        //given
        final Exercice exercice = new Exercice();
        final List<Integer> listeEntiers = new ArrayList<>();
        listeEntiers.add(-1);
        //when
        final var actual = exercice.f1(1, listeEntiers);
        var firstResult = actual.entrySet().iterator().next();
        //then
        Assertions.assertThat(firstResult.getKey()).isEqualTo(1);

    }

/*
    @Test
    @Parameters({
            "actual, expected"
    })
    public void beTestable(String actual, String expected) {
      assertThat((actual), is(expected));
    }*/
}
