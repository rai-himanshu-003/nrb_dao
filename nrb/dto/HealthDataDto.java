/*
 * Creation : 9 Mar 2022
 */
package com.inetpsa.nrb.dto;

/**
 * class HealthDataDto
 */
public class HealthDataDto {
    private String soh;
    private String soc;
    private String mic;
    private String mac;
    private String rinsulation;
    private String rinternal;
    private String t10;
    private String tat;

    public String getSoh() {
        return soh;
    }

    public void setSoh(String soh) {
        this.soh = soh;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getRinsulation() {
        return rinsulation;
    }

    public void setRinsulation(String rinsulation) {
        this.rinsulation = rinsulation;
    }

    public String getRinternal() {
        return rinternal;
    }

    public void setRinternal(String rinternal) {
        this.rinternal = rinternal;
    }

    public String getT10() {
        return t10;
    }

    public void setT10(String t10) {
        this.t10 = t10;
    }

    public String getTat() {
        return tat;
    }

    public void setTat(String tat) {
        this.tat = tat;
    }

    @Override
    public String toString() {
        return "HealthDataDto [soh=" + soh + ", soc=" + soc + ", mic=" + mic + ", mac=" + mac + ", rinsulation=" + rinsulation + ", rinternal="
                + rinternal + ", t10=" + t10 + ", tat=" + tat + "]";
    }

}
