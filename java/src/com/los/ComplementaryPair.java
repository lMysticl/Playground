package com.los;


import java.util.HashMap;
import java.util.Map;

public class ComplementaryPair {

    private static final int INITIAL_VALUE = 1;

    static int findComplementaryPairs(int[] array, int k) {
        Map<Integer, Integer> map = mapElementsOccurrences(array);
        return countPairs(array, k, map);
    }

    private static Map<Integer, Integer> mapElementsOccurrences(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : array) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, INITIAL_VALUE);
            }
        }
        return map;
    }

    private static int countPairs(int[] array, int k, Map<Integer, Integer> map) {
        int counter = 0;
        for (int element : array) {
            int valueToComplementPair = k - element;
            if (valueToComplementPair == element && map.get(element) >= 1) {
                counter += map.get(element) - 1;
            } else {
                counter += map.getOrDefault(valueToComplementPair, 0);
            }
        }
        return counter;
    }
}

