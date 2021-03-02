package com.monicatifanyz.intan.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.Model.Eval;
import com.monicatifanyz.intan.R;

public class HasilEvaluasiActivity extends Activity {

    TextView mtvHasilAkhir, mtvNama, mtvAbsen, mtvKelas, mtvKetLulus, mtvKetTidakLulus;
    Button mbtnReview, mbtnKirim, btnAttachment;
    ImageView imageViewKeluar;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;
    TextView tvAttachment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_evaluasi);

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mtvNama = (TextView) findViewById(R.id.textViewNama);
        mtvAbsen = (TextView) findViewById(R.id.textViewAbsen);
        mtvKelas = (TextView) findViewById(R.id.textViewKelas);
        mbtnReview = (Button) findViewById(R.id.btnKoreksi);
        mbtnKirim = (Button) findViewById(R.id.btnKirim);
        imageViewKeluar = (ImageView) findViewById(R.id.ivkeluar);

        tvAttachment = findViewById(R.id.tvAttachment);
        btnAttachment = findViewById(R.id.buttonAttach);

        mtvKetLulus = (TextView) findViewById(R.id.textViewKetLulus);
        mtvKetTidakLulus = (TextView) findViewById(R.id.textViewKetTidak);

        setData();


        mbtnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirimEmail(mbtnKirim);
            }
        });

        btnAttachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });


//        mbtnReview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                menuReview(mbtnReview);
//            }
//        });

        imageViewKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        mbtnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuReview(mbtnReview);
            }
        });


    }

    public void Exit() {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);

    }

    public void setData() {
        String nama = getIntent().getStringExtra("nama");
        String absen = getIntent().getStringExtra("absen");
        String kelas = getIntent().getStringExtra("kelas");
        int skorPilGan = getIntent().getIntExtra("skorAkhir", 0);

        if (skorPilGan >= 70) {
            mtvKetTidakLulus.setVisibility(View.GONE);
            mtvKetLulus.setVisibility(View.VISIBLE);
            String nilai = String.valueOf(skorPilGan);
            mtvNama.setText(nama);
            mtvAbsen.setText(absen);
            mtvKelas.setText(kelas);
            mtvHasilAkhir.setText(nilai);
        } else {
            mtvKetLulus.setVisibility(View.GONE);
            mtvKetTidakLulus.setVisibility(View.VISIBLE);
            String nilais = String.valueOf(skorPilGan);
            mtvNama.setText(nama);
            mtvAbsen.setText(absen);
            mtvKelas.setText(kelas);
            mtvHasilAkhir.setText(nilais);
        }
    }



    public void kirimEmail(View v) {
        try {
            String namanya = getIntent().getStringExtra("nama");
            String absennya = getIntent().getStringExtra("absen");
            String kelasnya = getIntent().getStringExtra("kelas");
            int skorPilGannya = getIntent().getIntExtra("skorAkhir", 0);

            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            if (URI != null) {
                emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
            }
            String mycontent = "Nama Lengkap\t: " + namanya + "\n" + "Nomor Absen\t: " + absennya + "\n" + "Kelas\t\t: " + kelasnya + "\n" + "Skor\t\t: " + skorPilGannya + "\n";
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hasil Evaluasi");
            emailIntent.putExtra(Intent.EXTRA_TEXT, mycontent);
            this.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
            emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mtvNama.setText("");
            mtvAbsen.setText("");
            mtvKelas.setText("");
            mtvHasilAkhir.setText("");
            tvAttachment.setVisibility(View.GONE);


        } catch (Throwable t) {
            Toast.makeText(this, "Request failed try again: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void menuReview(View v){
        Intent rv = new Intent(this, ReviewEval.class);
        startActivity(rv);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            assert URI != null;
            tvAttachment.setText(URI.getLastPathSegment());
            tvAttachment.setVisibility(View.VISIBLE);
        }
    }

    public void openFolder() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
    }

}

    //    public  void menuReview(View v){
//        Intent intent = new Intent(HasilEvaluasiActivity.this, ReviewActivity.class);
//        startActivity(intent);
//    }



