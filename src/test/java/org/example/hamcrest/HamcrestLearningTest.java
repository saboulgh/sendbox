package org.example.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Write assertions for booleans")
public class HamcrestLearningTest {

    @Nested
    @DisplayName("When boolean is true")
    class WhenBooleanIsTrue {

        @Test
        @DisplayName("Should be true")
        void shouldBeTrue() {
            assertThat(true, is(true));
        }
    }

    @Nested
    @DisplayName("When object is not null")
    class WhenObjectIsNotNotNull {

        @Test
        @DisplayName("Should not be null")
        void shouldNotBeNull() {
            assertThat(new Object(), notNullValue());
        }
    }
}
