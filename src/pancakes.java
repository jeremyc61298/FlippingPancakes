// --------------------------------------
// pancakes.java
// Jeremy Campbell
// Practice using a Breadth First Search
// --------------------------------------
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class pancakes {
    public static void main(String[] args) {
        Scanner fin;
        try{
            fin = new Scanner(new File("pancakes.in"));
        }catch (IOException e) {
            System.out.println("Could not open input file");
        }
    }
}
