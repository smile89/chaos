package mytest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Demo {

    @Test
    public void testJson() {
        given().log().all()
                .when().get("http://127.0.0.1:8000/lotto.json")
                .then().log().all()
                    .body("store.bicycle.color", equalTo("red"))
                    .body("store.book.price", hasItems(8.95f,12.99f))
                    .body("store.book.category", hasItems("fiction"))
                    .body("store.book[0].author", equalTo("Nigel Rees"))
                    .body("store.book.findAll {book -> book.price >=5 && book.price <=  15}.category", hasItem("reference"))
                    .body("store.book.find {book -> book.price == 8.95f}.category", equalTo("reference"));

    }

    @Test
    void testXml(){
        given().log().all()
                .when().get("http://127.0.0.1:8000/shopping.xml")
                .then().log().all()
                .body("shopping.category.item[0].name", equalTo("Chocolate"))
                .body("shopping.category.item.size()", equalTo(5))
                .body("shopping.category.findAll {it.@type == 'groceries'}.size()", equalTo(1))
                .body("**.findAll {it.@type == 'groceries'}.size()", equalTo(1))
                .body("shopping.category.findAll {it.@type == 'groceries'}.item.size()", equalTo(2))
                .body("shopping.category.item.findAll {it.price == 20}.name", equalTo("Coffee"))
                .body("**.findAll {it.price == 20}.name", equalTo("Coffee"));
    }
}
