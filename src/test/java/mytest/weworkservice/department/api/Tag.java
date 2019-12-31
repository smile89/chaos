package mytest.weworkservice.department.api;

import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public interface Tag {
    Response create(String tagname);

    /**
     * 更新标签名字
     * @param id
     * @param tagname
     * @return
     */
    Response updateTagName(int id, String tagname);
    Response deleteById(int id);
    Response findTagMemberByTagId(int id);
    Response addTagMember(int tagId, Map<String, Object> data);
    Response deleteTagMember();
    Response findAllTagInfo();
}
