package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class ReferensiActivity extends Activity implements View.OnClickListener {

    ImageView imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referensi);
        imageViewHome = findViewById(R.id.ivHome);

        imageViewHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == imageViewHome){
            menuHome(imageViewHome);
        }
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
