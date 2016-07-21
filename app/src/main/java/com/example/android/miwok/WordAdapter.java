package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dsuappacademy on 7/18/16.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int backgroundColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColorResourceId){
        super(context, 0, words);
        this.backgroundColorResourceId = backgroundColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent, false);

        }

        //find text container
        View textContainer = listItemView.findViewById(R.id.textContainer);

        //find the color the resource Id maps to
        int color = ContextCompat.getColor(getContext(), backgroundColorResourceId);

        //set background color
        textContainer.setBackgroundColor(color);

        // Get the Word object located at this position in the list
        Word currentWordAdapter = getItem(position);

        TextView miwokTextView = (TextView) listItemView. findViewById(R.id.lutti);
        miwokTextView.setText(currentWordAdapter.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView. findViewById(R.id.one);
        defaultTextView.setText(currentWordAdapter.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView. findViewById(R.id.launcher);

        if(currentWordAdapter.hasImage()){
            imageView.setImageResource(currentWordAdapter.ImageResourceId());

        }

        else{
            imageView.setVisibility(View.GONE);
        }


        return listItemView;
    }
}
