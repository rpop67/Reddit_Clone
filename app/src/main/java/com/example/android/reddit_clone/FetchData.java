/**
 * Created by Akanksha_Rajwar on 15-08-2018.
 */
package com.example.android.reddit_clone;

import android.os.AsyncTask;

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

/**
 * Created by Abhishek Panwar on 7/14/2017.
 */

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
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

            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);

                singleParsed =  "Title:" + JO.get("data.data.title") + "\n"+
                        "Upvotes:" + JO.get("data.data.ups") + "\n"+
                        "Author:" + JO.get("data.data.author") + "\n"+
                        "Comments:" + JO.get("data.data.num_comments") + "\n";


                dataParsed = dataParsed + singleParsed +"\n" ;


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        FinalActivity.data.setText(this.dataParsed);

    }
}