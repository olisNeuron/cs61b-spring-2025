import com.google.common.truth.Truth;
import deque.ArrayDeque61B;

import deque.Deque61B;
import deque.LinkedListDeque61B;
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

        assertThat(ad1.get(0)).isEqualTo(199);
    }

    @Test
    public void add_last_trigger_resize() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();

        for (int i = 0; i < 200; i++) {
            ad1.addLast(i);
        }

        assertThat(ad1.get(199)).isEqualTo(199);
    }

    @Test
    public void testRemoveFirstAndRemoveLast() {
        Deque61B<Integer> ad1 = new ArrayDeque61B<>();
        ad1.addLast(0);
        ad1.addLast(1);
        ad1.addLast(2);
        ad1.addLast(3);
        Deque61B<Integer> ad2 = new ArrayDeque61B<>();

        assertThat(ad1.removeFirst()).isEqualTo(0);
        assertThat(ad1.toList()).containsExactly(1, 2, 3).inOrder();
        assertThat(ad1.size()).isEqualTo(3);

        assertThat(ad1.removeLast()).isEqualTo(3);
        assertThat(ad1.toList()).containsExactly(1, 2).inOrder();
        assertThat(ad1.size()).isEqualTo(2);

        ad2.removeFirst();
        assertThat(ad2.size()).isEqualTo(0);
        ad2.removeLast();
        assertThat(ad2.size()).isEqualTo(0);
    }

    @Test
    public void testSizeAndIsEmpty() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        Truth.assertThat(lld1.isEmpty()).isTrue();
        Deque61B<Integer> lld2 = new ArrayDeque61B<>();
        lld2.addFirst(1);
        lld2.addFirst(1);
        lld2.addFirst(1);
        Truth.assertThat(lld2.size()).isEqualTo(3);
        Truth.assertThat(lld2.isEmpty()).isFalse();
    }

    @Test
    public void testGet() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(0);
        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);

        for (int i = 0; i < lld1.size(); ++i) {
            Truth.assertThat((Integer) lld1.get(i)).isEqualTo(i);
        }

        Truth.assertThat((Integer) lld1.get(27888)).isNull();
    }

    @Test
    public void addLastTestBasicWithoutToList() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1).containsExactly("front", "middle", "back");

        Deque61B<String> lld2 = new ArrayDeque61B<>();

        lld2.addLast("front"); // after this call we expect: ["front"]
        lld2.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld2.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld2).containsExactly("front", "middle", "back");
    }

    @Test
    public void testEqualDeque61B() {
        Deque61B<String> lld1 = new ArrayDeque61B<>();
        Deque61B<String> lld2 = new ArrayDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        lld2.addLast("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertThat(lld1.equals(lld2)).isEqualTo(true);

        Deque61B<String> lld3 = new LinkedListDeque61B<>();
        Deque61B<String> lld4 = new LinkedListDeque61B<>();

        lld3.addLast("front");
        lld3.addLast("middle");
        lld3.addLast("back");

        lld4.addLast("front");
        lld4.addLast("middle");
        lld4.addLast("back");

        assertThat(lld3.equals(lld4)).isEqualTo(true);
    }

    @Test
    public void testToStringDeque61B() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();
        Deque61B<String> lld2 = new ArrayDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        lld2.addLast("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertThat(lld1.toString()).isEqualTo("{front,middle,back,}");
    }
}
