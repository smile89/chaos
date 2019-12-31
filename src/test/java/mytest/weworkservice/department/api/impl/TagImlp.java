package mytest.weworkservice.department.api.impl;

import com.sun.javafx.sg.prism.NGImageView;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mytest.weworkservice.department.WeWork;
import mytest.weworkservice.department.api.Tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TagImlp implements Tag {
    @Override
    public Response create(String tagname) {
        Map<String, Object> data = new HashMap<>();
        data.put("tagname", tagname);

        return given().log().all()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    @Override
    public Response updateTagName(int id, String tagname) {
        Map<String, Object> data = new HashMap<>();
        data.put("tagid", id);
        data.put("tagname", tagname);

        return given().log().all()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/update")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    @Override
    public Response deleteById(int id) {

        return given().log().all()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .queryParam("tagid", id)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete")
                .then().log().all()
                .body("errmsg", equalTo("deleted"))
                .extract().response();
    }

    @Override
    public Response findTagMemberByTagId(int id) {
        return given().log().all()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .queryParam("tagid", id)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/get")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }

    @Override
    public Response addTagMember(int tagId, Map<String, Object> data) {


        return given().log().all()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers")
                .then().log().all()
                .extract().response();
    }

    @Override
    public Response deleteTagMember() {
        return null;
    }

    @Override
    public Response findAllTagInfo() {
        return given().log().all()
                .queryParam("access_token", WeWork.getInstance().getToken())
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/list")
                .then().log().all()
                .body("errcode", equalTo(0))
                .extract().response();
    }
}
