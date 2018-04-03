package com.example.chingili.findmypet;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.chingili.findmypet.fragment.FindPetFragment;
import com.example.chingili.findmypet.fragment.PostFragment;
import com.example.chingili.findmypet.fragment.ShareFragment;

public class ChooseActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        findviews();

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    private void findviews() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            // position前加空字串是因參數只接受字串)，Info搜尋viewpager(key)就可搜尋到想知道的輸出正不正確
            Log.i("viewpager", ""+position);

            if (position == 0){
                return new FindPetFragment();   //當position為0時，回傳認養狗的fragment
            } else if (position == 1) {
                return new PostFragment();      //當position為0時，回傳認養貓的fragment
            } else if (position == 2) {
                return new ShareFragment();     //當position為0時，回傳認養其他的fragment
            } else {
                return null;                    //當以上皆非時，回傳null。（一定要設非以上情況回傳什麼，此為系統安全設定）
            }
        }

        @Override
        public int getCount() {
                                             // 因本app總共有3個tab的fragment(findpet,findhome,sharepage), 因不會再變更故寫死3
//        return mFragmentList.size();       // 若未來有可能增減tab，變更回傳的fragment數量,則改為list.size()為好。
            return 3;
        }
    }
}
