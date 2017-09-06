//
// Created by ASUS on 2017/8/18.
//
#include <jni.h>
#include "include/bspatch.c"
JNIEXPORT jint JNICALL Java_com_xiukun_bspatch_BsPatchUtils_bspatch
        (JNIEnv *env, jclass cls,
         jstring old, jstring new, jstring patch){
    int argc = 4;
    char * argv[argc];
    argv[0] = "bspatch";//随意定义
    argv[1] = (char*) ((*env)->GetStringUTFChars(env, old, 0));
    argv[2] = (char*) ((*env)->GetStringUTFChars(env, new, 0));
    argv[3] = (char*) ((*env)->GetStringUTFChars(env, patch, 0));


    int ret = patchMethod(argc, argv);

    (*env)->ReleaseStringUTFChars(env, old, argv[1]);
    (*env)->ReleaseStringUTFChars(env, new, argv[2]);
    (*env)->ReleaseStringUTFChars(env, patch, argv[3]);
    return ret;
}
