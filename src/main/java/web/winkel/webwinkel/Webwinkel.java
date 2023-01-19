package web.winkel.webwinkel;

import org.springframework.web.bind.annotation.*;

import web.winkel.webwinkel.pojos.*;

@RestController
public class Webwinkel {

    // respond with the string "hello world" or "hello {name}"
    // created to test request parameters
    @GetMapping("/hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "Hello " + name;
	}

    // create a customer with the given name and show the id in the response
    // normally you would respond with json, but since this application doesn't have a frontend, it responds with a string
    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer customer) {
        Boolean success = HibernateUtil.saveObject(customer);
        if (Boolean.TRUE.equals(success)) {
            return "Customer created successfully with id " + customer.getId() + ".";
        } else {
            return "Could not create Customer.";
        }
    }

    // retrieve the customer with the given id, or null if it doesn't exist
    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return (Customer)HibernateUtil.getObject(Customer.class, id);
    }

    // get an object of the given type with the given id
    // normally you would use separate functions like getCustomer, but I wanted to see if this could work.
    @GetMapping("/get{object}/{id}")
    public String getObject(@PathVariable String object, @PathVariable int id) {
        Class clazz = null;
        switch (object) {
            case "Customer":
                clazz = Customer.class;
                break;
            case "Order":
                clazz = Order.class;
                break;
            case "OrderItem":
                clazz = OrderItem.class;
                break;
            case "CartItem":
                clazz = CartItem.class;
                break;
            case "Product":
                clazz = Product.class;
                break;
            default:
                return "Object type \"" + object + "\" not recognized";
        }
        // retrieve the object with the given id
        Object result = HibernateUtil.getObject(clazz, id);
        if (result == null) {
            return clazz.getSimpleName() + " with id " + Integer.toString(id) + " does not exist.";
        }
        return result.toString();
    }
}
