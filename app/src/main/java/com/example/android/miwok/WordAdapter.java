package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Word currentWord = getItem(position);
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        // Miwok translation
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        // default translation
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());
        // Image if not phrases
        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentWord.getImageResourceId());
        if (!currentWord.hasImage()) {
            imageView.setVisibility(View.GONE);
        } else
            imageView.setVisibility(View.VISIBLE);

        View textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundResource(mColorResourceId);

//        listItemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), currentWord.getAudioResourceId());
//                mediaPlayer.start();
//                mediaPlayer = null;
////                mediaPlayer.release();
//            }
//        });

        return listItemView;
    }
}
