package com.myscript.atk.sltw.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by swaglord42 on 09/02/17.
 */

public class Page6 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page5);

        overridePendingTransition(R.anim.fadein1, R.anim.fadeout);

        TextView txt = (TextView) findViewById(R.id.textView6);
        final TextView txt1 = (TextView) findViewById(R.id.textView7);
        final TextView txt2 = (TextView) findViewById(R.id.textView8);
        final TextView txt3 = (TextView) findViewById(R.id.textView9);
        final Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);

        txt.startAnimation(fadein);
        txt1.setVisibility(View.INVISIBLE);
        txt2.setVisibility(View.INVISIBLE);
        txt3.setVisibility(View.INVISIBLE);

        txt1.postDelayed(new Runnable() {
            @Override
            public void run() {
                txt1.setVisibility(View.VISIBLE);
                txt1.startAnimation(fadein);
            }
        }, 3000);
        txt2.postDelayed(new Runnable() {
            @Override
            public void run() {
                txt2.setVisibility(View.VISIBLE);
                txt2.startAnimation(fadein);
            }
        }, 6000);
        txt3.postDelayed(new Runnable() {
            @Override
            public void run() {
                txt3.setVisibility(View.VISIBLE);
                txt3.startAnimation(fadein);
            }
        }, 9000);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Page6.this, Page7.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 15000);


        FullScreencall();
    }

    public void FullScreencall() {
        if(Build.VERSION.SDK_INT < 19){
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            //for higher api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

}
