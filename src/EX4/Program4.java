package EX4;

import java.util.Random;

public class Program4 {

    public static void main(String[] args) {

        int[] array = new Random(1222)
                .ints(1,100)
                .limit(10)
                .toArray();
        //int[] array = {3,2,3,1,2,4,5,5,6};

        System.out.println();
        System.out.println("Исходный массив\n");
        for(int n : array){
            System.out.print(n + " ");
        }

        int k = 3;

        int biggestKth = partitioning(array, k);
        System.out.println("\nМассив новый");
        for(int n : array)
            System.out.print(n + " ");

        System.out.printf("\nНаибольший k-й элемент при к = %d, равен  %d",k, biggestKth);


    }
    public static int partitioning(int[] arr, int k){
        int start = 0;
        int end = arr.length-1;
        int pivot = arr[end];
        int pIndex = start;

        int lookingFor = arr.length-k;

        for(int i=start; i<end; i++){
            if(arr[i]<=pivot){
                int temp= arr[i];
                arr[i]=arr[pIndex];
                arr[pIndex]= temp;
                pIndex++;
            }
        }
        int tmp = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = tmp;


        while(pIndex != lookingFor) {
            if (pIndex < lookingFor) {
                pivot = arr[end];
                start = pIndex;
                for (int i = start; i < end; i++) {
                    if (arr[i] <= pivot) {
                        int temp = arr[i];
                        arr[i] = arr[pIndex];
                        arr[pIndex] = temp;
                        pIndex++;
                    }
                }
                tmp = arr[end];
                arr[end] = arr[pIndex];
                arr[pIndex] = tmp;
            } else if (pIndex > lookingFor) {
                end = pIndex-1;
                pivot = arr[end];
                start=0;
                pIndex=0;

                for (int i = start; i < end; i++) {
                    if (arr[i] <= pivot) {
                        int temp = arr[i];
                        arr[i] = arr[pIndex];
                        arr[pIndex] = temp;
                        pIndex++;
                    }
                }
                tmp = arr[end];
                arr[end] = arr[pIndex];
                arr[pIndex] = tmp;
            }

        }
        return arr[pIndex];
    }


}