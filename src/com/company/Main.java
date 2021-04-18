package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Author: Hojjat Shabab
 *
 * Created on April 18, 2021, 02:55 PM
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("*******************************welcome to the QuickSortAlgorithm progrm*************************************");
        System.out.print("please enter length for Array=");
        int num = input.nextInt();
        int array[] = new int[num];
        Random random = new Random();
        System.out.println("An array was generated randomly");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
            System.out.print(array[i] + " ");
        }
        System.out.println("\n\n"+"Sorted using the quickSort algorithm");
        long timeMillisFirst = System.currentTimeMillis();
        quicksort(array, 0, array.length - 1);
        long timeMillisSecound = System.currentTimeMillis();
        System.out.println(Arrays.toString(array));
        System.out.println("Time in milliseconds for quicksort: " + (timeMillisSecound - timeMillisFirst)+"\n");

    }


    public static void quicksort(int mainArray[], int low, int high) {
        if (low >= high)
            return;
        int pp = partition(mainArray, low, high);//pp=pivotpoint
        quicksort(mainArray, low, pp - 1);
        quicksort(mainArray, pp + 1, high);

    }

    public static int partition(int mainArray[], int low, int high) {
        int pi = mainArray[high];//pi=pivotitem
        int i = low - 1;
        for (int j = low; j < high; ++j) {
            if (mainArray[j] <= pi) {
                ++i;
                int temp = mainArray[i];
                mainArray[i] = mainArray[j];
                mainArray[j] = temp;
            }
        }
        ++i;
        int temp = mainArray[i];
        mainArray[i] = mainArray[high];
        mainArray[high] = temp;
        return i;
    }
}
