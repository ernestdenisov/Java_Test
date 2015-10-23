package ernest.denisov.com.ua;

import org.ho.yaml.YamlDecoder;
import org.ho.yaml.YamlEncoder;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1Exercise1 {

    private static String fileName = "C://file.yml";

    public static void main(String[] args) throws IOException {
        //Use Random to generate randomic numbers for our array
        Random random = new Random();
        //User can choose amount of number pairs
        Scanner scan = new Scanner(System.in);
        System.out.println("How many pairs You want to be?");
        int randomSize = scan.nextInt();
        //Create an array
        ArrayList<Integer> myArray = new ArrayList<>();
        int pairValueOne, pairValueTwo;
        //for loop helps to fill our array by values
        for (int i = 0; i < (2 * randomSize); i += 2) {
            pairValueOne = random.nextInt(randomSize);
            myArray.add(i, pairValueOne);
            pairValueTwo = pairValueOne;
            myArray.add((i + 1), pairValueTwo);
        }
        //unique value
        myArray.add((2 * randomSize), (random.nextInt(randomSize) + randomSize + 1));

        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        //Create YAML file
        OutputStream out = new FileOutputStream(file);
        YamlEncoder enc = new YamlEncoder(out);
        enc.writeObject(myArray);
        enc.close();
        out.close();

        if (!file.exists()) {
            file.createNewFile();
        }
        //Read YAML file
        InputStream in = new FileInputStream(fileName);
        YamlDecoder enc1 = new YamlDecoder(in);
        ArrayList<Integer> outarrays = (ArrayList<Integer>) enc1.readObject();
        enc1.close();
        in.close();
        //optional information, helps to control YAML file content
        System.out.print("Your all numbers: ");
        for (int i = 0; i < outarrays.size(); i++) {
            System.out.print(outarrays.get(i) + " ");
        }
        System.out.print("\n");
        int m;
        int needIt = 0;
        int count = 0;
        //find our unique number
        for (int i = 0; i < outarrays.size(); i++) {
            m = outarrays.get(i);
            for (int j = 0; j < outarrays.size(); j++) {
                if (m != outarrays.get(j)) {
                    count++;
                }
                if (count == (outarrays.size() - 1)) {
                    needIt = m;
                }
            }
            count = 0;
        }
        System.out.println("Single number is " + needIt);
    }
}

