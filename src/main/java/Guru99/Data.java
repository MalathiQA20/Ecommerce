package Guru99;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import Guru99.Data;

public class Data {
	
	@Override
	public String toString() {
		return "Data [url=" + url + ", option=" + option + "]";
	}
	static String url;
	static String option;
	static String product;
	static String qty;
	static String errormsg;
	static String carterrormsg;
	public Data() {
		
		
	}
	public static String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public static String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public static String getProduct()
	{
		return product;
	}
	public void setProduct(String product)
	{
		this.product=product;
	}
	public static String getQty()
	{
		return qty;
	}
	public void setQty(String qty)
	{
		this.qty=qty;
	}
	public static String getErrormsg()
	{
		return errormsg;
	}
	public void setErrormsg(String errormsg)
	{
		this.errormsg=errormsg;
	}
	public static String getCarterrormsg()
	{
		return carterrormsg;
	}
	public void setCarterrormsg(String carterrormsg)
	{
		this.carterrormsg=carterrormsg;
	}
	public static Data get(String filename)throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper=new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return mapper.readValue(new File(filename),Data.class);

}
}
