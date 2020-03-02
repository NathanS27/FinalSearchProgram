package main;

public class Widget {

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
}
