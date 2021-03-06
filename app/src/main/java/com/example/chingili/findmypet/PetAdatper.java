package com.example.chingili.findmypet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chingili.findmypet.data.Pet;
import com.example.chingili.findmypet.data.PetPhoto;

import java.util.List;

/**
 * Created by chingili on 2018/3/29.
 */

public class PetAdatper extends RecyclerView.Adapter < PetAdatper.ViewHolder> {
    private List<Pet> petList;
    private Context context;
    private Pet pet;
    private OnItemClickListener onItemClickListener = null;


    public PetAdatper(List<Pet> pets, OnItemClickListener listener) {
        this.petList = pets;
        this.onItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_pet, parent, false);
        ViewHolder viewHolder = new ViewHolder(view,onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        pet = petList.get(position);
        holder.setModel(context, pet);
        holder.itemView.setTag(pet);                    // 2，做一個標籤，未來點擊時才能抓到這個item

    }



    @Override
    public int getItemCount() {
            return petList.size();
    }

    public static interface OnItemClickListener {
        void onItemClick(View view);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView tvArea;
        private TextView tvSex;
        private TextView tvSize;
        private TextView tvMassage;

        public ViewHolder(final View itemView, final OnItemClickListener listener) {

            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvArea = itemView.findViewById(R.id.tv_area);
            tvSex = itemView.findViewById(R.id.tv_sex);
            tvSize = itemView.findViewById(R.id.tv_size);
            tvMassage = itemView.findViewById(R.id.tv_massage);
            itemView.setOnClickListener(new View.OnClickListener() {       // 1. 設定點擊事件
                @Override
                public void onClick(View v) {
                    listener.onItemClick(itemView);
                }
            });

        }

        public void setModel(Context context, Pet pet) {
            List<PetPhoto> photos = pet.getPhotos();

            if (photos != null && photos.size() > 0) {
                Glide.with(context).load(photos.get(0).getImage()).into(img);
            }

            tvArea.setText(String.valueOf(pet.getregionId()));
            tvSex.setText(pet.getSex());
            tvSize.setText(pet.getSize());
            tvMassage.setText(pet.getDescription());
        }

    }
}
