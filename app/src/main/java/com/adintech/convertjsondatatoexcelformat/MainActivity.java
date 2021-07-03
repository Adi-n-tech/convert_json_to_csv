package com.adintech.convertjsondatatoexcelformat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //variables
    private ArrayList<DistanceList> mDistanceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------
        initialize();
    }

    private void initialize() {

        //fetch json data from assets
        String mJsonString = JsonHelper.loadJSONFromAsset(this, "doGetDistanceList");
        DistanceResponse mDistanceResponse = new Gson().fromJson(mJsonString, DistanceResponse.class);
        mDistanceList = mDistanceResponse.getDistanceList();
    }

    public void export(View view) {
        //generate data
        StringBuilder mData = new StringBuilder();
        mData.append("Date,Distance,Vehicle No.");
        for (int i = 0; i < mDistanceList.size(); i++) {
            mData.append("\n" + mDistanceList.get(i).getDate() + "," + mDistanceList.get(i).getKm() + "," + mDistanceList.get(i).getVehicleNo());
        }

        try {
            //saving the file into device
            FileOutputStream out = openFileOutput("DistanceReport.csv", Context.MODE_PRIVATE);
            out.write((mData.toString()).getBytes());
            out.close();

            //exporting .csv file
            Context mContext = getApplicationContext();
            File mFileLocation = new File(getFilesDir(), "DistanceReport.csv");
            Uri mPath = FileProvider.getUriForFile(mContext, "com.example.exportcsv.fileprovider", mFileLocation);
            Intent mFileIntent = new Intent(Intent.ACTION_SEND);
            mFileIntent.setType("text/csv");
            mFileIntent.putExtra(Intent.EXTRA_SUBJECT, "DistanceReport");
            mFileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            mFileIntent.putExtra(Intent.EXTRA_STREAM, mPath);
            startActivity(Intent.createChooser(mFileIntent, "Send mail"));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}