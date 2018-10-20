package com.nasaspacechallenge2018.Database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

@Entity
public class Item {

    @Id
    int id;

    @Property
    int situationId;

    @Property
    String name;

    @Property
    String action;

    @Transient
    int taken;

    @Property
    boolean required;

    @Generated(hash = 1851249132)
    public Item(int id, int situationId, String name, String action,
            boolean required) {
        this.id = id;
        this.situationId = situationId;
        this.name = name;
        this.action = action;
        this.required = required;
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

    public boolean getRequired() {
        return this.required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getSituationId() {
        return this.situationId;
    }

    public void setSituationId(int situationId) {
        this.situationId = situationId;
    }
}
