import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ConvertByteToFile {
	
	public static void main(String[] args) {
		
	/*	File file = new File(System.getProperty("user.dir") +"/src/sample.txt");
		byte[] bytesFile = new byte[(int) file.length()];
		
		try {	
		
		FileInputStream fileInputStream  = new FileInputStream(file);			
		fileInputStream.read(bytesFile);
		FileOutputStream fileOuputStream = new FileOutputStream(System.getProperty("user.dir") + ""/src/bytes.txt");
		fileOuputStream.write(bytesFile);
		System.out.println("Bytes file created");
		
	} catch (IOException e) {
        e.printStackTrace();
    } */


		String sourcepath = System.getProperty("user.dir") + "/src/sample.txt";
		String destinationpath = System.getProperty("user.dir") + "/src/bytes.txt";
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(sourcepath));
            System.out.println(encoded);
            Files.write(Paths.get(destinationpath), encoded);
        } catch (IOException e) {
        	 e.printStackTrace();
        }
    
    
    
    }}
