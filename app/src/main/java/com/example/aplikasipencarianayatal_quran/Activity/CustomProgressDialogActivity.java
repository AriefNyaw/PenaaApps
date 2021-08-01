package com.example.aplikasipencarianayatal_quran.Activity;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.aplikasipencarianayatal_quran.R;

public class CustomProgressDialogActivity extends Dialog {
    public CustomProgressDialogActivity(@NonNull Context context) {
        super(context);

        WindowManager.LayoutParams params = getWindow().getAttributes();

        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);
        setTitle(null);
        setCancelable(false);
        setOnCancelListener(null);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_progress_dialog, null);
        setContentView(view);
    }
}
