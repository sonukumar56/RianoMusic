package com.rianoMusicskb.rianomusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class overlayScreen extends AppCompatActivity {
    SeekBar my_seekBar;
    RatingBar my_rating_bar;
    TextView sb_txt;
    Button pause_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overlay_screen);
        my_seekBar=(SeekBar) findViewById(R.id.my_seekbar);
        sb_txt=(TextView)findViewById(R.id.sb_txt);
        my_rating_bar=(RatingBar)findViewById(R.id.my_rating_bar);
        pause_btn=(Button)findViewById(R.id.pause_btn);
        my_seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int new_progress_value, boolean fromUser) {
                progress_value=new_progress_value;
                sb_txt.setText(progress_value+"");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void pause_button(View view) {
        float f=my_rating_bar.getRating();
        Toast.makeText(overlayScreen.this, ""+f, Toast.LENGTH_SHORT).show();

    }
}