package com.nasaspacechallenge2018.Database;

import com.nasaspacechallenge2018.App;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

@Entity
public class Situation {

    @Id
    int id;

    @Property
    String mainDescription;

    @Property
    String componentTextBase;

    @Transient
    String currentComponentText;

    @Property
    int background;

    @Property
    String errorMessage;

    @Transient
    List<Item> items;



    @Generated(hash = 631399731)
    public Situation(int id, String mainDescription, String componentTextBase, int background,
            String errorMessage) {
        this.id = id;
        this.mainDescription = mainDescription;
        this.componentTextBase = componentTextBase;
        this.background = background;
        this.errorMessage = errorMessage;
    }

    @Generated(hash = 1070369673)
    public Situation() {
    }

    

    public static List<Situation> getSituations() {
        return parseSituations(App.getDaoSession().getSituationDao().loadAll());
    }

    public static Situation getSituation(int situationId) {
        return parseSituations(App.getDaoSession().getSituationDao().
                queryBuilder().where(SituationDao.Properties.Id.eq(situationId)).unique());
    }

    public static List<Situation> parseSituations(List<Situation> situations){
        for (Situation situation :
                situations) {
            situation.setItems(App.getDaoSession().getItemDao().
                    queryBuilder().where(ItemDao.Properties.SituationId.eq(situation.getId())).list());
        }
        return situations;
    }

    public static Situation parseSituations(Situation situation){
            situation.setItems(App.getDaoSession().getItemDao().
                    queryBuilder().where(ItemDao.Properties.SituationId.eq(situation.getId())).list());
        return situation;
    }

    public String getCurrentComponentText() {
        return currentComponentText;
    }

    public void setCurrentComponentText(String currentComponentText) {
        this.currentComponentText = currentComponentText;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getBackground() {
        return this.background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainDescription() {
        return this.mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getComponentTextBase() {
        return this.componentTextBase;
    }

    public void setComponentTextBase(String componentTextBase) {
        this.componentTextBase = componentTextBase;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
