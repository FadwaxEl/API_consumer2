package com.example.jsonparse;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    List<FlickerElem> flickerElems;
Context context;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(List<FlickerElem> flickerElems, Context context) {
        this.flickerElems = flickerElems;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return flickerElems.size();
    }

    @Override
    public Object getItem(int position) {
        return flickerElems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /*****************************************/
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null);
            holder = new ViewHolder();
            //holder.mediaView = (ImageView) convertView.findViewById(R.id.media_textView);
            holder.Nom = (TextView) convertView.findViewById(R.id.title_textView);
            //holder.linkView = (TextView) convertView.findViewById(R.id.link_textview);
            holder.ID= (TextView) convertView.findViewById(R.id.date_textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

         FlickerElem elem = this.flickerElems.get(position);
       // Log.i(TAG, "getView: "+elem.getNom());
        System.out.println(elem.getNom());
        holder.Nom.setText(elem.getNom());
        //holder.linkView.setText( elem.getLink());
       holder.ID.setText(String.valueOf(elem.getID()));

        /*Picasso.with(context)
                .load(elem.getMedia())
                .into(holder.mediaView);*/

        return convertView;
    }

    static class ViewHolder {
        ImageView mediaView;
        TextView Nom;
        TextView ID;

    }



}
