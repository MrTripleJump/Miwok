package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

/**
 * Created by dsuappacademy on 7/14/16.
 */
public class NumbersClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),
                "Open a list of numbers",Toast.LENGTH_SHORT).show();
    }
}
