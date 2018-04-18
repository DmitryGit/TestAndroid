package com.nca.presentation.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import java.io.File;

import javax.inject.Inject;

public class ImageChooser {

    private static final int CAMERA_REQUEST_CODE = 123;

    public static void startCamera(Activity activity) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // проверяет наличие такого Intent у вас в телефоне
        if (intent.resolveActivity(activity.getPackageManager()) != null) {

            File photo = getCameraFile(activity);

            Uri uri = FileProvider.getUriForFile(activity, "com.nca.presentation.utils.MyFileProvider", photo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            activity.startActivityForResult(intent, CAMERA_REQUEST_CODE);

        }
    }

    public static void startGalery(Activity activity) {

    }

    public static File getCameraFile(Activity activity) {

        File root = activity.getExternalFilesDir(null);
        if (root == null) {
            root = activity.getFilesDir();
        }

        File myDir = new File(root.getAbsoluteFile() + "/myDir");

        if (!myDir.exists()) {
            myDir.mkdir();
        }
        return new File(myDir.getAbsoluteFile() + "/" + System.currentTimeMillis() + ".jpg");
    }

    public static File getImageFromResult(Activity activity, int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CAMERA_REQUEST_CODE: {
                File file = getCameraFile(activity);
                if(file.exists()) {
                    return file;
                } else {
                    return null;
                }
            }
            // этот case уже из галереи если нужно
           // case:
        }
        return null;
    }

}
