package com.shq.nacosTest.java8test;

import java.util.Arrays;

public class AarryStreamTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5};
        Arrays.stream(arr).forEach(System.out::println);
    }
}
