package com.gupaoedu.vip.pattern.prototype.yanlong;

import java.io.*;
import java.util.Date;
import java.util.List;


public class User implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;

    private String userName;
    private Integer age;
    private Date birth;
    private List<UserRole> roleList;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public User deepClone(){
        ByteArrayInputStream is = null;
        ByteArrayOutputStream os = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try{
            os = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(os);
            oos.writeObject(this);
            oos.flush();

            is = new ByteArrayInputStream(os.toByteArray());
            ois = new ObjectInputStream(is);
            return (User)ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<UserRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRole> roleList) {
        this.roleList = roleList;
    }
}
