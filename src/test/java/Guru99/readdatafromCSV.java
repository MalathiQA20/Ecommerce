package Guru99;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class readdatafromCSV {

	public static void main(String[] args) throws CsvValidationException, IOException {
		Reader r=new FileReader("C:\\Users\\Siva\\Downloads\\orders.csv");
		CSVReader reader=new CSVReader(r);
		String[] cell ;

		try{
		  while((cell=reader.readNext())!=null){
		       for(String rec:cell){
		           System.out.println(rec);
		       }
		  }
		}catch(NullPointerException z){
		    System.out.print("Your custom error message");
		}finally {
			reader.close();
		}

	}

}
