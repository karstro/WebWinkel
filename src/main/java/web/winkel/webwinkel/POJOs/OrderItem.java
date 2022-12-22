package web.winkel.webwinkel.POJOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
 
@Entity  
@Table(name= "ORDERITEM") 
public class OrderItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_item_id", unique = true, nullable = false)
	private int id;

	@ManyToOne
    @JoinColumn(name="order_id", nullable=false)
	private Order order;

	@ManyToOne
    @JoinColumn(name="product_id", nullable=false)
	private Product product;
 
	@Column(name = "order_item_amount")
	private int amount;
 
	public OrderItem() {}
	public OrderItem(Order order, Product product, int amount) {
		this.order = order;
		this.product = product;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}
 
	public void setOrder(Order order) {
		this.order = order;
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
}