package com.example.jsonparse;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FlickerElem {
    private  String Nom;
    private int livreID;

    public FlickerElem(String nom, int id) {
        this.Nom=nom;
        this.livreID = id;
    }
    public FlickerElem() {

    }

    public static List<FlickerElem> getelem(Context context, URL url) throws IOException, JSONException {
        List<FlickerElem> flickElem = new ArrayList<FlickerElem>();
        //JSONObject obj = new JSONObject(Readbodyhttp_Req(context,url));
        System.out.println("ICI GETELEM");
        JSONArray m_jArry = new JSONArray(Readbodyhttp_Req(context,url));

        for (int i=0; i<m_jArry.length(); i++) {
            flickElem.add(
                    new FlickerElem(
                            m_jArry.getJSONObject(i).getString("nom"),
                            m_jArry.getJSONObject(i).getInt("livreID")

                            )
            );
/*m_jArry.getJSONObject(i).getString("nom"),
                            m_jArry.getJSONObject(i).getInt("livreID")*/
        }
        return  flickElem;
        //System.out.println(Readbodyhttp_Req(context,url));

    }


public static String Readbodyhttp_Req(Context constext, URL url) throws IOException {
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    String body = null;
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }

        body = sb.toString();

        Log.d("HTTP-GET", body);



    } catch (Exception e){
        Log.i("Exception", String.valueOf(e));
    }
    return  body;
}
    @Override
    public String toString() {
        return "FlickElem{" +
                "title='" + Nom + '\'' +
                ", ID='" + livreID + '\'' +
                '}';
    }


    public String getNom() {
        return Nom;
    }

    public int getID() {
        return livreID;
    }

}
