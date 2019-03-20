package com.gupaoedu.mydelegate;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class User implements Serializable {

    private String userName;
    private Integer age;
    private Date birth;
}
