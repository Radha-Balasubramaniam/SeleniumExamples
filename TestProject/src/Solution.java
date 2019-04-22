import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        
    	int i = 0;
        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i+1)) {
                s = s.substring(0, i) + s.substring(i+2);
                
                i=0;
                continue;
            }
            i++;
        }
        if (s.length() == 0) {
            return "Empty String";
        }
        return s;
    	
       	
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
