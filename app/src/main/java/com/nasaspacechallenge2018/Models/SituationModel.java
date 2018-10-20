package com.nasaspacechallenge2018.Models;

import com.nasaspacechallenge2018.Database.Item;

import java.util.ArrayList;

public class SituationModel {

    private String MAIN_DESCRIPTION;
    private String COMPONENT_TEXT_BASE;
    private int BACKGROUND;
    private String ERROR_MESSAGE;
    private int ID;

    public SituationModel(String MAIN_DESCRIPTION, String COMPONENT_TEXT_BASE, int BACKGROUND, String ERROR_MESSAGE, int ID) {
        this.MAIN_DESCRIPTION = MAIN_DESCRIPTION;
        this.COMPONENT_TEXT_BASE = COMPONENT_TEXT_BASE;
        this.BACKGROUND = BACKGROUND;
        this.ERROR_MESSAGE = ERROR_MESSAGE;
        this.ID = ID;
    }

    public String getMAIN_DESCRIPTION() {
        return MAIN_DESCRIPTION;
    }

    public void setMAIN_DESCRIPTION(String MAIN_DESCRIPTION) {
        this.MAIN_DESCRIPTION = MAIN_DESCRIPTION;
    }

    public String getCOMPONENT_TEXT_BASE() {
        return COMPONENT_TEXT_BASE;
    }

    public void setCOMPONENT_TEXT_BASE(String COMPONENT_TEXT_BASE) {
        this.COMPONENT_TEXT_BASE = COMPONENT_TEXT_BASE;
    }

    public int getBACKGROUND() {
        return BACKGROUND;
    }

    public void setBACKGROUND(int BACKGROUND) {
        this.BACKGROUND = BACKGROUND;
    }

    public String getERROR_MESSAGE() {
        return ERROR_MESSAGE;
    }

    public void setERROR_MESSAGE(String ERROR_MESSAGE) {
        this.ERROR_MESSAGE = ERROR_MESSAGE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
