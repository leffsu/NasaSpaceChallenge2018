package com.nasaspacechallenge2018.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Item {

    @Id
    int id;

    @Property
    int subsituationId;

    @Property
    String name;

    @Property
    String action;

    @Generated(hash = 1330631792)
    public Item(int id, int subsituationId, String name, String action) {
        this.id = id;
        this.subsituationId = subsituationId;
        this.name = name;
        this.action = action;
    }

    @Generated(hash = 1470900980)
    public Item() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubsituationId() {
        return this.subsituationId;
    }

    public void setSubsituationId(int subsituationId) {
        this.subsituationId = subsituationId;
    }
}
