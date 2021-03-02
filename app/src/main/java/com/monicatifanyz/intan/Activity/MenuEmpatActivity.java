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

import com.google.android.material.textfield.TextInputEditText;
import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class MenuEmpatActivity extends Activity {

    ImageView imageViewKotak, ceritaSatu, ceritaDua, ceritaTiga;
    Button btnSend, btnAttachment, btnSend2, btnAttachment2;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;
    TextView tvAttachment,tvAttachment2;
    ImageView  imageViewHome, imageViewMateri;
    TextInputEditText etNamaLengkap, etNoAbsen, etJawab, etNamaLengkap2, etNoAbsen2, etJawab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_empat);


        tvAttachment = findViewById(R.id.tvAttachment);
        tvAttachment2 = findViewById(R.id.tvAttachment2);

        imageViewKotak = findViewById(R.id.ivKotakInfo);
        ceritaSatu = findViewById(R.id.ivCeritaAlien);
        ceritaDua = findViewById(R.id.ivCeritaMona);

        imageViewHome = (ImageView) findViewById(R.id.ivHome);
        imageViewMateri = (ImageView) findViewById(R.id.ivMateri);

        btnSend = findViewById(R.id.buttonKirim);
        btnAttachment = findViewById(R.id.buttonAttach);

        btnSend2 = findViewById(R.id.buttonKirim2);
        btnAttachment2 = findViewById(R.id.buttonAttach2);


        etNamaLengkap = (TextInputEditText) findViewById(R.id.editTextNama1);
        etNoAbsen = (TextInputEditText) findViewById(R.id.editTextAbsen1);
        etJawab = (TextInputEditText) findViewById(R.id.editTextJawab1);

        etNamaLengkap2 = (TextInputEditText) findViewById(R.id.editTextNama2);
        etNoAbsen2 = (TextInputEditText) findViewById(R.id.editTextAbsen2);
        etJawab2 = (TextInputEditText) findViewById(R.id.editTextJawab2);

        imageViewKotak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuKotak(imageViewKotak);
            }
        });

        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuHome(imageViewHome);
            }
        });
        imageViewMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materi(imageViewMateri);
            }
        });
        btnAttachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmailSatu();
            }
        });

        btnAttachment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });
        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmailDua();
            }
        });


        ceritaSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceritaSatuu(ceritaSatu);
            }
        });
        ceritaDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ceritaDuaa(ceritaDua);
            }
        });
    }

    public void menuKotak(View view){
        Intent menu = new Intent(this, KotakInfoTigaActivity.class);
        startActivity(menu);
    }
    public void ceritaSatuu(View view){
        Intent menu = new Intent(this, CeritaAlien.class);
        startActivity(menu);
    }
    public void ceritaDuaa(View view){
        Intent menu = new Intent(this, CeritaMona .class);
        startActivity(menu);
    }

    public void materi(View view){
        Intent sebelum = new Intent(this, MateriActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();
            assert URI != null;
            tvAttachment.setText(URI.getLastPathSegment());
            tvAttachment.setVisibility(View.VISIBLE);
            tvAttachment2.setText(URI.getLastPathSegment());
            tvAttachment2.setVisibility(View.VISIBLE);

        }
    }


    public void sendEmailSatu() {
        try {

            String nama = etNamaLengkap.getText().toString();
            String absen = etNoAbsen.getText().toString();
            String jawab = etJawab.getText().toString();

            if (etNamaLengkap.getText().toString().isEmpty() || etNoAbsen.getText().toString().isEmpty() || etJawab.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            } else {
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                if (URI != null) {
                    emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
                }
                String mycontent = "Nama Lengkap\t:\t" + nama + "\n" + "Nomor Absen\t\t\t:" + absen + "\n" + "Jawaban\t:\n " + jawab + "\n";
                emailIntent.putExtra(Intent.EXTRA_TEXT, mycontent);
                this.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                etNamaLengkap.setText("");
                etNoAbsen.setText("");
                etJawab.setText("");

            }

        } catch (Throwable t) {
            Toast.makeText(this, "Request failed try again: "+ t.toString(), Toast.LENGTH_LONG).show();
        }

    }

    public void sendEmailDua() {
        try {

            String nama = etNamaLengkap2.getText().toString();
            String absen = etNoAbsen2.getText().toString();
            String jawab = etJawab2.getText().toString();

            if (etNamaLengkap2.getText().toString().isEmpty() || etNoAbsen2.getText().toString().isEmpty() || etJawab2.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(),
                        "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            } else {
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                if (URI != null) {
                    emailIntent.putExtra(Intent.EXTRA_STREAM, URI);
                }
                String mycontent = "Nama Lengkap\t:\t" + nama + "\n" + "Nomor Absen\t\t\t:" + absen + "\n" + "Jawaban\t:\n " + jawab + "\n";
                emailIntent.putExtra(Intent.EXTRA_TEXT, mycontent);

                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                etNamaLengkap2.setText("");
                etNoAbsen2.setText("");
                etJawab2.setText("");

            }

        } catch (Throwable t) {
            Toast.makeText(this, "Request failed try again: "+ t.toString(), Toast.LENGTH_LONG).show();
        }

    }


    public void openFolder() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, DaftarMateriActivity.class);
        startActivity(i);
    }
}



