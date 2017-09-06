package com.xiukun.bspatch;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;

import java.io.File;

/**
 * Created by ASUS on 2017/8/18.
 */

public class ApkUtils {

    /**
     * 获取apk路径
     * @param context
     * @return
     */
    public static String getApkPath(Context context){
        Context applicationContext = context.getApplicationContext();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        String apkPath = applicationInfo.sourceDir;
        return  apkPath;

    }

    /**
     * 安装合并patch后的新apk
     * @param context
     * @param path
     */
    public static void installApk(Context context,String path){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.fromFile(new File(path)),
                "application/vnd.android.package-archive");
        context.startActivity(i);
    }
}
