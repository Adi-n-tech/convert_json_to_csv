
package com.adintech.convertjsondatatoexcelformat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DistanceResponse {

    @SerializedName("distanceList\u0325")
    @Expose
    private ArrayList<DistanceList> distanceList = null;

    public ArrayList<DistanceList> getDistanceList() {
        return distanceList;
    }

    public void setDistanceList(ArrayList<DistanceList> distanceList) {
        this.distanceList = distanceList;
    }

}
