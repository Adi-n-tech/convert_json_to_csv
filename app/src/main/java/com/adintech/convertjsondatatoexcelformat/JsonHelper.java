package com.adintech.convertjsondatatoexcelformat;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonHelper {

    /**
     * get metioned json file data in single string variable and return that string
     *
     * @param fileName json file name
     * @return json file data into single variable
     */
    public static String loadJSONFromAsset(Context context, String fileName) {
        String jsonString = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }
}
