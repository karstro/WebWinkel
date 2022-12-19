package web.winkel.webwinkel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity  
@Table(name= "Customer") 
public class Customer {
	private int id;
	private String name;
 
	public Customer(){
        // constructor
	}
 
	@Id
	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	@Column(name = "Name")
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
}