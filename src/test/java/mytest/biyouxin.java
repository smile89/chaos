package mytest;

import com.alibaba.fastjson.JSON;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class biyouxin {

    @BeforeAll
    static void init(){
//        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().defaultContentCharset("US-ASCII"));

        // 全局的拦截器
        RestAssured.filters((req, res, ctx)->{
            System.out.println(req.getURI());
            if (req.getURI().contains("xueqiu")) {
                req.cookie("xq_a_token=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xqat=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xq_r_token=670668eda313118d7214487d800c21ad0202e141; u=741575099896532; device_id=24700f9f1986800ab4fcc880530dd0ed");
            }
            return ctx.next(req, res);
        });
    }


    @Test
    void loginForms(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("appkey","BFF1351752F448E7AFECF1FE0587EEAB");
        map.put("clientCode","212");
        map.put("clientType","Android");
        map.put("clientVer","7.1.8");
        map.put("loginChannel","0");
        map.put("loginTerminal","1");
        map.put("params","J5yFC/tQAdq4uXw6aKSaYmDwgK8O/g0BloFxtKbDeDp91wyD0v5Kwtif8XN+2wo2FKfjbOfN8YP6L9ZU2idEO2rZWgJzz0zSBBJj2qR0EMH6j/n2EBzE/vw/iCzDGuYq07MUGpyhYXZHGeE5H+TOTiSf6F78VziGx/xcR4wbGVo=");
        map.put("role","1");
        map.put("shadow$_klass_","class com.rd.app.activity.new_login.beans.LoginBean");
        map.put("shadow$_monitor_","0");
        map.put("signa","481ADA92ABA64FDC5F210D8837FBDF9C");
        map.put("terminfo","eyJhY2Nlc3NfdHlwZSI6ImFuZHJvaWRBUFAiLCJhcHBfbmFtZSI6Iueip+acieS/oSIsImFwcF92ZXJzaW9uIjoiVjcuMS44IiwiYnJvd2VyIjoiY29tLnJkLmJneS83LjEuOC8yMTIobGludXg7IEFuZHJvaWQgMjM7IHZib3g4NnAgYnVpbGQvR2VueW1vdGlvbikgZGV2aWNlIHZib3g4NnA7IHRhZ3MgdGVzdC1rZXlzKSIsImNhcnJpZXJfb3BlcmF0b3IiOiIxIiwiY2hhbmVsIjoi56Kn5pyJ5L+hIiwiY29ubmVjdGlvbl93YXkiOiJ3aWZpIiwiZGV2aWNlVG9rZW4iOiJBaWNkdDhhWHFMOFJxRFZfTVFj SlQyUEVMRWlkQVVOQXctdTNVQWpGejdjRiIsImRldmljZV92ZXJzaW9uIjoiR2VueW1vdGlvbkdl bnltb3Rpb24iLCJpcCI6IjEwLjAuMy4xNSIsIm9zIjoiQW5kcm9pZDYuMCIsInNjcmVlbl9oZWln aHQiOiIyNTYwIiwic2NyZWVuX3dpZHRoIjoiMTQ0MCJ9");
        map.put("ts","1575094462815");
        map.put("user_id","0");

        HashMap<String, Object> header = new HashMap<>();
        header.put("appkey","BFF1351752F448E7AFECF1FE0587EEAB");
        header.put("ts","1575094462815");
        header.put("signa","481ADA92ABA64FDC5F210D8837FBDF9C");
        header.put("appGateway", "userCenter_test");
        header.put("clientType","Android");

        given()
                .log().all()
                .headers(header)
                .formParams(map)
                .when()
                .post("http://192.168.1.42:8099/1.0.0/api/user/login")
                .then().log().all().statusCode(200)
                .body("res_code", equalTo(1));

    }

    // TODO: 2019/11/30 入参为Json

    @Test
    void testFilterAddCookie(){
        given()
                .log().all()
//                .proxy("127.0.0.1", 8888)
//                .cookie("xq_a_token=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xqat=5e0d8a38cd3acbc3002589f46fc1572c302aa8a2; xq_r_token=670668eda313118d7214487d800c21ad0202e141; u=741575099896532; device_id=24700f9f1986800ab4fcc880530dd0ed")
                .params("symbol", "sogo")
                .when().get("https://stock.xueqiu.com/v5/stock/batch/quote.json")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void testFilterResponse(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("appkey","BFF1351752F448E7AFECF1FE0587EEAB");
        map.put("clientCode","212");
        map.put("clientType","Android");
        map.put("clientVer","7.1.8");
        map.put("loginChannel","0");
        map.put("loginTerminal","1");
        map.put("params","J5yFC/tQAdq4uXw6aKSaYmDwgK8O/g0BloFxtKbDeDp91wyD0v5Kwtif8XN+2wo2FKfjbOfN8YP6L9ZU2idEO2rZWgJzz0zSBBJj2qR0EMH6j/n2EBzE/vw/iCzDGuYq07MUGpyhYXZHGeE5H+TOTiSf6F78VziGx/xcR4wbGVo=");
        map.put("role","1");
        map.put("shadow$_klass_","class com.rd.app.activity.new_login.beans.LoginBean");
        map.put("shadow$_monitor_","0");
        map.put("signa","481ADA92ABA64FDC5F210D8837FBDF9C");
        map.put("terminfo","eyJhY2Nlc3NfdHlwZSI6ImFuZHJvaWRBUFAiLCJhcHBfbmFtZSI6Iueip+acieS/oSIsImFwcF92ZXJzaW9uIjoiVjcuMS44IiwiYnJvd2VyIjoiY29tLnJkLmJneS83LjEuOC8yMTIobGludXg7IEFuZHJvaWQgMjM7IHZib3g4NnAgYnVpbGQvR2VueW1vdGlvbikgZGV2aWNlIHZib3g4NnA7IHRhZ3MgdGVzdC1rZXlzKSIsImNhcnJpZXJfb3BlcmF0b3IiOiIxIiwiY2hhbmVsIjoi56Kn5pyJ5L+hIiwiY29ubmVjdGlvbl93YXkiOiJ3aWZpIiwiZGV2aWNlVG9rZW4iOiJBaWNkdDhhWHFMOFJxRFZfTVFj SlQyUEVMRWlkQVVOQXctdTNVQWpGejdjRiIsImRldmljZV92ZXJzaW9uIjoiR2VueW1vdGlvbkdl bnltb3Rpb24iLCJpcCI6IjEwLjAuMy4xNSIsIm9zIjoiQW5kcm9pZDYuMCIsInNjcmVlbl9oZWln aHQiOiIyNTYwIiwic2NyZWVuX3dpZHRoIjoiMTQ0MCJ9");
        map.put("ts","1575094462815");
        map.put("user_id","0");

        HashMap<String, Object> header = new HashMap<>();
        header.put("appkey","BFF1351752F448E7AFECF1FE0587EEAB");
        header.put("ts","1575094462815");
        header.put("signa","481ADA92ABA64FDC5F210D8837FBDF9C");
        header.put("appGateway", "userCenter_test");
        header.put("clientType","Android");

        given()
                .log().all()
                .filter((req, res, ctx) -> {
                    Response resOrigin = ctx.next(req, res);
                    String resString = resOrigin.asString();
                    Map<String, Object> result = (Map<String, Object>) JSON.parse(resString);
                    Map<String, Object> resDataMap = (Map<String, Object>) result.get("res_data");
                    String ui = resOrigin.path("res_data.ui");
                    String uiNew = new String(Base64.getDecoder().decode(ui.trim()));
                    resDataMap.put("ui", uiNew);
                    ResponseBuilder responseBuilder = new ResponseBuilder().clone(resOrigin);
                    responseBuilder.setBody(String.valueOf(result));
                    return responseBuilder.build();
                })
                .headers(header)
                .formParams(map)
                .when()
                .post("http://192.168.1.42:8099/1.0.0/api/user/login")
                .then().log().all().statusCode(200)
                .body("res_code", equalTo(1));
    }


    @Test
    void testLogin(){
        String body = "{'name': 'APP登录---未登陆过基金', 'times': 1, 'request': {'url': 'http://192.168.1.242:8099/1.0.0/api/user/login', 'method': 'POST', 'verify': False, 'headers': {'appGateway': 'userCenter_test', 'ts': '1548754490591', 'appKey': 'BFF1351752F448E7AFECF1FE0587EEAB', 'clientType': 'Android', 'user-agent': 'com.rd.bgy/7.0.0.9/192(linux; Android 26; vbox86p build/Samsung Galaxy S9 - 8.0 - API 26 - 1440x2960) device vbox86p; tags test-keys)', 'clientVer': '7.0.0', 'signa': '2D01EA84FF978790A979DCFECB6D9C86'}, 'data': {'loginTerminal': '1', 'loginChannel': '0', 'role': '1', 'params': 'lZlCEWEOi8BbpTBrit1IoQa+jSXWmPGEA9Cam9IUkyRZMgD8+jNmprMNQs7kaQfGsQ4a2948yoVEFwiO9cOG8xFeG9MwQYOETLjY+v6k68ZD7LfmMjNCuygyXKYTXgmHPN5+G/bWXA7Zy+9Nf4U5vJ2pxF1Uz/rmEdtTdx6KNZU='}}, 'desc': {'header': {'appGateway': '', 'ts': '', 'appKey': '', 'clientType': '', 'user-agent': '', 'clientVer': '', 'signa': ''}, 'data': {'loginTerminal': '', 'loginChannel': '', 'role': '', 'params': ''}, 'files': {}, 'params': {}, 'variables': {}, 'extract': {'user_id': '', 'oauth_token': ''}}, 'extract': [{'user_id': 'content.res_data.user_id'}, {'oauth_token': 'content.res_data.oauth_token'}]}";

    }


}
