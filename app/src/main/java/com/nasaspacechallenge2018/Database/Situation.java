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
    String componentText;

    @Transient
    List<SubSituation> subSituations;

    @Generated(hash = 1367395513)
    public Situation(int id, String mainDescription, String componentText) {
        this.id = id;
        this.mainDescription = mainDescription;
        this.componentText = componentText;
    }

    @Generated(hash = 1070369673)
    public Situation() {
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

    public String getComponentText() {
        return this.componentText;
    }

    public void setComponentText(String componentText) {
        this.componentText = componentText;
    }

    public static List<Situation> getSituations() {
        return parseSituations(Situation.getSituations());
    }

    public static Situation getSituation(int situationId) {
        return parseSituations(App.getDaoSession().getSituationDao().
                queryBuilder().where(SituationDao.Properties.Id.eq(situationId)).unique());
    }

    public static Situation parseSituations(Situation situation) {

        situation.setSubSituations(SubSituation.getSubSituationsBySituationId(situation.getId()));

        return situation;
    }

    public static List<Situation> parseSituations(List<Situation> situations) {
        for (Situation situation :
                situations) {
            situation.setSubSituations(SubSituation.getSubSituationsBySituationId(situation.getId()));
        }
        return situations;
    }

    public List<SubSituation> getSubSituations() {
        return subSituations;
    }

    public void setSubSituations(List<SubSituation> subSituations) {
        this.subSituations = subSituations;
    }
}
