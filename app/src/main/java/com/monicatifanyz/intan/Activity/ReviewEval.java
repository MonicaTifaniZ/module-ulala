package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class ReviewEval extends Activity {
    ImageView imageViewHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_eval);

        imageViewHome = findViewById(R.id.ivHome);

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });

    }

    public void menuUtama(View v){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }



    @Override
    public void onBackPressed() {
        Intent i = new Intent(ReviewEval.this, MainActivity.class);
        startActivity(i);
    }
}
