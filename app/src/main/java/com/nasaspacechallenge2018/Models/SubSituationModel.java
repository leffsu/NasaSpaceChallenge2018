package com.nasaspacechallenge2018.Models;

public class SubSituationModel {

    private int ID;
    private String TITLE_SUB_SITUATION;
    private String SYNONYM_SUB_SITUATION;
    private int ID_SITUATION;
    private int BACKGROUND_SUB_SITUATION;
    private String DISCRIBE_SUB_SITUATION;

    public SubSituationModel(int ID, String TITLE_SUB_SITUATION, String SYNONYM_SUB_SITUATION, int ID_SITUATION, int BACKGROUND_SUB_SITUATION, String DISCRIBE_SUB_SITUATION) {
        this.ID = ID;
        this.TITLE_SUB_SITUATION = TITLE_SUB_SITUATION;
        this.SYNONYM_SUB_SITUATION = SYNONYM_SUB_SITUATION;
        this.ID_SITUATION = ID_SITUATION;
        this.BACKGROUND_SUB_SITUATION = BACKGROUND_SUB_SITUATION;
        this.DISCRIBE_SUB_SITUATION = DISCRIBE_SUB_SITUATION;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTITLE_SUB_SITUATION() {
        return TITLE_SUB_SITUATION;
    }

    public void setTITLE_SUB_SITUATION(String TITLE_SUB_SITUATION) {
        this.TITLE_SUB_SITUATION = TITLE_SUB_SITUATION;
    }

    public String getSYNONYM_SUB_SITUATION() {
        return SYNONYM_SUB_SITUATION;
    }

    public void setSYNONYM_SUB_SITUATION(String SYNONYM_SUB_SITUATION) {
        this.SYNONYM_SUB_SITUATION = SYNONYM_SUB_SITUATION;
    }

    public int getID_SITUATION() {
        return ID_SITUATION;
    }

    public void setID_SITUATION(int ID_SITUATION) {
        this.ID_SITUATION = ID_SITUATION;
    }

    public int getBACKGROUND_SUB_SITUATION() {
        return BACKGROUND_SUB_SITUATION;
    }

    public void setBACKGROUND_SUB_SITUATION(int BACKGROUND_SUB_SITUATION) {
        this.BACKGROUND_SUB_SITUATION = BACKGROUND_SUB_SITUATION;
    }

    public String getDISCRIBE_SUB_SITUATION() {
        return DISCRIBE_SUB_SITUATION;
    }

    public void setDISCRIBE_SUB_SITUATION(String DISCRIBE_SUB_SITUATION) {
        this.DISCRIBE_SUB_SITUATION = DISCRIBE_SUB_SITUATION;
    }
}
