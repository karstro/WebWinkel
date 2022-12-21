package web.winkel.webwinkel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
 
@Entity  
@Table(name= "Customer") 
public class Customer {

	@Id @GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	private int id;
 
	@Column(name = "Name")
	private String name;
 
	public Customer(){
        // constructor
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
}