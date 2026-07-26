import deque.ArrayDeque61B;

import deque.Deque61B;
import jh61b.utils.Reflection;
import org.apache.hc.core5.annotation.Internal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

//     @Test
//     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
//     void noNonTrivialFields() {
//         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
//                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
//                 .toList();
//
//         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
//     }

    @Test
    public void add_first_from_empty() {
        Deque61B<String> ad1 = new ArrayDeque61B<>();

        ad1.addFirst("back"); // after this call we expect: ["back"]
        assertThat(ad1.toList()).containsExactly("back").inOrder();

        ad1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        assertThat(ad1.toList()).containsExactly("middle", "back").inOrder();

        ad1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        assertThat(ad1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    public void add_last_from_empty() {
        Deque61B<String> ad1 = new ArrayDeque61B<>();

        ad1.addLast("back"); // after this call we expect: ["back"]
        assertThat(ad1.toList()).containsExactly("back").inOrder();

        ad1.addLast("middle"); // after this call we expect: ["back"， "middle"]
        assertThat(ad1.toList()).containsExactly("back", "middle").inOrder();

        ad1.addLast("front"); // after this call we expect: ["back", "middle", "front"]
        assertThat(ad1.toList()).containsExactly("back", "middle", "front").inOrder();
    }

    @Test
    public void add_last_nonempty() {
        Deque61B<String> ad1 = new ArrayDeque61B<>();

        ad1.addFirst("back"); // after this call we expect: ["back"]
        ad1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        ad1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        ad1.addLast("x");

        assertThat(ad1.toList()).containsExactly("front", "middle", "back", "x").inOrder();
    }

    @Test
    public void add_first_nonempty() {
        Deque61B<String> ad1 = new ArrayDeque61B<>();

        ad1.addLast("back"); // after this call we expect: ["back"]
        ad1.addLast("middle"); // after this call we expect: ["middle", "back"]
        ad1.addLast("front"); // after this call we expect: ["front", "middle", "back"]
        ad1.addFirst("x");

        assertThat(ad1.toList()).containsExactly("x", "back", "middle", "front").inOrder();
    }

    @Test
    public void add_first_trigger_resize() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 200; i++) {
            ad1.addFirst(i);
        }

        assertThat(ad1.size()).isEqualTo(ad1.toList().size());
    }

    @Test
    public void add_last_trigger_resize() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 200; i++) {
            ad1.addLast(i);
        }

        assertThat(ad1.size()).isEqualTo(ad1.toList().size());
    }
}
