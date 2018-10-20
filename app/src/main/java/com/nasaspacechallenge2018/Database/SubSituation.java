package com.nasaspacechallenge2018.Database;

import com.nasaspacechallenge2018.App;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

@Entity
public class SubSituation {

    @Id
    int id;

    @Property
    int situationId;

    @Property
    String name;

    @Property
    String componentText;

    @Transient
    List<Item> items;

    @Generated(hash = 1843923789)
    public SubSituation(int id, int situationId, String name,
                        String componentText) {
        this.id = id;
        this.situationId = situationId;
        this.name = name;
        this.componentText = componentText;
    }

    @Generated(hash = 17375987)
    public SubSituation() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSituationId() {
        return this.situationId;
    }

    public void setSituationId(int situationId) {
        this.situationId = situationId;
    }

    public String getComponentText() {
        return this.componentText;
    }

    public void setComponentText(String componentText) {
        this.componentText = componentText;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    static List<SubSituation> getSubSituationsBySituationId(int situationId){
        return parseSubSituation(App.getDaoSession().getSubSituationDao().queryBuilder().where(SubSituationDao.Properties.Id.eq(situationId)).list());
    }

    public static SubSituation getSubsituationById(int subsituationid) {
        return parseSubSituation(App.getDaoSession().getSubSituationDao().queryBuilder().where(SubSituationDao.Properties.Id.eq(subsituationid)).unique());
    }

    public static List<SubSituation> getSubsituations() {
        return parseSubSituation(App.getDaoSession().getSubSituationDao().loadAll());
    }

    private static List<SubSituation> parseSubSituation(List<SubSituation> subSituations) {
        for (SubSituation sub :
                subSituations) {
            sub.setItems(App.getDaoSession().getItemDao().queryBuilder().where(ItemDao.Properties.SubsituationId.eq(sub.getId())).list());
        }
        return subSituations;
    }

    private static SubSituation parseSubSituation(SubSituation subSituation) {

        subSituation.setItems(App.getDaoSession().getItemDao().queryBuilder().where(ItemDao.Properties.SubsituationId.eq(subSituation.getId())).list());

        return subSituation;
    }
}
