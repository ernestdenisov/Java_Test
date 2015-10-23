package ernest.denisov.com.ua;

import java.util.*;

public class Task1Exercise3 {

    public static void main(String[] args) {
        //declare an array with strings
        //some strings are substrings for composite strings
        String[] array = new String[]{"five", "fivetwo", "fourfive", "fourfivetwo",
                "one", "onefiveone", "two", "twofivefourone"};
        /*
        * make a set for composite strings.
        * we use Collections instead of Arrays becouse actually
        * we do not a size of future array.
        * TreeSet has autosorting so the largest string will be the last
         */
        TreeSet<String> myTree = new TreeSet<>();
        /*
        * use nested loops for substrings searching
        * if our string consists of several other strings
        * we add it in our TreeSet
         */
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array.length; ++j) {
                for (int k = 0; k < array.length; ++k) {
                    //logic operators help to find substrings
                    if ((i != j && i != k && j != k)
                            && (array[i].equals(array[j] + array[k])
                            || array[i].equals(array[k] + array[j])))
                        myTree.add(array[i]);
                }
            }
        }
        //for empty array catch an exception
        try {
            //output the longest composite string
            System.out.println(myTree.last());
        }catch (NoSuchElementException e){
            System.out.println("The array is empty");
        }
    }
}
