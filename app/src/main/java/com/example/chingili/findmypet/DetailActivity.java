package com.example.chingili.findmypet;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chingili.findmypet.data.Pet;
import com.example.chingili.findmypet.data.PetPhoto;
import com.example.chingili.findmypet.fragment.FindPetFragment;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private TextView region;
    private TextView subRegion;
    private TextView sex;
    private TextView color;
    private TextView size;
    private TextView contactPerson;
    private TextView contactMethod;
    private TextView description;
    private Button backBtn;
    private Button adoptBtn;             //  領養確認按鈕尚未寫
    private ImageView img;
    private String photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Pet pet = (Pet) getIntent().getParcelableExtra("PET");
        Log.d("test", "onCreate: "+pet.getSize());
        findViews();
        region.setText(pet.getregionId());
        subRegion.setText(pet.getsubRegion());
        sex.setText(pet.getSex());
        color.setText(pet.getColor());
        size.setText(pet.getSize());
        contactPerson.setText(pet.getcontactPerson());
        contactMethod.setText(pet.getcontactMethod());
        description.setText(pet.getDescription());

        List<PetPhoto> photos = pet.getPhotos();

        if (photos != null && photos.size() > 0) {
            Glide.with(DetailActivity.this).load(photos).into(img);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void findViews() {
        region = findViewById(R.id.tv_region);
        subRegion = findViewById(R.id.tv_sub_region);
        sex = findViewById(R.id.tv_sex);
        color = findViewById(R.id.tv_color);
        size = findViewById(R.id.tv_size);
        contactPerson = findViewById(R.id.tv_contact_person);
        contactMethod = findViewById(R.id.tv_contact_method);
        description = findViewById(R.id.tv_description);
        backBtn = findViewById(R.id.btn_back);
        adoptBtn = findViewById(R.id.btn_adopt);
        img = findViewById(R.id.img);
    }
}
