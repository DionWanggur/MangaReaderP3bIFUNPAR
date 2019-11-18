package com.example.myapplication;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AdapterManga  extends RecyclerView.Adapter<AdapterManga.ViewHolder> {
    List<Manga> mangaList;
    protected Activity activity;

    public AdapterManga(HomeFragment activity) {
        this.activity = activity.getActivity();
        this.mangaList = new LinkedList<>();
    }

    public void add(Manga manga){
        this.mangaList.add(manga);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.mnga_list_item,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.judul.setText(mangaList.get(position).getJudul());
        holder.baca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Manga manga = new Manga("mangaBangsat","gambarnya");
                mangaList.add(manga);
                Log.d("debug","clicked!");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView judul;
        protected ImageView gambar;
        protected Button baca;
        private int position;

        public ViewHolder(View view) {
            super(view);
            this.judul = view.findViewById(R.id.tv_jdl);
            this.gambar = view.findViewById(R.id.iv_gmr);
            this.baca = view.findViewById(R.id.btn_bc);
        }

    }
}
