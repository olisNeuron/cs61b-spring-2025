package lec7;
import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

public class AListTest {
    @Test
    public void testGetLast() {
        AList L = new AList();
        L.addLast(1);
        L.addLast(2);

        assertThat(L.getLast()).isEqualTo(2);
    }

    @Test
    public void testAddAndGet() {
        AList L = new AList();
        L.addLast(1);
        L.addLast(2);

        assertThat(L.get(0)).isEqualTo(1);
        assertThat(L.get(1)).isEqualTo(2);
    }

    @Test
    public void testRemovalLast() {
        AList L = new AList();
        L.addLast(1);
        L.addLast(2);

        assertThat(L.removeLast()).isEqualTo(2);
    }

    @Test
    public void add200Item() {
        AList L = new AList();
        for (int i = 0; i <= 200; i++) {
            L.addLast(i);
        }
        for (int i = 0; i <= 200; i++) {
            assertThat(L.get(i)).isEqualTo(i);        }
    }
}
