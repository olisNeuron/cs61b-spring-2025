package lec6;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestSort {
    @Test
    public void sortTest() {
        String[] input = {"cat", "bob", "luka", "c++ is ..."};
        String[] expected = {"bob", "cat", "c++ is ...", "luka"};
        Sort.sort(input);
        assertThat(input).isEqualTo(expected);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"cat", "bob", "luka", "c++ is ..."};
        String expected = "bob";

        String actual = Sort.findSmallest(input);
        assertThat(actual).isEqualTo(expected);
    }
}
