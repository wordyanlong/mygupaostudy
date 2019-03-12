package com.gupaoedu.vip.pattern.prototype.yanlong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        testDeepClone();
//        testShadowClone();
    }

    public static void testShadowClone() {
        try {
            User xiaoming = new User();
            xiaoming.setUserName("xiaoming");
            xiaoming.setAge(12);
            xiaoming.setBirth(new Date());

            List<UserRole> userRoleList = new ArrayList<UserRole>();
            UserRole xiaomingrole = new UserRole();
            xiaomingrole.setRoleId(1l);
            xiaomingrole.setRoleName("管理员");
            xiaomingrole.setUserId(1l);
            userRoleList.add(xiaomingrole);
            xiaoming.setRoleList(userRoleList);

            User zhangsan = (User) xiaoming.clone();
            zhangsan.setBirth(new Date());
            zhangsan.setUserName("zhangsan");
            zhangsan.setAge(26);
            zhangsan.getRoleList().get(0).setRoleName("审核员");
            System.out.println("原型对象：" + xiaoming);
            System.out.println("克隆对象：" + zhangsan);
            System.out.println("原型对象-姓名：" + xiaoming.getUserName());
            System.out.println("克隆对象-姓名：" + zhangsan.getUserName());
            System.out.println("原型对象-年龄：" +  xiaoming.getAge());
            System.out.println("克隆对象-年龄：" +  zhangsan.getAge());

            System.out.println("原型对象-角色名称：" +  xiaoming.getRoleList().get(0).getRoleName());
            System.out.println("克隆对象-角色名称：" +  zhangsan.getRoleList().get(0).getRoleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testDeepClone() {
        try {
            User xiaoming = new User();
            xiaoming.setUserName("xiaoming");
            xiaoming.setAge(12);
            xiaoming.setBirth(new Date());

            List<UserRole> userRoleList = new ArrayList<UserRole>();
            UserRole xiaomingrole = new UserRole();
            xiaomingrole.setRoleId(1l);
            xiaomingrole.setRoleName("管理员");
            xiaomingrole.setUserId(1l);
            userRoleList.add(xiaomingrole);

            User zhangsan = (User) xiaoming.deepClone();
            zhangsan.setBirth(new Date());
            zhangsan.setUserName("zhangsan");
            zhangsan.setAge(26);

            System.out.println("原型对象：" + xiaoming);
            System.out.println("克隆对象：" + zhangsan);
            System.out.println("原型对象-姓名：" + xiaoming.getUserName());
            System.out.println("克隆对象-姓名：" + zhangsan.getUserName());
            System.out.println("原型对象-年龄：" + xiaoming.getAge());
            System.out.println("克隆对象-年龄：" + zhangsan.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
