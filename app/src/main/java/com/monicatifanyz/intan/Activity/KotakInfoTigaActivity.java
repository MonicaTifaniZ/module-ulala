package com.monicatifanyz.intan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.monicatifanyz.intan.R;

public class KotakInfoTigaActivity extends Activity {

    TextView textView;
    ImageView back, ceritakusatu, ceritakudua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak_info_tiga);

        back = findViewById(R.id.ivPrev);
        textView = (TextView) findViewById(R.id.tvText);
        ceritakusatu = (ImageView) findViewById(R.id.kisahku);
        ceritakudua = (ImageView) findViewById(R.id.kisahku2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev(back);
            }
        });
        ceritakusatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceritaKu(ceritakusatu);
            }
        });
        ceritakudua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceritaKu(ceritakudua);
            }
        });


    }

    public void prev(View view){
        Intent sebelum = new Intent(this, MenuTigaActivity.class);
        startActivity(sebelum);
    }

    public void ceritaKu(View view){
        Intent sebelum = new Intent(this, KisahkuDua.class);
        startActivity(sebelum);
    }

}

