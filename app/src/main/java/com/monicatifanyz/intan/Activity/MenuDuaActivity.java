package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class MenuDuaActivity extends Activity {
    Button buttonKirim,  btnAttachment;
    TextInputEditText etNamaLengkap, etNoAbsen, etJawab;
    ImageView  imageViewKotak, imageViewHome, imageViewMateri, ivAudio;
    Uri URI = null;
    private static final int PICK_FROM_GALLERY = 101;
    TextView tvAttachment;

    MediaPlayer music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dua);

        buttonKirim = (Button) findViewById(R.id.btnKirim);
        etNamaLengkap = (TextInputEditText) findViewById(R.id.editTextNama);
        etNoAbsen = (TextInputEditText) findViewById(R.id.editTextAbsen);
        etJawab = (TextInputEditText) findViewById(R.id.editTextJawab);

        imageViewHome = (ImageView) findViewById(R.id.ivHome);
        imageViewKotak = findViewById(R.id.ivKotakInfo);
        imageViewMateri = (ImageView) findViewById(R.id.ivMateri);


        tvAttachment = findViewById(R.id.tvAttachment);
        btnAttachment = findViewById(R.id.buttonAttach);


        music = MediaPlayer.create(this, R.raw.audionya);

        buttonKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToEmail();
            }
        });
        imageViewKotak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuKotak(imageViewKotak);
            }
        });
        imageViewMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materi(imageViewMateri);
            }
        });
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuHome(imageViewHome);
            }
        });

        btnAttachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });

    }

    public void menuKotak(View view){
        Intent menu = new Intent(this, KotakInfoDuaActivity.class);
        startActivity(menu);
    }


    // Plaing the music
    public void musicplay(View v)
    {
        music.start();
    }

    // Pausing the music
    public void musicpause(View v)
    {
        music.pause();
    }

    // Stoping the music
    public void musicstop(View v)
    {
        music.stop();
        music
                = MediaPlayer.create(
                this, R.raw.audionya);
    }

    public void materi(View view){
        Intent sebelum = new Intent(this, MateriActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void openFolder() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);
    }

    public void sendToEmail() {
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
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Menceritakan Cerita Fantasi");
                emailIntent.putExtra(Intent.EXTRA_TEXT, mycontent);
                this.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
                emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                etNamaLengkap.setText("");
                etNoAbsen.setText("");
                etJawab.setText("");
                tvAttachment.setVisibility(View.GONE);


            }

        } catch (Throwable t) {
            Toast.makeText(this, "Request failed try again: "+ t.toString(), Toast.LENGTH_LONG).show();
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



    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, DaftarMateriActivity.class);
        startActivity(i);
    }
}
