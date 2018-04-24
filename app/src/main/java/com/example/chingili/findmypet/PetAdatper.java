package com.example.chingili.findmypet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chingili.findmypet.data.Pet;

import java.util.List;

/**
 * Created by chingili on 2018/3/29.
 */

public class PetAdatper extends RecyclerView.Adapter < PetAdatper.ViewHolder> {
    private List<Pet> petList;

    public PetAdatper(List<Pet> pets) {
        this.petList = pets;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_pet, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Pet pet = petList.get(position);


        holder.tvArea.setText(String.valueOf(pet.getregionId()));
        holder.tvSex.setText(pet.getSex());
        holder.tvSize.setText(pet.getSize());
        holder.tvMassage.setText(pet.getDescription());
    }

    @Override
    public int getItemCount() {
            return petList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        //private final ImageView img;
        private final TextView tvArea;
        private final TextView tvSex;
        private final TextView tvSize;
        private final TextView tvMassage;

        public ViewHolder(View itemView) {
            super(itemView);

            //img = itemView.findViewById(R.id.img);
            tvArea = itemView.findViewById(R.id.tv_area);
            tvSex = itemView.findViewById(R.id.tv_sex);
            tvSize = itemView.findViewById(R.id.tv_size);
            tvMassage = itemView.findViewById(R.id.tv_massage);

        }
    }
}
