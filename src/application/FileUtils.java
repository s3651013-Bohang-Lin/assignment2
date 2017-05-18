package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <h1>FileUtils</h1>
 * File reader method
 * @version jdk1.8
 * @author JinMing Liu s3596621
 *
 */
public class FileUtils {
	 
	public static String readFile(String filePath){
		 
		InputStreamReader read;
        try {

        	String encoding="UTF-8";
            InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filePath);//Read the properties file and load the source file
            read = new InputStreamReader(inputStream,encoding);//Create an InputStreamReader that using a given character set decoder
            BufferedReader bufferedReader = new BufferedReader(read);//Create a buffer character input stream that using the default size input buffer.
           
            String content = "";
            String temp = null;
            while((temp = bufferedReader.readLine()) != null){
            	content += temp + ";";
            }
            read.close();
            return content;
        } catch (Exception e) {
            System.err.println("cannot find \"participants.txt\".");
            return "";
        }
	}
}