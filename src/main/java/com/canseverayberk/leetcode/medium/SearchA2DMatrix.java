package com.canseverayberk.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-a-2d-matrix
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {-8,-7,-5,-3,-3,-1,1},
                {2,2,2,3,3,5,7},
                {8,9,11,11,13,15,17}
        };
        int target = -5;
        boolean found = searchMatrix(matrix, target);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int possibleRowIndex = -1;
        int maxOfRow, maxOfPreviousRow = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            maxOfRow = row[row.length - 1];
            if (maxOfRow == target)
                return true;
            if (target > maxOfPreviousRow && target <= maxOfRow) {
                possibleRowIndex = i;
                break;
            }
            maxOfPreviousRow = maxOfRow;
        }

        if (possibleRowIndex == -1)
            return false;

        int[] possibleRow = matrix[possibleRowIndex];
        return binarySearch(possibleRow, target);
    }

    public static boolean binarySearch(int[] array, int target) {
        if (array.length == 0)
            return false;
        if (array.length == 1 && array[0] != target)
            return false;

        int possibleArraySearchIndex = array.length / 2;
        if (array[possibleArraySearchIndex] == target) {
            return true;
        } else if (array[possibleArraySearchIndex] < target) {
            return binarySearch(Arrays.copyOfRange(array, possibleArraySearchIndex, array.length), target);
        } else {
            return binarySearch(Arrays.copyOfRange(array, 0, possibleArraySearchIndex), target);
        }
    }
}
