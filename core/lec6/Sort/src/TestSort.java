import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestSort {
    @Test
    public void TestSort(){
        String[] input = {"CC", "BB", "DD", "AA"};
        String[] expected = {"AA", "BB", "CC", "DD"};
        Sort.sort(input);

        assertThat(input).isEqualTo(expected);
    }
}
