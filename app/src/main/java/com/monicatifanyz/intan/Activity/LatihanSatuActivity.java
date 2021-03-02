package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.monicatifanyz.intan.Model.SoalPilihanGanda;
import com.monicatifanyz.intan.R;

public class LatihanSatuActivity extends Activity {

    TextView tvSkor, tvSoal;
    Button buttonBenar, buttonSalah;

    int arr; //untuk menampung nilai panjang array
    int x;   //menunjukkan konten sekarang

    private String mAnswer;
    private int mScore = 0;

    String jawaban; //menampung jawaban benar
    String namanya = "";
    String absennya = "";

    SoalPilihanGanda soalPG = new SoalPilihanGanda();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_satu);

        if (savedInstanceState == null) {
            Bundle b = getIntent().getExtras();
            namanya = b.getString("nama");
            absennya = b.getString("absen");
//            Toast.makeText(this, namanya, + Toast.LENGTH_SHORT).show();
        }
        tvSoal = (TextView) findViewById(R.id.textViewSoal);
        buttonBenar =(Button) findViewById(R.id.btn_benar);
        buttonSalah = ( Button) findViewById(R.id.btn_salah);




        updateQuestion();

        buttonBenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonBenar.getText()==mAnswer){
                    mScore += 10;
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        buttonSalah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonSalah.getText()==mAnswer){
                    mScore += 10;
                    updateQuestion();
                }  else {
                    updateQuestion();
                }
            }
        });
    }


    public void updateQuestion(){
        arr = soalPG.mQuestions.length;
        if (x>= arr){
            Intent i = new Intent(LatihanSatuActivity.this, HasilLatihanActivity.class);

            i.putExtra("nama", namanya);
            i.putExtra("absen", absennya);
            i.putExtra("skorAkhir",mScore);
            startActivity(i);
        } else {
            tvSoal.setText(soalPG.getQuestion(x));
            buttonBenar.setText(soalPG.getChoice1(x));
            buttonSalah.setText(soalPG.getChoice2(x));
            mAnswer = soalPG.getCorrectAnswer(x);
        }
        x++;

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Selesaikan kuis", Toast.LENGTH_SHORT).show();
    }


}
