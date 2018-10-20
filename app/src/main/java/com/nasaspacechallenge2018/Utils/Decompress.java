package com.nasaspacechallenge2018.Utils;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Decompress {
    private static final int BUFFER_SIZE = 1024 * 10;
    private static final String TAG = "Decompress";

    public static void unzipDatabase(Context context, String fileName) {

        String dbPath = context.getFilesDir().getPath();
        dbPath = dbPath.substring(0, dbPath.lastIndexOf("/")) + "/databases/";

        final String zipFile = fileName + ".zip";
        final String dbFile = fileName + ".sqlite";

        Log.d(TAG, "dbPath: " + dbPath);

        File usersFile = new File(dbPath + dbFile);

        Log.d(TAG, "usersFile: " + usersFile);

        //if (!usersFile.exists())
        unzipFromAssets(context, zipFile, dbPath);
    }

    // TODO in future check if DB corrupted
    static void deleteDatabase(Context context, String fileName) {

        String dbPath = context.getFilesDir().getPath();
        dbPath = dbPath.substring(0, dbPath.lastIndexOf("/")) + "/databases/";

        final String dbFile = fileName + ".sqlite";

        File usersFile = new File(dbPath + dbFile);

        if (usersFile.delete()) {
            Log.d(TAG, "Database: " + dbFile + " deleted");
        }
    }

    private static void unzipFromAssets(Context context, String zipFile, String destination) {
        try {
            if (destination == null || destination.length() == 0)
                destination = context.getFilesDir().getAbsolutePath();
            InputStream stream = context.getAssets().open(zipFile);
            unzip(stream, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void unzip(InputStream stream, String destination) {
        dirChecker(destination, "");
        byte[] buffer = new byte[BUFFER_SIZE];
        try {
            ZipInputStream zin = new ZipInputStream(stream);
            ZipEntry ze;

            while ((ze = zin.getNextEntry()) != null) {
                Log.v(TAG, "Unzipping " + ze.getName());

                if (ze.isDirectory()) {
                    dirChecker(destination, ze.getName());
                } else {
                    File f = new File(destination + ze.getName());
                    //if (!f.exists()) {
                    FileOutputStream fout = new FileOutputStream(
                            destination + ze.getName());
                    int count;
                    while ((count = zin.read(buffer)) != -1) {
                        fout.write(buffer, 0, count);
                    }
                    zin.closeEntry();
                    fout.close();
//					} else {
//						Log.d(TAG, "File exists!");
//					}
                }

            }
            zin.close();
        } catch (Exception e) {
            Log.e(TAG, "unzip", e);
        }

    }

    private static void dirChecker(String destination, String dir) {
        File f = new File(destination + dir);

        if (!f.isDirectory()) {
            boolean success = f.mkdirs();
            if (!success) {
                Log.w(TAG, "Failed to create folder " + f.getName());
            }
        }
    }
}
