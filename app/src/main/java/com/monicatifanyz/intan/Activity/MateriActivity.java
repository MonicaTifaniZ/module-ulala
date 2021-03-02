package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class MateriActivity extends Activity implements View.OnClickListener {

    ImageView imageViewNext, imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        imageViewHome = findViewById(R.id.ivHome);
        imageViewNext = findViewById(R.id.ivNext);

        imageViewHome.setOnClickListener(this);
        imageViewNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == imageViewNext){
            next(imageViewNext);
        } else if(v == imageViewHome){
            menuHome(imageViewHome);
        }
    }

    public void next(View view){
        Intent sebelum = new Intent(this, DaftarMateriActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
