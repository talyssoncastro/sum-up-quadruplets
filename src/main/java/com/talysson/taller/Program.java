package com.talysson.taller;

import java.util.ArrayList;
import java.util.List;

public class Program {

    private static final Integer SIZE_CALC = 4;

    public static void main(String[] args) {
        /**
         * {
         *   "array": [7, 6, 4, -1, 1, 2],
         *   "targetSum": 16
         * }
         *
         *
         * [
         *   [7, 6, 4, -1],
         *   [7, 6, 1, 2]
         * ]
         */

        Integer [] array = {7, 6, 4, -1, 1, 2};
        Integer targetSum = 16;
        List<Integer[]> output = fourNumberSum(array, targetSum);

        System.out.println(output.size());

    }

    public static List<Integer[]> fourNumberSum(Integer[] array, int targetSum) {

        List<Integer[]> result = new ArrayList();
        if (array.length < SIZE_CALC) {
            return null;
        }

        int pos1 = 0;
        int pos2 = 1;
        int pos3 = 2;

        int i;

        while (pos1 >= 0) {

            int sum = array[pos1];
            sum += array[pos2];
            sum += array[pos3];

            Integer list[] = new Integer[SIZE_CALC];
            list[0] = array[pos1];
            list[1] = array[pos2];
            list[2] = array[pos3];

            for (i = pos3 + 1; i < array.length; i++) {
                int newSum = sum + array[i];
                list[3] = array[i];
                if (newSum == targetSum) {
                    result.add(list.clone());
                }
            }

            if (pos3 + 2 < array.length) {
                pos3++;
            } else if (pos2 + 3 < array.length) {
                pos2++;
                pos3 = pos2 + 1;
            } else if (pos1 + 4 < array.length) {
                pos1++;
                pos2 = pos1 + 1;
                pos3 = pos2 + 1;
            } else {
                pos1 = -1;
            }
        }

        return result;
    }
}
