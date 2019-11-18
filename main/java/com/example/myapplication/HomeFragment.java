package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HomeFragment extends Fragment {
    private RecyclerView listView;
    private RecyclerView.Adapter adapterManga;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList manga;
    protected TextView judul;
    protected Button entot;


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("title", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        this.listView =  view.findViewById(R.id.lst_foods);
        this.entot = view.findViewById(R.id.btn_ngentot);
        this.manga = new ArrayList();

        this.judul = view.findViewById(R.id.tv_jdl);
        this.layoutManager = new LinearLayoutManager(view.getContext());
        final Random random = new Random();



        this.entot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ArrayList ma = new ArrayList();
                Manga mtrt = new Manga("eoiuou ","x");

                ma.add(mtrt);
                manga.addAll(ma);
                adapterManga = new AdapterManga(manga);
                listView.setAdapter(adapterManga);
                adapterManga.notifyDataSetChanged();
                Log.d("tot","entot");
            }
        });
        Manga m = new Manga(random.nextInt()+" ","x");
        manga.add(m);
        adapterManga = new AdapterManga(manga);
        listView.setAdapter(adapterManga);
        listView.setLayoutManager(layoutManager);
        adapterManga.notifyDataSetChanged();
        return view;
    }

}
