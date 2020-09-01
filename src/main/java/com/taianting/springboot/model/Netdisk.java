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
public class Netdisk implements Serializable {
    @Id
    private Integer netdisk_id;
    private String netdisk_time;
    private String netdisk_name;
    private String netdisk_size;
    private String netdisk_url;
    private String netdisk_lujing;
    private String netdisk_icon;
    private Integer netdisk_state;
    private String user_id;
    private String netdisk_uploaduser;


    public Netdisk() {
    }

    public Netdisk(String netdisk_time,
                   String netdisk_name,
                   String netdisk_size,
                   String netdisk_url,
                   String netdisk_lujing,
                   String netdisk_icon,
                   Integer netdisk_state,
                   String user_id,
                   String netdisk_uploaduser) {
        this.netdisk_time = netdisk_time;
        this.netdisk_name = netdisk_name;
        this.netdisk_size = netdisk_size;
        this.netdisk_url = netdisk_url;
        this.netdisk_lujing = netdisk_lujing;
        this.netdisk_icon = netdisk_icon;
        this.netdisk_state = netdisk_state;
        this.user_id = user_id;
        this.netdisk_uploaduser = netdisk_uploaduser;
    }

    public Netdisk(Integer netdisk_id,
                   String netdisk_name,
                   String netdisk_icon,
                   Integer netdisk_state) {
        this.netdisk_id = netdisk_id;
        this.netdisk_name = netdisk_name;
        this.netdisk_icon = netdisk_icon;
        this.netdisk_state = netdisk_state;
    }
}
