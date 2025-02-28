import java.util.Arrays;
import java.util.Random;
public class SSort {
    public static void main(String[] args) {
        int[] arr1 = new int[100];
        int[] arr2 = new int[100];
        int[] arr3 = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(101);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = 99 - i;
        }
        long startTime, endTime;
        int[] tempArr1 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        bubbleSort(tempArr1);
        endTime = System.nanoTime();
        System.out.println("BSort" + (startTime - endTime) + "ns");

        tempArr1 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        insertionSort(tempArr1);
        endTime = System.nanoTime();
        System.out.println("iSort" + (startTime - endTime) + "ns");

        tempArr1 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        selectionSort(tempArr1);
        endTime = System.nanoTime();
        System.out.println("sSort" + (startTime - endTime) + "ns");

        int[] tempArr2 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        bubbleSort(tempArr2);
        endTime = System.nanoTime();
        System.out.println("BSort" + (startTime - endTime) + "ns");

        tempArr2 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        insertionSort(tempArr2);
        endTime = System.nanoTime();
        System.out.println("iSort" + (startTime - endTime) + "ns");

        tempArr2 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        selectionSort(tempArr2);
        endTime = System.nanoTime();
        System.out.println("sSort" + (startTime - endTime) + "ns");

        int[] tempArr3 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        bubbleSort(tempArr3);
        endTime = System.nanoTime();
        System.out.println("BSort" + (startTime - endTime) + "ns");

        tempArr3 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        insertionSort(tempArr3);
        endTime = System.nanoTime();
        System.out.println("iSort" + (startTime - endTime) + "ns");

        tempArr3 = Arrays.copyOf(arr1, arr1.length);
        startTime = System.nanoTime();
        selectionSort(tempArr3);
        endTime = System.nanoTime();
        System.out.println("sSort" + (startTime - endTime) + "ns");
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
    }


