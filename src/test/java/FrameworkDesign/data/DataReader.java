package FrameworkDesign.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;


public class DataReader {
	

	public List<HashMap<String,String>> getjsonDataToMap() throws IOException
	{
		
		
		/*
		 * Properties pro=new Properties(); FileInputStream fis=new
		 * FileInputStream(System.getProperty("user.dir")+
		 * "src\\test\\java\\FrameworkDesign\\data\\PurchaseOrder.json"); pro.load(fis);
		 */
		String jsoncontent=FileUtils.readFileToString(new File(System.getProperty("C:\\Users\\Tajinder\\eclipse-workspace\\PageObjectModel\\src\\test\\java\\FrameworkDesign\\data\\PurchaseOrder.json")));
  
       
      ObjectMapper mapper=new ObjectMapper();
      List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() { });
     
       return data;
	}

	
	
	

}
