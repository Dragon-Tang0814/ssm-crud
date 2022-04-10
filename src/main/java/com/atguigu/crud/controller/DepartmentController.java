package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**处理部门有关的亲求
 * @author tylstart
 * @create 2022-04-08 17:43
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //返回所有的部门信息
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        //查出的所有部门的信息
        List<Department> list=departmentService.getDepts();

        return  Msg.success().add("depts",list);
    }
}
