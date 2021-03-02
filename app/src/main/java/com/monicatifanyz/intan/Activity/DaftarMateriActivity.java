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

public class DaftarMateriActivity extends Activity implements View.OnClickListener {

    ImageView imageViewPrev, imageViewHome;
    Button btnSatu, btnDua, btnTiga, btnEmpat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_materi);

        imageViewHome = findViewById(R.id.ivHome);
        imageViewPrev = findViewById(R.id.ivPrev);
        btnSatu = (Button) findViewById(R.id.btnMulai1);
        btnDua = (Button) findViewById(R.id.btnMulai2);
        btnTiga = (Button) findViewById(R.id.btnMulai3);
        btnEmpat = (Button)  findViewById(R.id.btnMulai4);

        imageViewHome.setOnClickListener(this);
        imageViewPrev.setOnClickListener(this);
        btnSatu.setOnClickListener(this);
        btnDua.setOnClickListener(this);
        btnTiga.setOnClickListener(this);
        btnEmpat.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == imageViewPrev){
            prev(imageViewPrev);
        } else if(v == imageViewHome){
            menuHome(imageViewHome);
        } else if (v == btnSatu){
            menuSatu(btnSatu);
        } else if (v == btnDua){
            menuDua(btnDua);
        } else if (v == btnTiga){
            menuTiga(btnTiga);
        } else if (v == btnEmpat){
            menuEmpat(btnEmpat);
        }
    }

    public void prev(View view){
        Intent sebelum = new Intent(this, MateriActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void menuSatu(View view){
        Intent menu = new Intent(this, MenuSatuActivity.class);
        startActivity(menu);
    }

    public void menuDua(View view){
        Intent menu = new Intent(this, MenuDuaActivity.class);
        startActivity(menu);
    }
    public void menuTiga(View view){
        Intent menu = new Intent(this, MenuTigaActivity.class);
        startActivity(menu);
    }
    public void menuEmpat(View view){
        Intent menu = new Intent(this, MenuEmpat.class);
        startActivity(menu);
    }
}
