package com.example.chingili.findmypet.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chingili on 2018/4/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetPhoto {

    @JsonProperty("image_url")
    private String image;

    public PetPhoto() {
    }


    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
