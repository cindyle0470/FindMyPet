package com.example.chingili.findmypet.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chingili.findmypet.R;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chingili on 2018/3/31.
 */

public class PetItem {
    private Context context;
    private Pet pet;
    private ImageView photo;
    private TextView tvArea, tvSex, tvSize, tvMassage;
    private String url;

    public PetItem(Context ctx, Pet pet) {
        context = ctx;
        this.pet = pet;
    }

    private LayoutInflater getInflater() {
        return ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }



    public View getView() {
        View resultView = getInflater().inflate(R.layout.item_pet, null);

        findViews(resultView);
        setArea();
        setSex();
        tvSize.setText(pet.size);
        tvMassage.setText(pet.description);

        //getPhotos();
        return resultView;
    }





    private void setSex() {
        switch (pet.sex) {
            case "1":
                tvSex.setText("公");
                break;
            case "2":
                tvSex.setText("母");
                break;
            case "3":
                tvSex.setText("不明");
                break;
        }
    }

    private void setArea() {
        switch (pet.getregionId()) {
            case 1:
                tvArea.setText("基隆市");
                break;
            case 2:
                tvArea.setText("台北市");
                break;
            case 3:
                tvArea.setText("新北市");
                break;
            case 4:
                tvArea.setText("桃園市");
                break;
            case 5:
                tvArea.setText("新竹市/縣");
                break;
            case 6:
                tvArea.setText("苗栗縣");
                break;
            case 7:
                tvArea.setText("台中市");
                break;
            case 8:
                tvArea.setText("彰化縣");
                break;
            case 9:
                tvArea.setText("南投縣");
                break;
            case 10:
                tvArea.setText("雲林縣");
                break;
            case 11:
                tvArea.setText("嘉義市/縣");
                break;
            case 12:
                tvArea.setText("台南市");
                break;
            case 13:
                tvArea.setText("高雄市");
                break;
            case 14:
                tvArea.setText("屏東縣");
                break;
            case 15:
                tvArea.setText("台東縣");
                break;
            case 16:
                tvArea.setText("花蓮縣");
                break;
            case 17:
                tvArea.setText("宜蘭縣");
                break;
        }
    }

//    private void getPhotos () {
//        VolleyRequest volleyRequest = VolleyRequest.getInstance(context);
//        if (moKid.photoList != null && moKid.photoList.size() > 0) {
//            url = moKid.photoList.get(0);         //選第一個網址的照片
//
//            ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
//                @Override
//                public void onResponse(Bitmap response) {
//                    photo.setImageBitmap(response);
//                }
//            }, 0, 0, null, new Response.ErrorListener() {                 // 0, 0 表示指定圖片最大寬、高，若圖片超過會自動壓縮大小，若0表示不管圖片
//                @Override                                                 // 大小皆不壓縮顯示，null表示解析度（ex：ARGB_8888為最佳）
//                public void onErrorResponse(VolleyError error) {
//                    photo.setImageResource(R.drawable.ic_error);
//
//                }
//            });
//            volleyRequest.addRequest(imageRequest);
//        }
//
//    }



    private void findViews(View view) {
        photo = (ImageView) view.findViewById(R.id.img);
        tvArea = (TextView) view.findViewById(R.id.tv_area);
        tvSex = (TextView) view.findViewById(R.id.tv_sex);
        tvSize = (TextView) view.findViewById(R.id.tv_size);
        tvMassage = (TextView) view.findViewById(R.id.tv_massage);

    }
}
