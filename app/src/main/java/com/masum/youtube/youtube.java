package com.masum.youtube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class youtube extends AppCompatActivity {
    BottomNavigationView btm_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        btm_nav=findViewById(R.id.btm_nav);
        load(new home(),0);
        btm_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int  id=item.getItemId();

                if (id==R.id.nav_home){
                    load(new home(),0);
                }



                else if (id==R.id.nav_short){

                    load(new yshort(),1);

                }
                else if (id==R.id.nav_plus)
                {

                    load(new Add(),1);

                }
                else if (id==R.id.nav_subs){
                    load(new subcription(),1);


                }

                else{

                    load(new Playlist(),1);

                }


                return true;
            }
        });
//        btm_nav.setSelectedItemId(R.id.nav_home);
    }
    public void load(Fragment fragment, int count){
        FragmentManager frgm=getSupportFragmentManager();
        FragmentTransaction frgt=frgm.beginTransaction();
        if (count==0){
            frgt.add(R.id.frm_lay,fragment);

        }
        else
            frgt.replace(R.id.frm_lay,fragment);
        frgt.commit();
}}