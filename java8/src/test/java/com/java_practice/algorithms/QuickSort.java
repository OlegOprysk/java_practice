package com.java_practice.algorithms;

public class QuickSort {
    private int[] numbers;
    private int number;


    public void sort(int[] values) {

        if (valuesAreEmptyOrNull(values)) {
            return;
        }

        this.numbers = values;
        number = values.length;

        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int leftSideArrayIndex = low;
        int rightSideArrayIndex = high;

        int pivotElement = numbers[getPivotElementIndex(low, high)];

//        Divide into two lists
        while (leftSideArrayIndex <= rightSideArrayIndex) {
//            If the current value from the left list is smaller than the pivot
//            element then get the next element from the list
            while (numbers[leftSideArrayIndex] < pivotElement) {
                leftSideArrayIndex++;
            }
//            If the current value from the right list is larger then the pivot
//            element then get the next element from the right list
            while (numbers[rightSideArrayIndex] > pivotElement) {
                rightSideArrayIndex--;
            }
//            If we have found a value in the left list which is larger than
//            the pivot element and if we have found a value in the right list
//            which is smaller than the pivot element then we exchange the values
//
//            As we are done we can increase 'lefSideArrayIndex'
//            and 'rightSideArrayIndex'

            if (leftSideArrayIndex <= rightSideArrayIndex) {
                exchange(leftSideArrayIndex, rightSideArrayIndex);
                leftSideArrayIndex++;
                rightSideArrayIndex--;
            }

//            Recursion
            if (low < rightSideArrayIndex) {
                quicksort(low, rightSideArrayIndex);
            }
            if (high > leftSideArrayIndex) {
                quicksort(leftSideArrayIndex, high);
            }
        }
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private int getPivotElementIndex(int low, int high) {
        return low + (high - low) / 2;
    }

    private boolean valuesAreEmptyOrNull(int[] values) {
        return values == null || values.length == 0;
    }
}
