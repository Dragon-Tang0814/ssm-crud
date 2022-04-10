package com.atguigu.crud.test;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**测试dao层工作
 * @author tylstart
 * @create 2022-04-08 9:29
 * 1.导入spring单元模块--->springTest
 * 2.ContextConfiguration指定spring配置文件的位置
 * 3.直接autowired组件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    /*测试部门*/
    @Test
    public void testCRUD(){
        /*原生的
        1.创建SpringIOC容器
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        2.从容器中获取Mapper
        Department bean = ioc.getBean(Department.class);
        */

        //System.out.println(departmentMapper);

        //1.插入部门
        //departmentMapper.insertSelective(new Department(null,"开发部"));
        //departmentMapper.insertSelective(new Department(null,"测试部"));

        //2.生成员工数据
        //employeeMapper.insertSelective(new Employee(null,"TYL","M","TYL@qq.com",1));

        //3.批量插入多个员工,使用批量操作的sqlSession
        /*for (){
            employeeMapper.insertSelective(new Employee(null,"TYL","M","TYL@qq.com",1));
        }*/
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i=0;i<1000;i++){
            String substring = UUID.randomUUID().toString().substring(0, 5)+i;
            mapper.insertSelective(new Employee(null,substring,"M",substring+"@atguigu.com",1));
        }

        System.out.println("成功");
    }
}
