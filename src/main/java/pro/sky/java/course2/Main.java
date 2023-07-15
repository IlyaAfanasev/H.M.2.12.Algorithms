package pro.sky.java.course2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Integer [] arrayList1 = generateRandomArray();
        Integer[] arrayList2 = Arrays.copyOf(arrayList1, arrayList1.length);
        Integer [] arrayList3 =Arrays.copyOf(arrayList1, arrayList1.length);



        long startArrays1 = System.currentTimeMillis();
        sortInsertion(arrayList1);
        System.out.println(System.currentTimeMillis() - startArrays1);


        long startArrays2 = System.currentTimeMillis();
        sortSelection(arrayList2);
        System.out.println(System.currentTimeMillis() - startArrays2);


        long startArrays3 = System.currentTimeMillis();
        sortBubble(arrayList3);
        System.out.println(System.currentTimeMillis() - startArrays3);




    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }


    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }



    public static Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}