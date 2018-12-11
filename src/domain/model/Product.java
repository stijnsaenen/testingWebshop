package domain.model;

public class Product implements Cloneable{
	private int productId;
	private String name;
	private String description;
	private double price;
	
	public Product(){
		
	}
	
	public Product(int productId, String name, String description, double d) {
		setProductId(productId);
		setName(name);
		setDescription(description);
		setPrice(d);
	}
	public Product(String name, String description, double d) {
		setName(name);
		setDescription(description);
		setPrice(d);
	}
	public Product clone() throws CloneNotSupportedException{
		Product product = (Product) super.clone();
		return product;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		if (productId <= 0 ){
			throw new DomainException("productid can't be negative");
		}
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.isEmpty()) {
			throw new DomainException("No name given");
		}
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if (description.isEmpty()) {
			throw new DomainException("No description given");
		}
		
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		if (price<0) {
			throw new DomainException("Give a valid price");
		}
		this.price = price;
	}
	public void setPrice(String price) {
		if (price.isEmpty()) {
			throw new DomainException("No price given");
		}
		setPrice(Double.valueOf(price));
	}
	
	@Override
	public String toString(){
		return getName() + ": " + getDescription() + " - " + getPrice();
	}
	
}
