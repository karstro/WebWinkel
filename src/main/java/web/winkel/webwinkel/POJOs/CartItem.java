package web.winkel.webwinkel.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
 
@Entity  
@Table(name= "CARTITEM") 
public class CartItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "cart_item_id", unique = true, nullable = false)
	private int id;

	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
	private Customer customer;

	@ManyToOne
    @JoinColumn(name="product_id", nullable=false)
	private Product product;
 
	@Column(name = "cart_item_amount")
	private int amount;
 
	public CartItem() {}
	public CartItem(Customer customer, Product product, int amount) {
		this.customer = customer;
		this.product = product;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}
 
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}
 
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}
 
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String toString() {
		return Integer.toString(id) + ": " + Integer.toString(amount) + " " + product.getName() + " for " + customer.getName();
	}
}