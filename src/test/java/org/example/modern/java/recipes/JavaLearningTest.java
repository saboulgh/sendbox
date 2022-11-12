package org.example.modern.java.recipes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Write assertions")
public class JavaLearningTest {


    @Nested
    @DisplayName("When object is not null")
    class ConsumerTests {

        @Test
        @DisplayName("Should display item by calling consumer")
        void shouldDisplayItems() {
            List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
            strings.forEach(System.out::println);
        }
    }
}
