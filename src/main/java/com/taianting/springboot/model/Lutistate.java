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
public class Lutistate implements Serializable {
    @Id
    private Integer lutistate_id;
    private Integer luti_id;
    private String lutistate_lururenid;
    private String lutistate_shenherenid;
    private String lutistate_lurubeizhu;
    private String lutistate_shenhebeizhu;
    private Integer lutistate_lurustate;
    private Integer lutistate_shenhestate;
    private Integer lutistate_state;

    public Lutistate() {
    }

    public Lutistate(Integer luti_id,
                     String lutistate_lururenid,
                     String lutistate_lurubeizhu,
                     Integer lutistate_lurustate,
                     Integer lutistate_shenhestate,
                     Integer lutistate_state) {
        this.luti_id = luti_id;
        this.lutistate_lururenid = lutistate_lururenid;
        this.lutistate_lurubeizhu = lutistate_lurubeizhu;
        this.lutistate_lurustate = lutistate_lurustate;
        this.lutistate_shenhestate = lutistate_shenhestate;
        this.lutistate_state = lutistate_state;
    }

    public Lutistate(Integer luti_id,
                     String lutistate_shenherenid,
                     String lutistate_lurubeizhu,
                     String lutistate_shenhebeizhu,
                     Integer lutistate_lurustate,
                     Integer lutistate_shenhestate,
                     Integer lutistate_state) {
        this.luti_id = luti_id;
        this.lutistate_shenherenid = lutistate_shenherenid;
        this.lutistate_lurubeizhu = lutistate_lurubeizhu;
        this.lutistate_shenhebeizhu = lutistate_shenhebeizhu;
        this.lutistate_lurustate = lutistate_lurustate;
        this.lutistate_shenhestate = lutistate_shenhestate;
        this.lutistate_state = lutistate_state;
    }

    public Lutistate(Integer luti_id,
                     String lutistate_lururenid) {
        this.luti_id = luti_id;
        this.lutistate_lururenid = lutistate_lururenid;
    }

    public Lutistate(String lutistate_shenherenid,
                     Integer luti_id) {
        this.lutistate_shenherenid = lutistate_shenherenid;
        this.luti_id = luti_id;
    }
}
