package com.example.chingili.findmypet.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.chingili.findmypet.DetailActivity;
import com.example.chingili.findmypet.PetAdatper;
import com.example.chingili.findmypet.R;
import com.example.chingili.findmypet.data.Pet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FindPetFragment extends Fragment {


    private Toolbar toolbar;
    private TextView tvTitle;
    private ImageView img;
    private Button btnDog;
    private Button btnCat;
    private Button btnOther;
    private TextView tvHello;
    private Bitmap bitmap;
    private Pet pet;
    private RecyclerView recyclerView;
    //private ArrayList<Pet> list;

    public FindPetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_find_pet, container, false);
        findviews(view);

        getPetList(1);
        toolbar.setLogo(R.drawable.ic_dog);

        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDog.setVisibility(View.VISIBLE);
                btnCat.setVisibility(View.GONE);
                btnOther.setVisibility(View.VISIBLE);
                toolbar.setLogo(R.drawable.ic_cat);
                tvTitle.setText(getResources().getText(R.string.cat_zone));
                getPetList(2);
            }
        });

        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDog.setVisibility(View.VISIBLE);
                btnCat.setVisibility(View.VISIBLE);
                btnOther.setVisibility(View.GONE);
                toolbar.setLogo(R.drawable.ic_other);
                tvTitle.setText(getResources().getText(R.string.other_zone));
                getPetList(3);
            }
        });

        btnDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDog.setVisibility(View.GONE);
                btnCat.setVisibility(View.VISIBLE);
                btnOther.setVisibility(View.VISIBLE);
                toolbar.setLogo(R.drawable.ic_dog);
                tvTitle.setText(getResources().getText(R.string.dog_zone));
                getPetList(1);
            }
        });










        return view;
    }





    private void getPetList(int i) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://hair-kids-nest.herokuapp.com/pets.json?type_id=" + i)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getActivity(), "目前尚無資料喔~", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                if (json != null && json.length() > 0){
                    parseJackSON(json);
                } else {



                    //recyclerView.setAdapter(null);    // 若無資料，清空list（若不加這行，會顯示剛貓或狗的資料，因是加載，非先清空再加載）
                    Toast.makeText(getActivity(), "目前尚無資料喔~", Toast.LENGTH_LONG).show();
                }
            }
        });




    }

    private void parseJackSON(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            final ArrayList<Pet> list = objectMapper.readValue(json, new TypeReference<List<Pet>>() {
            });

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    setupRecyclerView(list);
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void setupRecyclerView(List<Pet> list) {
        PetAdatper adatper = new PetAdatper(list, new PetAdatper.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                Pet pet = (Pet) view.getTag();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("PET",pet);
                startActivity(intent);

            }
        });
        recyclerView.setAdapter(adatper);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

    }

    private void findviews(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        tvTitle = view.findViewById(R.id.tv_title);
        img = view.findViewById(R.id.img);
        btnDog = view.findViewById(R.id.btn_dog);
        btnCat = view.findViewById(R.id.btn_cat);
        btnOther = view.findViewById(R.id.btn_other);
        tvHello = view.findViewById(R.id.tv_hello);
        recyclerView = view.findViewById(R.id.recyclerView);
    }

}
