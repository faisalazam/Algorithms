package com.mindworks.algorithms.binarysearch;

import org.junit.Test;

import static com.mindworks.algorithms.binarysearch.BinarySearch.search;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    @Test
    public void shouldReturnMinusOneFromSearchMethodWhenSearchSpaceIsEmpty() {
        final int valueToSearch = 5;
        final int[] searchSpace = {};
        assertThat(search(searchSpace, valueToSearch), is(-1));
    }

    @Test
    public void shouldReturnMinusOneFromSearchMethodWhenSearchSpaceContainsOddNumberOfValuesAndNoneOfThemIsTargetValue() {
        final int valueToSearch = 8;
        assertThat(search(new int[]{2}, valueToSearch), is(-1));
        assertThat(search(new int[]{1, 6, 7}, valueToSearch), is(-1));
        assertThat(search(new int[]{3, 4, 7, 9, 11}, valueToSearch), is(-1));
    }

    @Test
    public void shouldReturnMinusOneFromSearchMethodWhenSearchSpaceContainsEvenNumberOfValuesAndNoneOfThemIsTargetValue() {
        final int valueToSearch = 10;
        assertThat(search(new int[]{2, 7}, valueToSearch), is(-1));
        assertThat(search(new int[]{1, 6, 7, 9}, valueToSearch), is(-1));
        assertThat(search(new int[]{3, 4, 7, 9, 11, 15}, valueToSearch), is(-1));
    }

    @Test
    public void shouldReturnFoundIndexFromSearchMethodWhenSearchSpaceContainsOddNumberOfValuesAndOneOfThemIsTargetValue() {
        assertThat(search(new int[]{2}, 2), is(0));

        assertThat(search(new int[]{1, 6, 7}, 1), is(0));
        assertThat(search(new int[]{1, 6, 7}, 6), is(1));
        assertThat(search(new int[]{1, 6, 7}, 7), is(2));

        assertThat(search(new int[]{3, 4, 7, 9, 11}, 3), is(0));
        assertThat(search(new int[]{3, 4, 7, 9, 11}, 4), is(1));
        assertThat(search(new int[]{3, 4, 7, 9, 11}, 7), is(2));
        assertThat(search(new int[]{3, 4, 7, 9, 11}, 9), is(3));
        assertThat(search(new int[]{3, 4, 7, 9, 11}, 11), is(4));
    }

    @Test
    public void shouldReturnFoundIndexFromSearchMethodWhenSearchSpaceContainsEvenNumberOfValuesAndOneOfThemIsTargetValue() {
        assertThat(search(new int[]{2, 7}, 2), is(0));
        assertThat(search(new int[]{2, 7}, 7), is(1));

        assertThat(search(new int[]{1, 6, 7, 9}, 1), is(0));
        assertThat(search(new int[]{1, 6, 7, 9}, 6), is(1));
        assertThat(search(new int[]{1, 6, 7, 9}, 7), is(2));
        assertThat(search(new int[]{1, 6, 7, 9}, 9), is(3));

        assertThat(search(new int[]{3, 4, 7, 9, 11, 15}, 3), is(0));
        assertThat(search(new int[]{3, 4, 7, 9, 11, 15}, 4), is(1));
        assertThat(search(new int[]{3, 4, 7, 9, 11, 15}, 7), is(2));
        assertThat(search(new int[]{3, 4, 7, 9, 11, 15}, 9), is(3));
        assertThat(search(new int[]{3, 4, 7, 9, 11, 15}, 11), is(4));
        assertThat(search(new int[]{3, 4, 7, 9, 11, 15}, 15), is(5));
    }
}