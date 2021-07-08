package com.damn;

import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomPresentation extends Presentation {

    private Context mContext;


    CustomPresentation(Context outerContext, Display display) {
        super(outerContext, display);
        mContext = outerContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "shitshitshitshitshit", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDisplayChanged() {
        super.onDisplayChanged();
        dismiss();
    }
}