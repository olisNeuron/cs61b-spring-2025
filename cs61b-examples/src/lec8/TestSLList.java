package lec8;

import lec8.SLList;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestSLList {
    @Test
    public void getTest() {
        lec4.SLList<Integer> L = new lec4.SLList<>(0);
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        assertThat(L.get(0)).isEqualTo(0);
        assertThat(L.get(1)).isEqualTo(1);
        assertThat(L.get(2)).isEqualTo(2);
        assertThat(L.get(3)).isEqualTo(3);
    }

    @Test
    public void getLastTest() {
        lec8.SLList<Integer> L = new SLList<>(0);
    }
}
