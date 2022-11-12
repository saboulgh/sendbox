package org.example.modern.java.recipes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

@DisplayName("Class tests for Stream")
public class StreamsLearningTest {

    @Test
    @DisplayName("Should create Stream of LocalDate using iterate")
    void shouldCreateStreamUsingIterateWithDate() {
        LocalDate now = LocalDate.now();
        List<LocalDate> listDates = Stream.iterate(now, ld -> ld.plusDays(1L))
                .limit(10).toList();
        assertThat(listDates, notNullValue());
        assertThat(listDates.size(), equalTo(10));
        assertThat(listDates, hasItem(now));
        assertThat(listDates, not(hasItem(now.plusDays(11L))));

    }

    @Test
    @DisplayName("Should create Stream of number using iterate")
    void shouldCreateStreamUsingIterate() {
        List<BigDecimal> nums =
                Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE) )
                        .limit(10)
                        .collect(Collectors.toList());
        assertThat(nums, notNullValue());
        assertThat(nums, hasSize(10));
    }

    @Test
    @DisplayName("Should create Stream of Random doubles")
    void shouldCreateStreamOfRandomDoubles() {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Should boxe int stream to Integer")
    void shouldBoxeInt() {
      IntStream.of(3, 1, 4, 1, 5, 9)
                .boxed()
                .forEach(System.out::println)
                //.collect(Collectors.toList());
        ;
    }

    @Test
    void useReduce() {
        int sum = IntStream.rangeClosed(1, 10)
                .reduce(Integer::sum).orElse(0);
        System.out.println(sum);

    }

    @Test
    void useSummaryStatistics() {
        DoubleSummaryStatistics stats = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .summaryStatistics();

        System.out.println(stats);

    }

    @Test
    @DisplayName("Should concat two streams")
    void shouldConcatStreams() {
        Stream<String> first = Stream.of("a", "b", "c").parallel();
        Stream<String> second = Stream.of("X", "Y", "Z");
        List<String> strings = Stream.concat(first, second)
                .collect(Collectors.toList());
        List<String> stringList = Arrays.asList("a", "b", "c", "X", "Y", "Z");
        Assertions.assertEquals(stringList, strings);

    }
}
