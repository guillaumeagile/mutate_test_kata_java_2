package fr.mutation.kata2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NFormatTests {
    @Test
    public void NFormat0() {
        var sut = new NFormat();
        var sb = new StringBuilder("0123456789");
        sut.extracted2(sb);
        Assertions.assertThat(sb.toString()).isEqualTo("0123456789liste trop longue");
    }

    @Test
    public void NFormat9() {
        var sut = new NFormat();
        var sb = new StringBuilder("9");
        sut.extracted2(sb);

        Assertions.assertThat(sb.toString()).isEqualTo("9");
    }

    //@Test CE TEST NE TUE PAS LES MUTANTS
    public void NFormat_11car() {
        var sut = new NFormat();
        var sb = new StringBuilder("0123456789A");
        sut.extracted2(sb);

        Assertions.assertThat(sb.toString()).isEqualTo("0123456789Aliste trop longue");

    }
}
