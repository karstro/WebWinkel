package web.winkel.webwinkel;

import org.springframework.web.bind.annotation.*;

import web.winkel.webwinkel.pojos.Customer;

@RestController
public class Webwinkel {

    @GetMapping("/hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "Hello " + name;
	}

    @GetMapping("/getCustomer/{id}")
    public String getCustomer(@PathVariable int id) {
        // retrieve the customer object with the given id
        Customer customer = (Customer)HibernateUtil.getObject(Customer.class, id);
        if (customer == null) {
            return "Customer with given id does not exist.";
        }
        return customer.toString();
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer customer) {
        Boolean success = HibernateUtil.saveObject(customer);
        return Boolean.TRUE.equals(success) ? "Customer created successfully with id " + customer.getId() + "." : "Could not create Customer.";
    }
}
