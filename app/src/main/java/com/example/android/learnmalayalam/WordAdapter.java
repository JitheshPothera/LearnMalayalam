package com.example.android.learnmalayalam;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    // accept the color resource id
    private int mColorResourceID;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     */
    public WordAdapter (Activity context, ArrayList<Word> words, int listItemColor) {

        super(context, 0, words);
        mColorResourceID = listItemColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Word currentWord = getItem(position);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTraslation());

        TextView malayalamTextView = (TextView) listItemView.findViewById(R.id.malayalam_text_view);
        malayalamTextView.setText(currentWord.getMalayalamTraslation());


        ImageView resourceImageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            resourceImageView.setImageResource(currentWord.getImageResourceID());
            // Make sure the view is visible
            resourceImageView.setVisibility(View.VISIBLE);

        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            resourceImageView.setVisibility(View.GONE);
        }

        //Set the background color to the text_container listitem view
        LinearLayout textContainer = (LinearLayout) listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

}
