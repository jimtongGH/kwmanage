package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Log
@Component
@Entity
public class Users implements Serializable {
    @Id
    private String user_id;
    private String user_name;
    private Integer user_sex;
    private Integer user_level;
    private String login_username;
    private String login_password;
    private String user_salt;
    private Integer user_state;

    public Users() {
    }

    public Users(String user_id,
                 String user_name,
                 String login_username) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.login_username = login_username;
    }

    public Users(String user_id,
                 String user_name,
                 String login_username,
                 String login_password,
                 String user_salt,
                 Integer user_state) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.login_username = login_username;
        this.login_password = login_password;
        this.user_salt = user_salt;
        this.user_state = user_state;
    }

    public Users(String user_id,
                 String user_name,
                 Integer user_sex,
                 Integer user_level) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_level = user_level;
    }
    public Users(String user_id,
                 String login_username,
                 String user_name,
                 Integer user_sex,
                 Integer user_level) {
        this.user_id = user_id;
        this.login_username = login_username;
        this.user_name = user_name;
        this.user_sex = user_sex;
        this.user_level = user_level;
    }

    public Users(String user_id,
                 String user_salt,
                 String login_password,
                 Integer user_state) {
        this.user_id = user_id;
        this.user_salt = user_salt;
        this.login_password = login_password;
        this.user_state = user_state;
    }

    public Users(String user_id,
                 Integer user_state) {
        this.user_id = user_id;
        this.user_state = user_state;
    }
}
