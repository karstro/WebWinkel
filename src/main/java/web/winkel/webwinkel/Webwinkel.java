package web.winkel.webwinkel;

import org.springframework.web.bind.annotation.*;

import web.winkel.webwinkel.pojos.*;

@RestController
public class Webwinkel {

    @GetMapping("/hello")
	public String helloWorld(@RequestParam(value = "name", defaultValue = "world") String name) {
		return "Hello " + name;
	}

    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer customer) {
        Boolean success = HibernateUtil.saveObject(customer);
        return Boolean.TRUE.equals(success) ? "Customer created successfully with id " + customer.getId() + "." : "Could not create Customer.";
    }

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
            return clazz.getSimpleName() + " with given id does not exist.";
        }
        return result.toString();
    }
}
