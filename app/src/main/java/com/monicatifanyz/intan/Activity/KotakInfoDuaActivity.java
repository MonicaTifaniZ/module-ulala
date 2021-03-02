package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.monicatifanyz.intan.R;

public class KotakInfoDuaActivity extends Activity {

    TextView textView;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak_info_dua);

        back = findViewById(R.id.ivPrev);
        textView = (TextView) findViewById(R.id.tvText);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev(back);
            }
        });
    }

    public void prev(View view){
        Intent sebelum = new Intent(this, MenuTigaActivity.class);
        startActivity(sebelum);
    }
}

