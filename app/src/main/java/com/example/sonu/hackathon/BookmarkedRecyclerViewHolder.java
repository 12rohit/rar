package com.example.sonu.hackathon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sonu on 03-02-2017.
 */

public class BookmarkedRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tv1, tv2;
    ImageView imageView;
    public BookmarkedRecyclerViewHolder(View itemView) {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.list_title);
        tv2 = (TextView) itemView.findViewById(R.id.list_desc);
        imageView = (ImageView) itemView.findViewById(R.id.list_avatar);
    }
}
