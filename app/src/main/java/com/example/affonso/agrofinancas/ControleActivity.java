package com.example.affonso.agrofinancas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class ControleActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout =(TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Controle de Gastos");

        SelectTabAdapter selectTabAdapter = new SelectTabAdapter(getSupportFragmentManager());
        tabLayout.addTab(tabLayout.newTab().setText(selectTabAdapter.getTitulos()[0]));
        tabLayout.addTab(tabLayout.newTab().setText(selectTabAdapter.getTitulos()[1]));
        viewPager.setAdapter(selectTabAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    private class SelectTabAdapter extends FragmentStatePagerAdapter{

        private String titulos[] = new String[]{"Gastos","Ganhos"};

        public SelectTabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if(position == 0){
                fragment = new FragGastos();
            }
            else{
                fragment = new FragGanhos();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("id",position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        public String[] getTitulos(){
            return titulos;
        }
    }
}
