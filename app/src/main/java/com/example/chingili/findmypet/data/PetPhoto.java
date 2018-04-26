package com.example.chingili.findmypet.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chingili on 2018/4/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetPhoto {
    @JsonProperty("image_url")
    private String imageUrl;
    private Pet pet;

    public PetPhoto() {
    }


    public String getImage() {

        return imageUrl;
    }

    public void setImage(String image) {
        this.imageUrl = image;
    }

}
