package com.xiukun.bspatch;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private String apkPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apkPath = ApkUtils.getApkPath(this);
        findViewById(R.id.btn_patch).setOnClickListener(this);
    }





    @Override
    public void onClick(View view) {
        File destApk = new File(Environment.getExternalStorageDirectory(), "dest.apk");
        File patch = new File(Environment.getExternalStorageDirectory(), "PATCH.patch");
        BsPatchUtils.bspatch(apkPath,destApk.getAbsolutePath(),patch.getAbsolutePath());

        if (destApk.exists()){
            ApkUtils.installApk(MainActivity.this,destApk.getAbsolutePath());
        }else{
            Toast.makeText(MainActivity.this, "apk文件不存在", Toast.LENGTH_SHORT).show();
        }
    }
}
