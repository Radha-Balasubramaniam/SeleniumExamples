package iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Writing string value to the file";
		byte[] b = s.getBytes();
		
		try {
			FileOutputStream fout = new FileOutputStream("/Users/balra06/Downloads/testoutput1.txt");
			fout.write(b);
			
			FileInputStream fin = new FileInputStream("/Users/balra06/Downloads/testoutput1.txt");
			int i =0;
			while((i=fin.read())!=-1){
				System.out.print((char)i);
			}
			
			
			fout.close();
			System.out.println("Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
