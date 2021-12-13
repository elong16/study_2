package com.example._work2.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

@TableName(value = "user")
public class User extends Model<User> {
    @TableId(value ="uname")
   @TableField(value = "uname")
    private  String uerName;
    @TableField(value = "password")
    private  String passWord;


    public User(String uname, String password) {
        this.uerName = uname;
        this.passWord = password;
    }

    public User() {
    }

    public String getUerName() {
        return uerName;
    }

    public void setUerName(String uname) {
        this.uerName = uname;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        this.passWord = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uerName + '\'' +
                ", password='" + passWord + '\'' +
                '}';
    }
}
