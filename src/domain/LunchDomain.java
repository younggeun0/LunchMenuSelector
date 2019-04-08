package domain;

public class LunchDomain {
	
	private String name, someDesc, addr;
	private int avgPrice;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSomeDesc() {
		return someDesc;
	}
	public void setSomeDesc(String someDesc) {
		this.someDesc = someDesc;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(int avgPrice) {
		this.avgPrice = avgPrice;
	}
}
