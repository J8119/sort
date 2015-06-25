package Example.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by juliasadovnikova on 6/22/15.
 */
public class test1 {

    public static Integer[] randomarray(int max, int length) {
        Integer[] myList = new Integer[length];
        Random r = new Random();

        for (int i = 1; (i <= length); i++) {
            myList[i - 1] = r.nextInt(max);
        }
        System.out.println("Randomized array " + Arrays.toString(myList));
        return myList;
    }

    private static Integer maxinArray(Integer[] array) {
        int max = array[0];
        for (int anArray : array) {
            if (anArray > max) {
                max = anArray;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] randomarray = randomarray(150, 10);
        Integer[] sortedArray = sort(randomarray);
        System.out.println("Sorted array" + Arrays.toString(sortedArray));
    }

    private static Integer[] sort(Integer[] randomarray) {
        Integer[] sortedArray = new Integer[randomarray.length];

        int SortedIndex = 0;
        Integer[] UnsortedArray = new Integer[randomarray.length - SortedIndex];

        while (SortedIndex < randomarray.length) {
            if (SortedIndex == 0) {
                UnsortedArray = randomarray;
            }
            Integer CurrentMax = maxinArray(UnsortedArray);

            List<Integer> UnsortedList_temp = new ArrayList<>();

            for (int i = 0; (i < UnsortedArray.length); i++) {
                if (UnsortedArray[i].equals(CurrentMax)) {
                    sortedArray[SortedIndex] = UnsortedArray[i];
                    SortedIndex++;
                } else {
                    UnsortedList_temp.add(UnsortedArray[i]);
                }
            }
            UnsortedArray = UnsortedList_temp.toArray(new Integer[UnsortedList_temp.size()]);
        }
        return sortedArray;
    }

}