package Question1;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] unsortedArray = {4, 2, 6, 3, 5, 9};
        System.out.println("Unsorted array: " + Arrays.toString(unsortedArray));

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        merge(unsortedArray);

        System.out.println("Sorted array: " + Arrays.toString(unsortedArray));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

    }

    //Declare merge method
    public static void merge(int[] array) {
        int inputLength = array.length;
        //Base case for if array has less than 2 values
        if (inputLength < 2) {
            return; //code exits as array with one value is already sorted
        }
//find middle of array
        int midIndex = inputLength / 2;
        //set new arrays for left and right hals
        int[] leftHalf = new int[midIndex];
        int[]rightHalf = new int[inputLength - midIndex]; // initialiser accomodates for odd number of elements in array

        //populating the left half of the array
        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = array[i];
        }
        //populating the right half
        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = array[i]; // ensures that elements in rightt sub array are properly indexed
        }

        //recursive call
        merge(leftHalf);
        merge(rightHalf);

//call merge array
        mergeArray(array, leftHalf, rightHalf);
    }
    //merging arrays through a method
    public static void mergeArray(int[] array,  int @NotNull [] leftHalf, int @NotNull [] rightHalf){
        int leftArrsize = leftHalf.length;
        int rightArrSize = rightHalf.length;

        int i = 0; //initialiser for left array
        int j = 0; //initiliser for right array
        int k = 0;//initiliser for merged array

        //while loop thta runs code until values in right and left array are exhausted
        while(i < leftArrsize && j < rightArrSize){
            //if statement will compare values in the left and right array
            if (leftHalf[i] <= rightHalf[j]){
                array[k] = leftHalf[i]; //will place the lowest value at k = 0 in merged array
                i++;//increment after value has been sorted

            }else{
                array[k] = rightHalf[j]; // when elements in right arr are smaller
                j++; //increment
            }
            k++; //increment merged arr index after value has been added.
        }

//accounting for any leftover elements in an array that have not been added to the merged array
        //while loop for each arr that will run while i < right and left arr and will add remaining elements to merged array k
        while (i < leftArrsize){
            array[k] = leftHalf [i];
            i++;
            k++;
        }
        while (j < rightArrSize){
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}

