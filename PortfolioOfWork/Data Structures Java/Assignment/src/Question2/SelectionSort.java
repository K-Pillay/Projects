package Question2;

import java.util.Arrays;

public class SelectionSort {

        public static void selectionSort(int[] array) {
            int arrayLength = array.length; //declare variable for length of array
            int operations = 0;

            // sorting algorithm
            for (int i = 0; i < arrayLength - 1; i++) { // outer loop that datrt from the 0th the index of the array

//variables for min value and index of the min value
                int min = array[i];// sets first value in array to min
                int minIndex = i;// index of this min value

                //inner for loop
                for (int j = i + 1; j < arrayLength; j++) {
                    if (array[j] < min) {
                        min = array[j];
                        minIndex = j;
                    }
                }
                swapNumber(array, i, minIndex);
                operations++;
                System.out.println("Operation" + "---> " +  operations  + Arrays.toString(array) + "\n");
            }


        }

        //swapNumbers method created to store and update swapped values
        private static void swapNumber(int[] array, int a, int b) {
            //temp veariable to hold variable while swapping

            int temp = array[a];
            array[a] = array[b]; //swapping values "a" with "b".
            array[b] = temp; // temp variable is updated after the swap happens

        }


        public static void main(String[] args) {
            int[] array = {3, 4, 1, 9, 11, 7, 7, 98, 13, 21, 3, 16};

            System.out.println("Array before sorting: " + Arrays.toString(array));

            selectionSort(array);
            System.out.println("Array after sorting: " + Arrays.toString(array));
        }
    }


