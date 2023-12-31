package com.datamation.kfdupgradesfa.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class CompanyBranch {

    @SerializedName("BranchCode")
    private String FCOMPANYBRANCH_BRANCH_CODE;
    @SerializedName("cSettingsCode")
    private String FCOMPANYBRANCH_CSETTINGS_CODE;
    @SerializedName("nNumVal")
    private String FCOMPANYBRANCH_NNUM_VAL;
    @SerializedName("nYear")
    private String NYEAR;
    @SerializedName("nMonth")
    private String NMONTH;

    private String FCOMPANYBRANCH_ID;
    private String FCOMPANYBRANCH_RECORD_ID;


    public String getFCOMPANYBRANCH_ID() {
        return FCOMPANYBRANCH_ID;
    }

    public void setFCOMPANYBRANCH_ID(String fCOMPANYBRANCH_ID) {
        FCOMPANYBRANCH_ID = fCOMPANYBRANCH_ID;
    }

    public String getFCOMPANYBRANCH_BRANCH_CODE() {
        return FCOMPANYBRANCH_BRANCH_CODE;
    }

    public void setFCOMPANYBRANCH_BRANCH_CODE(String fCOMPANYBRANCH_BRANCH_CODE) {
        FCOMPANYBRANCH_BRANCH_CODE = fCOMPANYBRANCH_BRANCH_CODE;
    }

    public String getFCOMPANYBRANCH_RECORD_ID() {
        return FCOMPANYBRANCH_RECORD_ID;
    }

    public void setFCOMPANYBRANCH_RECORD_ID(String fCOMPANYBRANCH_RECORD_ID) {
        FCOMPANYBRANCH_RECORD_ID = fCOMPANYBRANCH_RECORD_ID;
    }

    public String getFCOMPANYBRANCH_CSETTINGS_CODE() {
        return FCOMPANYBRANCH_CSETTINGS_CODE;
    }

    public void setFCOMPANYBRANCH_CSETTINGS_CODE(
            String fCOMPANYBRANCH_CSETTINGS_CODE) {
        FCOMPANYBRANCH_CSETTINGS_CODE = fCOMPANYBRANCH_CSETTINGS_CODE;
    }

    public String getFCOMPANYBRANCH_NNUM_VAL() {
        return FCOMPANYBRANCH_NNUM_VAL;
    }

    public void setFCOMPANYBRANCH_NNUM_VAL(String fCOMPANYBRANCH_NNUM_VAL) {
        FCOMPANYBRANCH_NNUM_VAL = fCOMPANYBRANCH_NNUM_VAL;
    }

    public String getNYEAR() {
        return NYEAR;
    }

    public void setNYEAR(String nYEAR) {
        NYEAR = nYEAR;
    }

    public String getNMONTH() {
        return NMONTH;
    }

    public void setNMONTH(String nMONTH) {
        NMONTH = nMONTH;
    }
    public static CompanyBranch parseSettings(JSONObject instance) throws JSONException {

        if (instance != null) {
            CompanyBranch branch = new CompanyBranch();
            branch.setFCOMPANYBRANCH_BRANCH_CODE(instance.getString("branchCode").trim());
            branch.setFCOMPANYBRANCH_CSETTINGS_CODE(instance.getString("cSettingsCode").trim());
            branch.setFCOMPANYBRANCH_NNUM_VAL(instance.getString("nNumVal").trim());
            branch.setNYEAR(instance.getString("nYear").trim());
            branch.setNMONTH(instance.getString("nMonth").trim());
            return branch;
        }

        return null;
    }
}
