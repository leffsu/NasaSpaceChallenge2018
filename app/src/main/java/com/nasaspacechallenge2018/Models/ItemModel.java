package com.nasaspacechallenge2018.Models;

public class ItemModel {

    private int ID;
    private int SITUATION_ID;
    private String NAME;
    private String ACTION;
    private int REQUIRED;

    public ItemModel(int ID, int SITUATION_ID, String NAME, String ACTION, int REQUIRED) {
        this.ID = ID;
        this.SITUATION_ID = SITUATION_ID;
        this.NAME = NAME;
        this.ACTION = ACTION;
        this.REQUIRED = REQUIRED;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSITUATION_ID() {
        return SITUATION_ID;
    }

    public void setSITUATION_ID(int SITUATION_ID) {
        this.SITUATION_ID = SITUATION_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getACTION() {
        return ACTION;
    }

    public void setACTION(String ACTION) {
        this.ACTION = ACTION;
    }

    public int getREQUIRED() {
        return REQUIRED;
    }

    public void setREQUIRED(int REQUIRED) {
        this.REQUIRED = REQUIRED;
    }
}
