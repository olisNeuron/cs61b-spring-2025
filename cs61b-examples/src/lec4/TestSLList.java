package lec4;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestSLList {
    @Test
    public void getTest() {
        SLList<Integer> L = new SLList<>(0);
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        assertThat(L.get(0)).isEqualTo(0);
        assertThat(L.get(1)).isEqualTo(1);
        assertThat(L.get(2)).isEqualTo(2);
        assertThat(L.get(3)).isEqualTo(3);
    }

    @Test
    public void longestTest() {
        SLList<String> L = new SLList<>("a");
        L.addLast("aa");
        L.addLast("aaa");
        L.addLast("aaaa");
        String actual = L.longest(L);

        assertThat(L.longest(L)).isEqualTo("aaaa");
    }
}
