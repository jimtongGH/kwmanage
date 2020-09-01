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
public class Loginip implements Serializable {
    @Id
    private Integer ip_id;
    private String user_id;
    private String ip_date;
    private String ip_city;
    private String ip_ip;
    private String ip_device;
    private String ip_OS;

    public Loginip() {
    }

    public Loginip(String user_id,
                   String ip_date,
                   String ip_city,
                   String ip_ip,
                   String ip_device,
                   String ip_OS) {
        this.user_id = user_id;
        this.ip_date = ip_date;
        this.ip_city = ip_city;
        this.ip_ip = ip_ip;
        this.ip_device = ip_device;
        this.ip_OS = ip_OS;
    }
}
