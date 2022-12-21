package web.winkel.webwinkel.POJOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
 
@Entity  
@Table(name= "PRODUCT") 
public class Product {

	@Id @GeneratedValue
	@Column(name = "product_id", unique = true, nullable = false)
	private int id;
 
	@Column(name = "product_name")
	private String name;
 
	@Column(name = "product_stock")
	private int stock;
 
	@Column(name = "product_reserved")
	private int reserved;
 
	public Product() {}
	public Product(String name, int stock, int reserved) {
		this.name = name;
		this.stock = stock;
		this.reserved = reserved;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}
 
	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getReserved() {
		return reserved;
	}
 
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
}