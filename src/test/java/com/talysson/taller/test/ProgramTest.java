package com.talysson.taller.test;

import com.talysson.taller.Program;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class ProgramTest {

    // Workaround to initialize the list with 1 element
    private static List<Integer[]> listWithOneElement = new ArrayList();

    @BeforeClass
    public static void configure() {
        Integer expected[] = new Integer[]{1, 2, 3, 4};
        listWithOneElement.add(expected);
    }

    @Parameterized.Parameters(name = "{index}: {0} The quadruplets to sum up {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        1,
                        new Integer[]{7, 6, 4, -1, 1, 2},
                        16,
                        Arrays.asList(new Integer[]{7, 6, 4, -1}, new Integer[]{7, 6, 1, 2})
                },
                {
                        2,
                        new Integer[]{1, 2, 3, 4, 5, 6, 7},
                        10,
                        listWithOneElement // If declare using the same syntax as others, will create a list of integer, and not a list of vector of integer.
                },
                {
                        3,
                        new Integer[]{5, -5, -2, 2, 3, -3},
                        0,
                        Arrays.asList(new Integer[]{5, -5, -2, 2}, new Integer[]{5, -5, 3, -3}, new Integer[]{-2, 2, 3, -3})
                },
                {
                        4,
                        new Integer[]{-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        4,
                        Arrays.asList(new Integer[]{-2, -1, 1, 6}, new Integer[]{-2, -1, 2, 5}, new Integer[]{-2, -1, 3, 4}, new Integer[]{-2, 1, 2, 3})
                },
                {
                        5,
                        new Integer[]{-1, 22, 18, 4, 7, 11, 2, -5, -3},
                        30,
                        Arrays.asList(new Integer[]{-1, 22, 7, 2}, new Integer[]{-1, 18, 11, 2}, new Integer[]{22, 4, 7, -3}, new Integer[]{22, 11, 2, -5}, new Integer[]{18, 4, 11, -3})
                },
                {
                        6,
                        new Integer[]{-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5},
                        20,
                        Arrays.asList(new Integer[]{-10, -3, 28, 5}, new Integer[]{-10, 28, -6, 8}, new Integer[]{-3, 2, -7, 28}, new Integer[]{-5, 2, 15, 8}, new Integer[]{-5, 2, 12, 11}, new Integer[]{-5, 12, 8, 5}, new Integer[]{-7, 28, -6, 5})
                },
                {
                        7,
                        new Integer[]{1, 2, 3, 4, 5},
                        100,
                        Arrays.asList()
                },
                {
                        8,
                        new Integer[]{1, 2, 3, 4, 5, -5, 6, -6},
                        5,
                        Arrays.asList(new Integer[]{1, 3, -5, 6}, new Integer[]{1, 4, 5, -5}, new Integer[]{1, 4, 6, -6}, new Integer[]{2, 3, 5, -5}, new Integer[]{2, 3, 6, -6}, new Integer[]{2, 4, 5, -6})
                }
        });
    }

    private Integer index;
    private Integer[] array;
    private Integer targetSum;
    private List<Integer[]> expectedQuadruplets;

    public ProgramTest(Integer index, Integer[] array, Integer targetSum, List<Integer[]> expectedQuadruplets) {
        this.index = index;
        this.array = array;
        this.targetSum = targetSum;
        this.expectedQuadruplets = expectedQuadruplets;
    }

    @Test
    public void showHaveSameQuadruplets() {
        List<Integer[]> quadruplets = Program.fourNumberSum(array, targetSum);

         Assert.assertEquals(expectedQuadruplets.size(), quadruplets.size());

        for (int i = 0; i < expectedQuadruplets.size(); i++) {
            Assert.assertArrayEquals(expectedQuadruplets.get(i), quadruplets.get(i));
        }
    }

    @Test
    public void test2() {
        Integer array[] = {1, 2, 3, 4, 5, 6, 7};
        int targetSum = 10;

        List<Integer[]> quadruplets = Program.fourNumberSum(array, targetSum);

        Assert.assertEquals(1, quadruplets.size());

        Integer expected1[] = {1, 2, 3, 4};

        Assert.assertArrayEquals(expected1, quadruplets.get(0));

    }

}
