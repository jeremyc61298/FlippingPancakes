// --------------------------------------
// pancakes.java
// Jeremy Campbell
// Practice using a Breadth First Search
// --------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class pancakes {
    public static void main(String[] args) throws IOException {
        BufferedReader fin;
        try{
            fin = new BufferedReader(new FileReader("pancakes.in"));
        }catch (IOException e) {
            System.out.println("Could not open input file");
        }
    }
}
