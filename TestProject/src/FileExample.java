import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args) throws IOException {
		FileInputStream inputstream = new FileInputStream("/Users/balra06/Work/1107Request.rtf");
		FileOutputStream outputstream = new FileOutputStream("/Users/balra06/Work/FinalRequest.rtf");
		
		int temp;
		
		
		while((temp=inputstream.read())!=-1){
			outputstream.write((byte)temp);
		}
	}

}
