package Question2;

import java.util.Arrays;

public class BubbleSort {

    // bubbleSort method
    public static void bubbleSort(int[] array) {
        int arraySize = array.length; // declare variable for the total array size
        boolean valueSwapped = true;// declare a boolean value to determine if a value has been swapped. (true as default so it can enter the while loop)
        int AlgorithmPasses = 0;// intialising variable to show passes done



//declare sorting algorithm
        while (valueSwapped) {
            valueSwapped = false; // ensures that if no value is swapped, the array is sorted
            AlgorithmPasses++;// increment pass variable to show ordering


            for (int i = 0; i < arraySize - 1; i++) {
                if (array[i] > array[i + 1]) {
                    valueSwapped = true;// will update when a value is swapped if it meets condition
                    int temp = array[i]; // save the value at index i to a temp variable
                    array[i] = array[i + 1];// The value at the i'th index will be set to the new index "i + 1"
                    array[i + 1] = temp;// will update the temp value to hold the new value.
                }
            }
            System.out.println("Passes done: " + AlgorithmPasses + "--->" + Arrays.toString(array));
        }
    }


    public static void main(String[] args) {
        int[] array = {3, 4, 1, 9, 11, 7, 7, 98, 13, 21, 3, 16};


        System.out.println("Array before sorting: " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("Array after sorting: " + Arrays.toString(array));
    }
}


