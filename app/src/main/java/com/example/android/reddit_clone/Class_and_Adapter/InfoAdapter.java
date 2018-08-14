package com.example.android.reddit_clone.Class_and_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.reddit_clone.R;

import java.util.ArrayList;

/**
 * Created by Akanksha_Rajwar on 15-08-2018.
 */

public class InfoAdapter extends ArrayAdapter<InfoCard> {
    //Constructor
    public InfoAdapter(Context context, ArrayList<InfoCard> infoCards)
    {
        super(context, 0, infoCards);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.post_layout, parent, false);
        }
        InfoCard currentData = getItem(position);

        //Declare elements and set data


        TextView authorTextView = listItemView.findViewById(R.id.main_author_name);
        authorTextView.setText(currentData.getAuthor());

        TextView titleTextView = listItemView.findViewById(R.id.main_title);
        titleTextView.setText(currentData.getPostTitle());

        TextView upvotesTextView=listItemView.findViewById(R.id.main_upvote_count);
        upvotesTextView.setText(currentData.getUpvotes());

        TextView commentsTextView=listItemView.findViewById(R.id.main_comment_count);
        commentsTextView.setText(currentData.getUpcomments());

        TextView sharesTextView=listItemView.findViewById(R.id.main_share_count);
        sharesTextView.setText(currentData.getUpshares());

        ImageView postImageView=listItemView.findViewById(R.id.main_post_image);
        postImageView.setImageResource(currentData.getImageres());


        //reached end
        return listItemView;
    }
}
