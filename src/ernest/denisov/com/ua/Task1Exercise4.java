package ernest.denisov.com.ua;

import java.awt.*;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ******About program logic******
 * We have a set of 2D points in our coordinate system
 * and want to bond them by one line without intersection.
 * So good choice is to sort our points in this way:
 * -point with less X is forwarder than with bigger X
 * -if we have two points with the same X use sort by Y.
 * At the end we will have sorted points as in example:
 * input: (-1, 2), (4, 5), (2, 3), (2, 2)
 * output: (-1, 2), (2, 2), (2, 3), (4, 5)
 * TreeSet deletes dublicates so our output values
 * will be unique
 */
public class Task1Exercise4 {
    public static void main(String[] args){
        //make an input scanner
        Scanner scan = new Scanner(System.in);
        //ThreeSet is autosorting that is better than make ourself sort method
        TreeSet<String> tree = new TreeSet<>();
        int x, y, loopSize;
        //make an iteration amount for future loop
        System.out.println("How many points will be?");
        loopSize = scan.nextInt();
        String s;
        //use Point class from awt package
        for (int i = 0; i < loopSize; i++) {
            System.out.println("Input X Y coordinates (divide by space, use Enter to next pair)");
            x = scan.nextInt();
            y = scan.nextInt();
            s = new Point(x, y).toString();
            tree.add(s);
        }
        System.out.println("Draw the line in this way: ");
        System.out.println(tree);
    }
}

