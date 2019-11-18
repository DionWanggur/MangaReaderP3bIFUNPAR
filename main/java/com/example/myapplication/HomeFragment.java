package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private ListView listView;
    private AdapterManga adapterManga;
    protected TextView judul;


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
        this.listView = view.findViewById(R.id.lst_foods);
        this.judul = view.findViewById(R.id.tv_jdl);
        this.adapterManga = new AdapterManga(this);
        this.listView.setAdapter((ListAdapter) adapterManga);
        Manga manga = new Manga("t","x");
        this.adapterManga.add(manga);
        return view;
    }

}
