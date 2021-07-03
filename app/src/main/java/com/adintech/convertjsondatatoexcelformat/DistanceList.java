
package com.adintech.convertjsondatatoexcelformat;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DistanceList {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("km")
    @Expose
    private String km;
    private String vehicleNo;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
}
