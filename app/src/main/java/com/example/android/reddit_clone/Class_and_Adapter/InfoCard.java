package com.example.android.reddit_clone.Class_and_Adapter;

/**
 * Created by Akanksha_Rajwar on 15-08-2018.
 */

public class InfoCard {
    private String author;
    private int imageres;
    private int upvotes;
    private int upcomments;
    private int upshares;
    private String title;


    public InfoCard(String sentAuthor, String sentTitle, int sentImgRes, int sentUpvotes, int sentUpComments, int sentUpShares) {
        author = sentAuthor;
        imageres = sentImgRes;
        title = sentTitle;
        upvotes = sentUpvotes;
        upcomments = sentUpComments;
        upshares = sentUpShares;

    }

    public String getAuthor()
    {
        return author;
    }
    public String getPostTitle()
    {
        return title;
    }
    public int getImageres()
    {
        return imageres;
    }

    public int getUpvotes()
    {
        return upvotes;
    }

    public int getUpshares()
    {
        return upshares;
    }
    public int getUpcomments()
    {
        return upcomments;
    }
}

