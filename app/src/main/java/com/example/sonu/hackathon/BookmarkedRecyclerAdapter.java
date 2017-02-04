package com.example.sonu.hackathon;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Sonu on 03-02-2017.
 */

public class BookmarkedRecyclerAdapter extends RecyclerView.Adapter<BookmarkedRecyclerViewHolder> {

    String[] name ;
    String[] place;

    Context context;
    LayoutInflater inflater;

    public BookmarkedRecyclerAdapter(Context context,String[] name,String[] place) {
        this.context = context;
        this.name = name;
        this.place = place;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BookmarkedRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.bookmarked_item_list, parent, false);

        BookmarkedRecyclerViewHolder viewHolder = new BookmarkedRecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BookmarkedRecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.tv2.setText(place[position]);
        holder.imageView.setOnClickListener(clickListener);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            BookmarkedRecyclerViewHolder vholder = (BookmarkedRecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();

            Toast.makeText(context, "This is position " + position, Toast.LENGTH_LONG).show();

        }
    };
    @Override
    public int getItemCount() {
        return name.length;
    }
}
