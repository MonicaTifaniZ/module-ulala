package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class IndikatorActivity extends Activity implements View.OnClickListener{

    ImageView imageViewPrev, imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indikator);

        imageViewHome = findViewById(R.id.ivHome);
        imageViewPrev = findViewById(R.id.ivPrev);

        imageViewHome.setOnClickListener(this);
        imageViewPrev.setOnClickListener(this);

    }

    public void prev(View view){
        Intent sebelum = new Intent(this, KompetensiActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    @Override
    public void onClick(View v) {
        if (v == imageViewPrev){
            prev(imageViewPrev);
        } else if(v == imageViewHome){
            menuHome(imageViewHome);
        }

    }
}
