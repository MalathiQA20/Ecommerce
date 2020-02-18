package Guru99;

import java.util.List;

public class Pojo {
	
	private String url;
	private List<String> mobiles;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getMobiles() {
		return mobiles;
	}
	public void setMobiles(List<String> mobiles) {
		this.mobiles = mobiles;
	}
	public Pojo(String url, List<String> mobiles) {
		
		this.url = url;
		this.mobiles = mobiles;
	}
	

}
