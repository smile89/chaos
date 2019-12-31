package mytest.weworkservice.department.testcase;

import mytest.weworkservice.department.api.Tag;
import mytest.weworkservice.department.api.impl.TagImlp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;

public class TestTag {
    static TagImlp tagImlp = new TagImlp();


    @BeforeAll
    static void init() {
        List<Integer> ids = tagImlp.findAllTagInfo().then().extract().path("taglist.tagid");
        ids.forEach(id -> tagImlp.deleteById(id));
    }


    @Test
    @DisplayName("创建标签")
    void createTag() {
        String tagname = "UIUI2";
        tagImlp.create(tagname);
        tagImlp.findAllTagInfo().then().body("taglist.findAll {t -> t.tagname == '" + tagname + "'}.tagname", hasItem(tagname));
    }

    @Test
    @DisplayName("删除标签")
    void deleteTag() {
        String tagname = "UI";
        int id = tagImlp.create(tagname).then().extract().body().path("tagid");
        tagImlp.deleteById(id).then().body("errmsg", equalTo("deleted"));
    }

    @Test
    @DisplayName("获取标签列表")
    void findAllTagInfo() {
        tagImlp.findAllTagInfo().then().body("errmsg", equalTo("ok"));
    }

    @Test
    @DisplayName("更新标签名称")
    void updateTagName() {
        String oldTagName = "OldName";
        String newTagName = "NewName";

        int id = tagImlp.create(oldTagName).then().extract().path("tagid");
        tagImlp.updateTagName(id, newTagName).then().body("errmsg", equalTo("updated"));
        tagImlp.findAllTagInfo().then().body("taglist.tagname", hasItems(newTagName));
    }

    @Test
    @DisplayName("获取标签成员")
    void getTagMember() {
        String tagName = "TestTagName";


        int id = tagImlp.create(tagName).then().extract().path("tagid");

        Map<String, Object> data = new HashMap<>();
        data.put("tagid", id);
        List<String> userList = new ArrayList<>();
        userList.add("15010769957");
        data.put("userlist", userList);
        List<Integer> partyList = new ArrayList<>();
        partyList.add(2);
        data.put("partylist", partyList);

        tagImlp.addTagMember(id, data).then().body("errmsg", equalTo("ok"));
        tagImlp.findTagMemberByTagId(id).then().body("errcode", equalTo(0))
                .body("userlist.name", hasItems("15010769957"));
    }


}
