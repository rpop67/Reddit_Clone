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
    String postTitle;
    int postUps;
    int postComments;
    int postShares;
    String postAuthor;
    static FetchData fetch;
    int count;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        fetch = new FetchData();
        final ArrayList<InfoCard> JSONList = fetch.CreateJSONList();

           // JSONDataList.add(new InfoCard("lala","hoho",456,454,232));}
        /*JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(1),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(2),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(3),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(4),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));
        JSONDataList.add(new InfoCard("lala",fetch.getJSONTitle(0),456,454,232));*/


       // }
        InfoAdapter adapter = new InfoAdapter(getContext(), JSONList);
        final ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);



        //end
        return view;
    }

}
