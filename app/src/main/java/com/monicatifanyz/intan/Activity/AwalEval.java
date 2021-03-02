package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class AwalEval extends Activity {

    ImageView marmot, lanjut, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal_eval);

        marmot = findViewById(R.id.ivMarmot);
        lanjut = findViewById(R.id.btnLanjut);
        kembali = findViewById(R.id.btnSebelum);

        marmot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceritaMarmot(marmot);
            }
        });
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanjutMenu(lanjut);
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembaliMenu(kembali);
            }
        });


    }

    public void ceritaMarmot(View view){
        Intent menu = new Intent(this, CeritaMarmot.class);
        startActivity(menu);
    }

    public void lanjutMenu(View view){
        Intent menu = new Intent(this, PetunjukPGActivity.class);
        startActivity(menu);
    }
    public void kembaliMenu(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
