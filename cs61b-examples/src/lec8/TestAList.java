package lec8;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestAList {
    @Test
    public void insertTest() {
        lec8.AList<Integer> L = new AList<>();
        L.addLast(0);
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.insert(2, 54188);

        int actual = L.get(2);
        int expected = 54188;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void addAndGetFirstTest() {
        lec8.AList<Integer> L = new AList<>();
        L.addFirst(1);
        int actualFirst = L.getFirst();
        int expectedFirst = 1;

        assertThat(actualFirst).isEqualTo(expectedFirst);
    }
}
