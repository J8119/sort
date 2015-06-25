package Example.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by juliasadovnikova on 6/22/15.
 */
public class test2 {

    public static Integer[] randomIntArray(int max, int length) {
        Integer[] myList = new Integer[length];
        Random r = new Random();

        for (int i = 1; (i <= length); i++) {
            myList[i - 1] = r.nextInt(max);
        }
        System.out.println("Randomized integer array " + Arrays.toString(myList));
        return myList;
    }

    public static Double[] randomDoubleArray(int length) {
        Double[] myList = new Double[length];
        Random r = new Random();

        for (int i = 1; (i <= length); i++) {
            myList[i - 1] = r.nextDouble();
        }
        System.out.println("Randomized double array " + Arrays.toString(myList));
        return myList;
    }

    private static <T> T maxinArray(T[] array) {
        T max = array[0];
        for (T anArray : array) {
            if (anArray.equals(max)) {
                max = anArray;
            }
        }
        return max;
    }

    private static <T> T[] sort(T[] randomarray) {
        T[] sortedArray = (T[])new T()[randomarray.length];

        int SortedIndex = 0;
        T[] UnsortedArray = (T[])new Object[randomarray.length - SortedIndex];

        while (SortedIndex < randomarray.length) {
            if (SortedIndex == 0) {
                UnsortedArray = randomarray;
            }
            T CurrentMax = maxinArray(UnsortedArray);

            List<T> UnsortedList_temp = new ArrayList<>();

            for (int i = 0; (i < UnsortedArray.length); i++) {
                if (UnsortedArray[i].equals(CurrentMax)) {
                    sortedArray[SortedIndex] = UnsortedArray[i];
                    SortedIndex++;
                } else {
                    UnsortedList_temp.add(UnsortedArray[i]);
                }
            }
            UnsortedArray = UnsortedList_temp.toArray((T[])new Object[UnsortedList_temp.size()]);
            //UnsortedArray = UnsortedList_temp.toArray(new T[UnsortedList_temp.size()]);
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        Integer[] randomarray = randomIntArray(150, 10);
        Integer[] sortedArray = sort(randomarray);
        System.out.println("Sorted array" + Arrays.toString(sortedArray));
    }

}