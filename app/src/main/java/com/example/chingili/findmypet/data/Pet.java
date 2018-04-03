package com.example.chingili.findmypet.data;

/**
 * Created by chingili on 2018/3/29.
 */

public class Pet {
    int id;
    int type_id;
    int person_id;
    int region_id;
    String sub_region;
    String sex;
    String size;
    String color;
    String description;
    String photos;
    boolean status;
    private String contact_person;

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getContact_method() {
        return contact_method;
    }

    public void setContact_method(String contact_method) {
        this.contact_method = contact_method;
    }

    private String contact_method;

    public Pet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getSub_region() {
        return sub_region;
    }

    public void setSub_region(String sub_region) {
        this.sub_region = sub_region;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Pet( int region_id, String sex, String size, String description) {


        this.region_id = region_id;
        this.sex = sex;
        this.size = size;
        this.description = description;

    }
}
