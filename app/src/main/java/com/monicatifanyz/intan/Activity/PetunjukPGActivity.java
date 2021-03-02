package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class PetunjukPGActivity extends Activity {

    Button buttonSiap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_p_g);

        buttonSiap = findViewById(R.id.btnGo);

        buttonSiap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuIsiData(buttonSiap);
            }
        });

    }


    public  void menuIsiData(View v){
        Intent isiData = new Intent(this, DataEvaluasiActivity.class);
        startActivity(isiData);
    }

}
