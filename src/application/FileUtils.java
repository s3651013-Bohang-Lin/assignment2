package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * File reader 
 * 
 * @author JinMing Liu s3596621
 *
 */
public class FileUtils {
	 
	public static String readFile(String filePath){
		 
		InputStreamReader read;
        try {

        	String encoding="UTF-8";
            InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filePath);
            read = new InputStreamReader(inputStream,encoding);
            BufferedReader bufferedReader = new BufferedReader(read);
           
            String content = "";
            String temp = null;
            while((temp = bufferedReader.readLine()) != null){
            	content += temp + ";";
            }
            read.close();
            return content;
        } catch (Exception e) {
            System.out.println("cannot find participants.txt.");
            
            return "";
        }finally{
        }
	}
}