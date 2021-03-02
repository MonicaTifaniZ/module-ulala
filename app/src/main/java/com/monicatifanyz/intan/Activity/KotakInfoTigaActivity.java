package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.monicatifanyz.intan.R;

public class KotakInfoTigaActivity extends AppCompatActivity {

    TextView textView;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak_info_tiga);

        back = findViewById(R.id.ivPrev);


        textView = (TextView) findViewById(R.id.tvText);

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
        Intent sebelum = new Intent(this, MenuEmpat.class);
        startActivity(sebelum);
    }

}
