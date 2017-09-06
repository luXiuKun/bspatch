package com.xiukun.bspatch;

/**
 * Created by ASUS on 2017/8/18.
 */

public class BsPatchUtils {

    static{
        System.loadLibrary("native-lib");
    }

    public static native int bspatch(String oldApk, String newApk, String patch);
}
