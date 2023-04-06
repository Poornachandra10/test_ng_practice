package file_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties_Files_Utils {
public static String readPropertiesFile(String sfilePath, String sKey) throws IOException {
	String sValue="";
	
	System.out.println("filepath"+sfilePath);
	FileInputStream  fis=new FileInputStream(new File(sfilePath));
	Properties p=new Properties();
	p.load(fis);
	sValue=p.getProperty(sKey);	
	return sValue;
	
}
}
