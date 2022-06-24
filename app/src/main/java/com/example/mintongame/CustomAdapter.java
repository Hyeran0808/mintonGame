package com.example.mintongame;

import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<Team> data;
    TextView textName, textGen, textAge, textGrade;

    public CustomAdapter(ArrayList<Team> data, ListActivity context){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View conertView, ViewGroup parent) {
        Holder holder;

        if(convertView == null){

        }
        return null;
    }
}
