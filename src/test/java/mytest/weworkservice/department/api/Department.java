package mytest.weworkservice.department.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mytest.weworkservice.department.WeWork;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Department {
    public int parentid = 2;

    public Response list(int id) {
        return given()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .queryParam("id", id)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract()
                .response();
    }

    public Response create(String departName) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", departName);
        data.put("parentid", parentid);

        return given()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when().log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract()
                .response();
    }

    public Response delete(int id) {
        return given()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .queryParam("id", id)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract()
                .response();
    }
}
