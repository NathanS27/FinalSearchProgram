package main;

public class Widget implements Comparable {

	private int productNum;
	private int numSold;
	
	public Widget(int num, int sold) {
		productNum=num;
		numSold=sold;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getNumSold() {
		return numSold;
	}

	public void setNumSold(int numSold) {
		this.numSold = numSold;
	}
	
	public int compareTo(Object obj) {
		if(((Widget)(obj)).getNumSold()<(this.getNumSold())){
			return -1;
		}
		if(((Widget)(obj)).getNumSold()<(this.getNumSold())){
			return 1;
		}
		else{
			return 0;
		}
	}
}
