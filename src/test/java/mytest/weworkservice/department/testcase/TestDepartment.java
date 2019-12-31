package mytest.weworkservice.department.testcase;

import mytest.weworkservice.department.api.Department;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TestDepartment {
    static Department department = new Department();

    @BeforeAll
    static void init(){
        ArrayList<Integer> ids = department.list(department.parentid).then()
                .extract().body().path("department.findAll {d -> d.parentid == "+ department.parentid + "}.id");
        ids.forEach(id -> department.delete(id));
    }

    @Test
    void list(){
         department.list(department.parentid).then().body("errmsg", equalTo("ok"));
    }

    @Test
    void create(){
        String name = "部门2";
        department.create(name).then().body("errmsg", equalTo("created"));
        department.list(department.parentid).then().body("department.findAll {d -> d.name == '" + name + "'}", hasSize(1));
    }

    @Test
    void delete(){
        int id = department.create("部门3").then().body("errmsg", equalTo("created"))
                .extract().body().path("id");
        department.delete(id).then().body("errmsg", equalTo("deleted"));
    }

}
