package com.taianting.springboot.model;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Log
@Component
public class Users implements Serializable {
    private Integer user_id;
    private String user_name;
    private String login_username;
    private String login_password;

    public Users() {
    }

    public Users(String user_name, String login_username, String login_password) {
        this.user_name = user_name;
        this.login_username = login_username;
        this.login_password = login_password;
    }
}
