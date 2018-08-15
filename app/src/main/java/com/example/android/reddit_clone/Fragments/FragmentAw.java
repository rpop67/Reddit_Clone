package com.example.android.reddit_clone.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.reddit_clone.Class_and_Adapter.InfoAdapter;
import com.example.android.reddit_clone.Class_and_Adapter.InfoCard;
import com.example.android.reddit_clone.FetchData;
import com.example.android.reddit_clone.R;

import java.util.ArrayList;

/**
 * Created by Akanksha_Rajwar on 15-08-2018.
 */

public class FragmentAw extends android.support.v4.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        final ArrayList<InfoCard> JSONDataList = new ArrayList<InfoCard>();

        int count= FetchData.getTotal();
        String postTitle;
        int postUps;
        int postComments;
        int postShares;
        String postAuthor;


        for(int i=0;i<count;i++)
        {
            postTitle=FetchData.getJSONTitle(i);
            postUps=FetchData.getJSONUps(i);
            postAuthor=FetchData.getJSONAuthor(i);
            postComments=FetchData.getJSONComments(i);
            postShares=FetchData.getJSONShares(i);
            JSONDataList.add(new InfoCard(postAuthor,postTitle,postUps,postComments,postShares));

        }
        InfoAdapter adapter = new InfoAdapter(getContext(), JSONDataList);
        final ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);



        //end
        return view;
    }

}
