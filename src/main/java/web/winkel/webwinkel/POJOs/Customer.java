package web.winkel.webwinkel.POJOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 
@Entity  
@Table(name= "CUSTOMER") 
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customer_id", unique = true, nullable = false)
	private int id;
 
	@Column(name = "customer_name")
	private String name;
 
	public Customer() {}
	public Customer(String name) {
		this.name = name;
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

	public String toString() {
		return Integer.toString(id) + ": " + name;
	}
}