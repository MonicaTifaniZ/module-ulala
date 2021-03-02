package com.monicatifanyz.intan.Activity;

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
import com.monicatifanyz.intan.R;

public class HasilLatihanActivity extends Activity {

    TextView mtvHasilAkhir, mtvNama, mtvAbsen;
    Button mbtnReview, mbtnKirim, btnAttachment;
    ImageView imageViewHome, imageViewKeluar;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;
    TextView tvAttachment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_latihan);

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mtvNama = (TextView) findViewById(R.id.textViewNama);
        mtvAbsen = (TextView) findViewById(R.id.textViewAbsen);
        mbtnReview = (Button) findViewById(R.id.btnKoreksi);
        mbtnKirim = (Button) findViewById(R.id.btnKirim);
        imageViewHome = (ImageView) findViewById(R.id.ivHome);
        imageViewKeluar = (ImageView) findViewById(R.id.ivkeluar);

        tvAttachment = findViewById(R.id.tvAttachment);
        btnAttachment = findViewById(R.id.buttonAttach);


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

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuUtama(imageViewHome);
            }
        });

        mbtnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuReview(mbtnReview);
            }
        });

        imageViewKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

    }

    public void menuReview(View v){
        Intent rv = new Intent(this, ReviewLatihanSatu.class);
        startActivity(rv);
    }

    public void Exit() {
        Intent menu = new Intent(this, MenuSatuActivity.class);
        startActivity(menu);

    }
    public void menuUtama(View v) {
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void setData() {

        String namanya = getIntent().getStringExtra("nama");
        String absennya = getIntent().getStringExtra("absen");

        int skorPilGan = getIntent().getIntExtra("skorAkhir", 0);
        String nilai = String.valueOf(skorPilGan);

        mtvNama.setText(namanya);
        mtvAbsen.setText(absennya);
        mtvHasilAkhir.setText(nilai);

    }

    public void kirimEmail(View v) {
        try {
            String namanya = getIntent().getStringExtra("nama");
            String absennya = getIntent().getStringExtra("absen");
            int skorPilGannya = getIntent().getIntExtra("skorAkhir", 0);

            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            if (URI != null) {
                emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
            }
            String mycontent = "Nama Lengkap\t: " + namanya + "\n" + "Nomor Absen\t: " + absennya + "\n"  + "Skor\t\t: " + skorPilGannya + "\n";
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hasil Latihan 1");
            emailIntent.putExtra(Intent.EXTRA_TEXT, mycontent);
            this.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
            emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            mtvNama.setText("");
            mtvAbsen.setText("");
            mtvHasilAkhir.setText("");
            tvAttachment.setVisibility(View.GONE);

        } catch (Throwable t) {
            Toast.makeText(this, "Request failed try again: " + t.toString(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
