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
}
