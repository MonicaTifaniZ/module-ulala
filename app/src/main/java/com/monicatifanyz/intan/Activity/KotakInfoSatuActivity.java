package com.monicatifanyz.intan.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.monicatifanyz.intan.R;

public class KotakInfoSatuActivity extends Activity {

    TextView textView;
    ImageView back, ceritaTiga;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak_info_satu);

        back = findViewById(R.id.ivPrev);


        textView = (TextView) findViewById(R.id.tvText);
        ceritaTiga = (ImageView) findViewById(R.id.kisahku);

        ceritaTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceritaTigaa(ceritaTiga);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev(back);
            }
        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            textView.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
//        }
    }

    public void prev(View view){
        Intent sebelum = new Intent(this, MenuSatuActivity.class);
        startActivity(sebelum);
    }

    public void ceritaTigaa(View view){
        Intent menu = new Intent(this, CeritaKisahku.class);
        startActivity(menu);
    }
}
