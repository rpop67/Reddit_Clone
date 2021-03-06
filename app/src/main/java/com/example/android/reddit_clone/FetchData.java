/**
 * Created by Akanksha_Rajwar on 15-08-2018.
 * FetchData Class
 */
package com.example.android.reddit_clone;

import android.os.AsyncTask;
import android.widget.ListView;

import com.example.android.reddit_clone.Class_and_Adapter.InfoAdapter;
import com.example.android.reddit_clone.Class_and_Adapter.InfoCard;
import com.example.android.reddit_clone.FinalActivity;
import com.example.android.reddit_clone.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Abhishek Panwar on 7/14/2017.
 */

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String parsedData="";
    String singleParsed ="";
    public static  int total;
    final ArrayList<InfoCard> JSONDataList = new ArrayList<InfoCard>();

    //Arrays for storing manipulated data respectively
    public static String Author[];
    public static int Shares[];
    public static int Comments[];
    public  static String Title[];
    public static int Ups[];

    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL("https://api.myjson.com/bins/vdfto");
            //URL url = new URL("https://api.myjson.com/bins/j5f6b");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
         //start here


                JSONObject baseJSONResponse = new JSONObject(data);

                //Getting head "kind".
                String kind = baseJSONResponse.getString("kind");

                //Getting data.
                JSONObject dataObject = baseJSONResponse.getJSONObject("data");
                //This contains --> modhash, dist, children array, after, and before.

                //Getting children array.
                JSONArray childrenArray = dataObject.getJSONArray("children");

                total=childrenArray.length();
                Title=new String[total];
                Ups=new int[total];
                Author=new String[total];
                Shares=new int[total];
                Comments=new int[total];

                for (int i = 0; i < childrenArray.length(); i++) {

                    //Getting the first object.
                    JSONObject childObject = childrenArray.getJSONObject(i);

                    JSONObject childDataObject = childObject.getJSONObject("data");
                    //childDataObject has another 92 items.

                    //Getting title.
                    String title = childDataObject.getString("title");
                    int ups = childDataObject.getInt("ups");
                    String author=childDataObject.getString("author");
                    int shares=childDataObject.getInt("num_crossposts");
                    int comments=childDataObject.getInt("num_comments");

                    Title[i]=title;
                    Ups[i]=ups;
                    Author[i]=author;
                    Shares[i]=shares;
                    Comments[i]=comments;

                    //jsonDataList.add(new InfoCard(title, ups));
                    parsedData += shares + "****" + ups + "    \n ";

                }

                //passing list to adapter


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
         return null;
    }



    static public int getJSONShares(int index)
    {
        return Shares[index];
    }

    static public int getJSONComments(int index)
    {
        return Comments[index];
    }

    static public String getJSONAuthor(int index)
    {
        return Author[index];
    }

     public static int getTotal()
    {
        return total;
    }

     public static String getJSONTitle(int index)
    {
        return Title[index];
    }

     public static int getJSONUps(int index)
    {
        return Ups[index];
    }

    public ArrayList<InfoCard> CreateJSONList()
    {
        return JSONDataList;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        for (int i = 0; i < total; i++)
        {
            JSONDataList.add(new InfoCard(Author[i],Title[i],Ups[i],Comments[i],Shares[i]));
        }

    }
}