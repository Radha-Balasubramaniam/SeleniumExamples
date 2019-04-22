package readingfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingFile {

	public static void main(String[] args) throws IOException {
		File f = new File("/Users/balra06/Documents/test.txt");
		//f.createNewFile();
		
	/*	FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Writing into the text file");
		bw.newLine();
		bw.write("Line 2");
		bw.close();
		fw.close();*/
		
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		//System.out.println(br.readLine());
		//System.out.println(br.readLine());	
		//System.out.println(br.readLine());	
		String i="";
		while((i=(br.readLine()))!=null){
			System.out.println(i);	
		}
			
	/*	int j;
		while((j=br.read())!=-1)
		{
			System.out.print((char)j);
		}
		br.close();
		fr.close();*/
		
	}

}
