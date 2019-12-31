package mytest.weworkservice.department;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class WeWork {
    private static WeWork weWork;
    String token;

    public static WeWork getInstance(){
        if (weWork == null){
            weWork = new WeWork();
        }
        return weWork;
    }

    public String getToken(){
        if (token == null) {
            token = given().log().all()
                    .param("corpid", "wwd3c55c3b5a6bee15")
                    .param("corpsecret", "S6gFOwjMw-wBeu1g3nTcNsOe98N2wgRNpn4DPRuGGcs")
                    .when()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                    .then().log().all()
                    .body("errcode", equalTo(0))
                    .extract()
                    .response().path("access_token");
        }
        return token;
    }
}
