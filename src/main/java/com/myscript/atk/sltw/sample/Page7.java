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

public class Page7 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page7);

        overridePendingTransition(R.anim.fadein1, R.anim.fadeout);

        TextView txt = (TextView) findViewById(R.id.textView10);
        final TextView txt1 = (TextView) findViewById(R.id.textView5);
        final Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);

        txt.startAnimation(fadein);
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
