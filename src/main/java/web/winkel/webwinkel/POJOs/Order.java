package web.winkel.webwinkel.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.sql.Date;
import java.util.List;
 
@Entity  
@Table(name= "\"ORDER\"") 
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id", unique = true, nullable = false)
	private int id;

	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
 
	@Column(name = "order_date")
	private Date date;
 
	@Column(name = "order_shipped")
	private Boolean shipped;

    @OneToMany(mappedBy="order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
 
	public Order() {}
	public Order(Customer customer, Date date, Boolean shipped) {
		this.customer = customer;
		this.date = date;
		this.shipped = shipped;
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

	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getShipped() {
		return shipped;
	}
 
	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder(Integer.toString(id) + " {\n");
        for (OrderItem orderItem : orderItems) {
            sb.append("  " + orderItem.toString() + "\n");
        }
        sb.append("}");
		return sb.toString();
	}
}