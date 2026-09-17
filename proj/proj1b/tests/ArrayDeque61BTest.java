import jh61b.utils.Reflection;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }

//     @Test
//     void arrCopyTest(){
//         String[] arr1 = new String[]{"Hello", "World", "Father", "Mother", "Mr. Owl", "Mr. Crow"};
//         String[] arr2 = new String[3];
//
//         ArrayDeque61B<String> llq1 = new ArrayDeque61B<>();
//         llq1.arrayCopy(arr1, arr2, 1, 3, 0, 2);
//
//         String[] Expected = new String[]{"World", "Father", "Mother"};
//         assertThat(arr2).isEqualTo(Expected);
//
//         // llq1.arrayCopy(arr1, arr2, -1, 2, 0, 3);
//     }

//    @Test
//    void resizeTest(){
//        ArrayDeque61B<String> llq1 = new ArrayDeque61B<>();
//        llq1.addLast("Hello");
//        llq1.addLast("World");
//        llq1.addLast("Father");
//        llq1.addLast("Mother");
//        llq1.addFirst("Mr. Owl");
//        llq1.addFirst("Mr. Crow");
//
//        llq1.resize();
//    }

    @Test
    void addFirstTest(){
        ArrayDeque61B<String> llq1 = new ArrayDeque61B<>();

        llq1.addFirst("Hello");
        llq1.addFirst("World");
        llq1.addFirst("Father");
        llq1.addFirst("Mother");
        llq1.addFirst("Mr. Owl");
        llq1.addFirst("Mr. Crow");
        llq1.addFirst("Seven");
        llq1.addFirst("It seems.....");
        llq1.addFirst("We have to resize");

        List<String> expected = List.of("We have to resize", "It seems.....", "Seven", "Mr. Crow", "Mr. Owl", "Mother",
                "Father", "World", "Hello");
        assertThat(llq1.toList()).containsExactlyElementsIn(expected).inOrder();
    }

    @Test
    void addLastTest(){
        ArrayDeque61B<String> llq1 = new ArrayDeque61B<>();

        llq1.addLast("Hello");
        llq1.addLast("World");
        llq1.addLast("Father");
        llq1.addLast("Mother");
        llq1.addLast("Mr. Owl");
        llq1.addLast("Mr. Crow");
        llq1.addLast("Seven");
        llq1.addLast("It seems.....");
        llq1.addLast("We have to resize");

        List<String> expected = List.of("Hello", "World", "Father", "Mother", "Mr. Owl", "Mr. Crow",
                "Seven", "It seems.....", "We have to resize");
        assertThat(llq1.size()).isEqualTo(9);
        assertThat(llq1.toList()).containsExactlyElementsIn(expected).inOrder();
    }

    @Test
    void removeFirstTest(){
        ArrayDeque61B<String> llq1 = new ArrayDeque61B<>();

        llq1.addLast("Hello");
        llq1.addLast("World");
        llq1.addLast("Father");
        llq1.addLast("Mother");

        String removed = llq1.removeFirst();

        assertThat(removed).isEqualTo("Hello");
        assertThat(llq1.size()).isEqualTo(3);
        assertThat(llq1.toList()).containsExactly("World", "Father", "Mother").inOrder();

        llq1.removeFirst();
        llq1.removeFirst();
        llq1.removeFirst();

        assertThat(llq1.isEmpty()).isTrue();
        assertThat(llq1.removeFirst()).isNull();
    }

    @Test
    void removeFirstWithWrapNoResizeTest(){
        // Fills the array (capacity 8) via addLast, removes from the front to advance head,
        // then adds more via addLast so tail wraps past the end of the array back to index 0 -
        // all without ever triggering resize(), to exercise the circular indexing in removeFirst.
        ArrayDeque61B<String> llq1 = new ArrayDeque61B<>();

        for (int i = 1; i <= 7; i++) {
            llq1.addLast("C" + i);
        }
        for (int i = 0; i < 5; i++) {
            llq1.removeFirst();
        }
        llq1.addLast("C8");
        llq1.addLast("C9"); // tail wraps from index 7 back to index 0 here

        assertThat(llq1.size()).isEqualTo(4);
        List<String> expectedOrder = List.of("C6", "C7", "C8", "C9");
        assertThat(llq1.toList()).containsExactlyElementsIn(expectedOrder).inOrder();

        for (int i = 0; i < expectedOrder.size(); i++) {
            assertThat(llq1.removeFirst()).isEqualTo(expectedOrder.get(i));
        }
        assertThat(llq1.isEmpty()).isTrue();
    }

    @Test
    void integrationTest(){
        // Exercises addFirst/addLast/removeFirst/removeLast/get/size/isEmpty/toList together,
        // forces a resize mid-sequence, then drains the deque to empty and adds again
        // (add -> remove -> add) to make sure state stays consistent across that transition.
        ArrayDeque61B<Integer> llq1 = new ArrayDeque61B<>();

        llq1.addLast(1);
        llq1.addLast(2);
        llq1.addLast(3);
        llq1.addLast(4);
        assertThat(llq1.toList()).containsExactly(1, 2, 3, 4).inOrder();

        llq1.addFirst(0);
        assertThat(llq1.toList()).containsExactly(0, 1, 2, 3, 4).inOrder();

        assertThat(llq1.removeLast()).isEqualTo(4);
        assertThat(llq1.toList()).containsExactly(0, 1, 2, 3).inOrder();

        // size goes 4 -> 9 here, so the array (capacity 8) must resize mid-batch.
        llq1.addFirst(-1);
        llq1.addFirst(-2);
        llq1.addFirst(-3);
        llq1.addFirst(-4);
        llq1.addFirst(-5);
        assertThat(llq1.size()).isEqualTo(9);
        assertThat(llq1.toList()).containsExactly(-5, -4, -3, -2, -1, 0, 1, 2, 3).inOrder();

        assertThat(llq1.removeFirst()).isEqualTo(-5);
        assertThat(llq1.removeFirst()).isEqualTo(-4);
        assertThat(llq1.removeLast()).isEqualTo(3);
        assertThat(llq1.removeLast()).isEqualTo(2);
        assertThat(llq1.toList()).containsExactly(-3, -2, -1, 0, 1).inOrder();

        assertThat(llq1.size()).isEqualTo(5);
        assertThat(llq1.isEmpty()).isFalse();
        assertThat(llq1.get(0)).isEqualTo(-3);
        assertThat(llq1.get(4)).isEqualTo(1);
        assertThat(llq1.get(5)).isNull();   // out of range
        assertThat(llq1.get(-1)).isNull();  // out of range

        // Drain completely, alternating removeFirst/removeLast.
        assertThat(llq1.removeFirst()).isEqualTo(-3);
        assertThat(llq1.removeLast()).isEqualTo(1);
        assertThat(llq1.removeFirst()).isEqualTo(-2);
        assertThat(llq1.removeLast()).isEqualTo(0);
        assertThat(llq1.removeFirst()).isEqualTo(-1);
        assertThat(llq1.isEmpty()).isTrue();
        assertThat(llq1.size()).isEqualTo(0);

        // Add again after being fully emptied - head/tail must not be left in a stale state.
        llq1.addLast(100);
        assertThat(llq1.toList()).containsExactly(100).inOrder();

        llq1.addFirst(99);
        assertThat(llq1.toList()).containsExactly(99, 100).inOrder();

        llq1.addLast(101);
        assertThat(llq1.toList()).containsExactly(99, 100, 101).inOrder();

        assertThat(llq1.removeFirst()).isEqualTo(99);
        assertThat(llq1.toList()).containsExactly(100, 101).inOrder();
        assertThat(llq1.size()).isEqualTo(2);
    }
}
