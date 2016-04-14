package com.example.affonso.agrofinancas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Affonso on 12/04/2016.
 */
public class FragGanhos extends Fragment {

    private ListView listView;

    private List<String> ganhos;

    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_ganhos,container,false);

        AgroFinancasApplication application = (AgroFinancasApplication) getActivity().getApplicationContext();
        ganhos = application.getGanhos();

        listView = (ListView)view.findViewById(R.id.list_item2);
        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,ganhos);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });



        return view;
    }
}
