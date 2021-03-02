package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class PetunjukActivity extends Activity implements View.OnClickListener {

    ImageView imageViewHome, imageViewNext, imageViewPrev;
    ViewFlipper viewFlipperr;
    int i = 0;
    private int[] petunjukArray = {R.drawable.petunjuk1, R.drawable.petunjuk2, R.drawable.petunjuk3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk);

        imageViewHome = (ImageView) findViewById(R.id.ivHome);
        imageViewNext = (ImageView) findViewById(R.id.ivNext);
        imageViewPrev = (ImageView) findViewById(R.id.ivPrev);
        viewFlipperr = findViewById(R.id.viewFlipper);
//        imageViewKonten = (ImageView) findViewById(R.id.imageView2);

//        if (i == 0){
//            imageViewPrev.setVisibility(View.GONE);
//        } if (i == 2){
//            imageViewNext.setVisibility(View.GONE);
//        }

        imageViewPrev.setVisibility(View.GONE);
        imageViewNext.setOnClickListener(this);
        imageViewPrev.setOnClickListener(this);
        imageViewHome.setOnClickListener(this);


//        imageViewNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageViewKonten.setImageResource(petunjukArray[i]);
//                i++;
//                if(i==0){
//                    imageViewPrev.setVisibility(View.GONE);
//                } else {
//                    imageViewPrev.setVisibility(View.VISIBLE); }
//                if (i==2){
//                    imageViewNext.setVisibility(View.GONE);
//                } else{
//                    imageViewNext.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//
//        imageViewPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageViewKonten.setImageResource(petunjukArray[i]);
//                --i;
//                if(i==0){
//                    imageViewPrev.setVisibility(View.GONE);
//                } else{
//                    imageViewPrev.setVisibility(View.VISIBLE);}
//                if (i==2){
//                    imageViewNext.setVisibility(View.GONE);
//                } else{
//                    imageViewNext.setVisibility(View.VISIBLE);
//                }
//            }
//        });


    }

    public void menuUtama(View v) {
        Intent menuUtama = new Intent(this, MainActivity.class);
        startActivity(menuUtama);
    }

    @Override
    public void onClick(View v) {
        if (v == imageViewNext) {
            if (viewFlipperr.getDisplayedChild()==0){
                imageViewPrev.setVisibility(View.GONE);
                imageViewNext.setVisibility(View.VISIBLE);
                viewFlipperr.showNext();
                imageViewPrev.setVisibility(View.VISIBLE);
            } else if (viewFlipperr.getDisplayedChild()==1){
                imageViewNext.setVisibility(View.VISIBLE);
                viewFlipperr.showNext();
                imageViewPrev.setVisibility(View.VISIBLE);
                viewFlipperr.showNext();
                viewFlipperr.showPrevious();
                imageViewNext.setVisibility(View.GONE);
            } else if (viewFlipperr.getDisplayedChild()==2){
                imageViewNext.setVisibility(View.GONE);
                viewFlipperr.showPrevious();
                imageViewNext.setVisibility(View.VISIBLE);
                viewFlipperr.showNext();
                imageViewPrev.setVisibility(View.VISIBLE);
            }
        } else if (v == imageViewPrev) {
            if (viewFlipperr.getDisplayedChild()==0){
                imageViewPrev.setVisibility(View.GONE);
                imageViewNext.setVisibility(View.VISIBLE);
                viewFlipperr.showNext();
                imageViewPrev.setVisibility(View.VISIBLE);
                menuUtama(imageViewHome);
            } else if (viewFlipperr.getDisplayedChild()==1){
                imageViewNext.setVisibility(View.VISIBLE);
                viewFlipperr.showNext();
                imageViewPrev.setVisibility(View.VISIBLE);
                viewFlipperr.showPrevious();
                imageViewPrev.setVisibility(View.GONE);
                imageViewNext.setVisibility(View.VISIBLE);
                viewFlipperr.showPrevious();
            } else if (viewFlipperr.getDisplayedChild()==2){
                imageViewNext.setVisibility(View.GONE);
                viewFlipperr.showPrevious();
                imageViewPrev.setVisibility(View.VISIBLE);
                viewFlipperr.showPrevious();
                imageViewNext.setVisibility(View.VISIBLE);
                viewFlipperr.showNext();
            }

        } else if (v == imageViewHome) {
            menuUtama(imageViewHome);
        }
    }
}

