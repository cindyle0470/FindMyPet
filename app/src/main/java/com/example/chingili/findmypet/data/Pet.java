package com.example.chingili.findmypet.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chingili on 2018/3/29.
 */

public class Pet {
    @JsonIgnoreProperties(ignoreUnknown = true)   // 防止 json response 中因為出現了 model class 沒定義的變數而產生 exception
    @JsonProperty("id")                    //把 json response 中的 key map到 model class 的變數令到 model class 不用出現有 "_" 的變數名稱
    int id;
    @JsonProperty("type_id")
    int typeId;
    @JsonProperty("person_id")
    int personId;
    @JsonProperty("region_id")
    int regionId;
    @JsonProperty("sub_region")
    String subRegion;
    @JsonProperty("sex")
    String sex;
    @JsonProperty("size")
    String size;
    @JsonProperty("color")
    String color;
    @JsonProperty("description")
    String description;
    @JsonProperty("photos")
    String photo;
    List<PetPhoto> photos = new ArrayList<>();
    @JsonProperty("status")
    boolean status;
    @JsonProperty("contact_person")
    private String contactPerson;
    @JsonProperty("contact_method")
    private String contactMethod;

    public Pet() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int gettypeId() {
        return typeId;
    }

    public void settypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getpersonId() {
        return personId;
    }

    public void setpersonId(int personId) {
        this.personId = personId;
    }

    public int getregionId() {
        return regionId;
    }

    public void setregionId(int regionId) {
        this.regionId = regionId;
    }

    public String subRegion() {
        return subRegion;
    }

    public void setsubRegion(String subRegion) {
        this.subRegion = subRegion;
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

    public List<PetPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PetPhoto> photos) {
        this.photos = photos;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getcontactPerson() {
        return contactPerson;
    }

    public void setcontactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getcontactMethod() {
        return contactMethod;
    }

    public void setcontactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }







}
