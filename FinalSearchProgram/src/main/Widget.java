package main;

public class Widget implements Comparable {

	private int productNum;
	private int numSold;
	
	public Widget(String num, int sold) throws FormatException {
		if(num.toCharArray().length!=3) {
			throw new FormatException("Product ID must be 3 numbers");
		}
		if(sold<0) {
			throw new FormatException("Number Sold cannot be negative");
		}
		productNum=Integer.parseInt(num);
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
			return 1;
		}
		if(((Widget)(obj)).getNumSold()>(this.getNumSold())){
			return -1;
		}
		else{
			return 0;
		}
	}
}
