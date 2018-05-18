package com.example.chingili.findmypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chingili.findmypet.data.Pet;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Pet pet = (Pet) getIntent().getParcelableExtra("PET");
        Log.d("test", "onCreate: "+pet.getSize());
    }
}
