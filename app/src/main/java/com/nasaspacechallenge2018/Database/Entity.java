package com.nasaspacechallenge2018.Database;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@org.greenrobot.greendao.annotation.Entity
public class Entity {

    @Id
    int id;

    @Generated(hash = 62634076)
    public Entity(int id) {
        this.id = id;
    }

    @Generated(hash = 1559012531)
    public Entity() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
