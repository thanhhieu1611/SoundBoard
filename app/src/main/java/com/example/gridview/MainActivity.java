package com.example.gridview;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private ListView myList;
    MediaPlayer mp0, mp1, mp2, mp3, mp4, mp5, mp6, mp7, mp8;
    String[] sounds = {"Bass", "Bass Booted", "Boom", "Brand New", "DJ", "Laugh", "MSuc", "Mysterious", "Police"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        Resources resources = context.getResources();

        mp0 = mp1 = mp2 = mp3 = mp4 = mp5 = mp6 = mp7 = mp8 = null;

        TypedArray soundsArray = resources.obtainTypedArray(R.array.techItems);

        setListAdapter(new ImageAndTextAdapter(context, R.layout.sound_layout, sounds, soundsArray));

        //Click event for List View
        myList = getListView();
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mp0 = PlayMusic(mp0, position);
                        break;
                    case 1:
                        mp1 = PlayMusic(mp1, position);
                        break;
                    case 2:
                        mp2 = PlayMusic(mp2, position);
                        break;
                    case 3:
                        mp3 = PlayMusic(mp3, position);
                        break;
                    case 4:
                        mp4 = PlayMusic(mp4, position);
                        break;
                    case 5:
                        mp5 = PlayMusic(mp5, position);
                        break;
                    case 6:
                        mp6 = PlayMusic(mp6, position);
                        break;
                    case 7:
                        mp7 = PlayMusic(mp7, position);
                        break;
                    case 8:
                        mp8 = PlayMusic(mp8, position);
                        break;

                }
            }
        });
    }

    private MediaPlayer PlayMusic(MediaPlayer mp, int position){
        if(mp == null){
            //Toast.makeText(MainActivity.this, this.sounds[position], Toast.LENGTH_LONG).show();
            switch(position){
                case 0:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.bass);
                    break;
                case 1:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.bassbooted);
                    break;
                case 2:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.boom);
                    break;
                case 3:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.brandnew);
                    break;
                case 4:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.dj);
                    break;
                case 5:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.laugh);
                    break;
                case 6:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.msuc);
                    break;
                case 7:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.mysterious);
                    break;
                case 8:
                    mp = MediaPlayer.create(MainActivity.this, R.raw.police);
                    break;
            }
            mp.start();

        }else{
            mp.stop();
            mp.release();
            mp = null;
        }
        return mp;
    }
}