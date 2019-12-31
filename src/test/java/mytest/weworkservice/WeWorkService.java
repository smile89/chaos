package mytest.weworkservice;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WeWorkService {

    static String token;
    static int parentid = 2;

    @BeforeAll
    static void getToken() {
        token = given().log().all()
                .param("corpid", "wwd3c55c3b5a6bee15")
                .param("corpsecret", "S6gFOwjMw-wBeu1g3nTcNsOe98N2wgRNpn4DPRuGGcs")
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract()
                .response().path("access_token");

        System.out.println(token);
    }

    @Test
    void departCreate(){

        Map<String, Object> data = new HashMap<>();
        data.put("name", "部门1");
        data.put("parentid", parentid);

          given()
                  .queryParam("access_token", token)
                  .contentType(ContentType.JSON)
                  .body(data)
                  .when().log().all()
                  .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                  .then().log().all()
                  .body("errcode", equalTo(0));
    }

    @Test
    @DisplayName("创建部门")
    void departCreatedByName(){
        Map<String, Object> data = new HashMap<>();
        data.put("name", "S大魔导");
        data.put("parentid", parentid);

        given().log().all()
                .queryParam("access_token", token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all()
                .body("errcode", equalTo(0));
        // 需要使用List接口进行校验，但如果编写list请求，会导致代码冗余带来维护问题，所以引入PO思想
    }


    @Test
    void departList(){
        given()
                .queryParam("access_token", token)
                .queryParam("id", parentid)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all()
                .body("errcode", equalTo(0));
    }

}
