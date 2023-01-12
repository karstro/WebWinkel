package web.winkel.webwinkel;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
// import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests {
    
    @Test
    void whenCustomerIdExists_ThenGetCustomer() {
        when().
            get("/getCustomer/{id}", 10).
        then().
            statusCode(200).
            body("name", equalTo("Person1")).
            and().
            body("id", equalTo(10));
    }
}
