package com.example.chingili.findmypet.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chingili on 2018/3/29.
 */

public class Pet implements Parcelable {

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

    public Pet(int id, int typeId, int personId, int regionId, String subRegion, String sex, String size, String color, String description, String photo, List<PetPhoto> photos, boolean status, String contactPerson, String contactMethod) {
        this.id = id;
        this.typeId = typeId;
        this.personId = personId;
        this.regionId = regionId;
        this.subRegion = subRegion;
        this.sex = sex;
        this.size = size;
        this.color = color;
        this.description = description;
        this.photo = photo;
        this.photos = photos;
        this.status = status;
        this.contactPerson = contactPerson;
        this.contactMethod = contactMethod;
    }

//    public Pet(int regionId, String subRegion, String sex, String size, String color, String description, String contactPerson, String contactMethod) {
//        this.regionId = regionId;
//        this.subRegion = subRegion;
//        this.sex = sex;
//        this.size = size;
//        this.color = color;
//        this.description = description;
//        this.contactPerson = contactPerson;
//        this.contactMethod = contactMethod;
//    }

    protected Pet(Parcel in) {
        id = in.readInt();
        typeId = in.readInt();
        personId = in.readInt();
        regionId = in.readInt();
        subRegion = in.readString();
        sex = in.readString();
        size = in.readString();
        color = in.readString();
        description = in.readString();
        photo = in.readString();
        status = in.readByte() != 0;
        contactPerson = in.readString();
        contactMethod = in.readString();
    }

    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

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

    public String getregionId() {
        switch (regionId) {
            case 1:
                return "基隆市";
            case 2:
                return "台北市";
            case 3:
                return "新北市";
            case 4:
                return "桃園市";
            case 5:
                return "新竹市/縣";
            case 6:
                return "苗栗縣";
            case 7:
                return "台中市";
            case 8:
                return "彰化縣";
            case 9:
                return "南投縣";
            case 10:
                return "雲林縣";
            case 11:
                return "嘉義市/縣";
            case 12:
                return "台南市";
            case 13:
                return "高雄市";
            case 14:
                return "屏東縣";
            case 15:
                return "台東縣";
            case 16:
                return "花蓮縣";
            case 17:
                return "宜蘭縣";
        }
        return String.valueOf(regionId);
    }

    public void setregionId(int regionId) {
        this.regionId = regionId;
    }

    public String getsubRegion() {
        return subRegion;
    }

    public void setsubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getSex() {
        switch (sex) {
            case "1":
                return "公";
            case "2":
                return "母";
        }
        return "不明";
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
//    public void photo() {
//        photo = photos.get(0).toString();
//    }
//
//    public String getPhoto() {
//        return photo;
//    }

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(typeId);
        dest.writeInt(personId);
        dest.writeInt(regionId);
        dest.writeString(subRegion);
        dest.writeString(sex);
        dest.writeString(size);
        dest.writeString(color);
        dest.writeString(description);
        dest.writeString(photo);
        dest.writeByte((byte) (status ? 1 : 0));
        dest.writeString(contactPerson);
        dest.writeString(contactMethod);
    }
}
