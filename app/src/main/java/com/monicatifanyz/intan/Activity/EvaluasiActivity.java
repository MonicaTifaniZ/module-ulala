package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.monicatifanyz.intan.Model.Eval;
import com.monicatifanyz.intan.R;

public class EvaluasiActivity extends Activity {

    //membuat variabel baru sesuai tipe
    TextView mtvSkor, mtvSoal;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3,  mrbPilihanJawaban4;
    ImageView mbtnSubmit;
    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x;   //menunjukkan konten sekarang
    String jawaban; //menampung jawaban benar
    String namanya = "";
    String kelasnya = "";
    String absennya = "";

    Eval soalPG = new Eval();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluasi);

//        Toast.makeText(this, String.valueOf(savedInstanceState) , Toast.LENGTH_SHORT).show();
        if (savedInstanceState == null) {
            Bundle b = getIntent().getExtras();
            namanya = b.getString("nama");
            kelasnya = b.getString("kelas");
            absennya = b.getString("absen");
//            Toast.makeText(this, namanya, + Toast.LENGTH_SHORT).show();
        }
        //menyambungkan antara variabel KuisPilihanGanda.java dengan id activity_kuis_pilihan_ganda
        mtvSkor = (TextView) findViewById(R.id.tvSkor);
        mtvSoal = (TextView) findViewById(R.id.tvSoal);
        mrgPilihanJawaban = (RadioGroup) findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = (RadioButton) findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = (RadioButton) findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = (RadioButton) findViewById(R.id.rbPilihanJawaban3);
        mrbPilihanJawaban4 = (RadioButton) findViewById(R.id.rbPilihanJawaban4);
        mbtnSubmit =  findViewById(R.id.btnSubmit);


        setKonten();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekJawaban();
            }
        });


    }

    public void  setKonten(){
        mrgPilihanJawaban.clearCheck();
        arr = soalPG.pertanyaan.length;
        if(x >= arr){ //jika nilai x melebihi nilai arr(panjang array) maka akan pindah activity (kuis selesai)

            Intent i = new Intent(EvaluasiActivity.this, HasilEvaluasiActivity.class);

            i.putExtra("nama", namanya);
            i.putExtra("absen", absennya);
            i.putExtra("kelas", kelasnya);
            i.putExtra("skorAkhir",skor);
            startActivity(i);

        }else{
            //setting text dengan mengambil text dari method getter di kelas SoalPilihanGanda
            mtvSoal.setText(soalPG.getPertanyaan(x));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(x));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(x));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(x));
            mrbPilihanJawaban4.setText(soalPG.getPilihanJawaban4(x));
            jawaban = soalPG.getJawabanBenar(x);

        }
        x++;
    }

    public void cekJawaban(){
        if(mrbPilihanJawaban1.isChecked()){ //jika radio button 1 diklik
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if(mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 5;
                setKonten(); //update next konten
            }else{
                setKonten();
            }
        }else if(mrbPilihanJawaban2.isChecked()){
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 5;
                setKonten(); //update next konten
            }else{
                setKonten();
            }
        }else if(mrbPilihanJawaban3.isChecked()) {
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if (mrbPilihanJawaban3.getText().toString().equals(jawaban)) {
                skor = skor + 5;
                setKonten(); //update next konten
            } else {
                setKonten();
            }
        }
        else if(mrbPilihanJawaban4.isChecked()) {
            //jika text yang tertulis di radio button tsb = nilai dari var jawaban
            if (mrbPilihanJawaban4.getText().toString().equals(jawaban)) {
                skor = skor + 5;
                setKonten(); //update next konten
            } else {
                setKonten();
            }

        }else{
            Toast.makeText(this, "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
        }


    }



    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
    }
}
