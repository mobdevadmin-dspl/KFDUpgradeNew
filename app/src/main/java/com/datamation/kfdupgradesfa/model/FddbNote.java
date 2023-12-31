package com.datamation.kfdupgradesfa.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public class FddbNote {

    @SerializedName("AddDate")
    private String FDDBNOTE_ADD_DATE;
    @SerializedName("AddMach")
    private String FDDBNOTE_ADD_MACH;
    @SerializedName("AddUser")
    private String FDDBNOTE_ADD_USER;
    @SerializedName("Amt")
    private String FDDBNOTE_AMT;
    @SerializedName("BAmt")
    private String FDDBNOTE_B_AMT;
    @SerializedName("BTaxAmt")
    private String FDDBNOTE_B_TAX_AMT;
    @SerializedName("CurCode")
    private String FDDBNOTE_CUR_CODE;
    @SerializedName("CurRate")
    private String FDDBNOTE_CUR_RATE;
    @SerializedName("DebCode")
    private String FDDBNOTE_DEB_CODE;
    @SerializedName("EntRemark")
    private String FDDBNOTE_ENT_REMARK;
    @SerializedName("ManuRef")
    private String FDDBNOTE_MANU_REF;
    @SerializedName("OvPayAmt")
    private String FDDBNOTE_OV_PAY_AMT;
    @SerializedName("RefInv")
    private String FDDBNOTE_REF_INV;
    @SerializedName("RefNo")
    private String FDDBNOTE_REFNO;
    @SerializedName("RefNo1")
    private String FDDBNOTE_REFNO1;
    @SerializedName("Remarks")
    private String FDDBNOTE_REMARKS;
    @SerializedName("RepCode")
    private String FDDBNOTE_REP_CODE;
    @SerializedName("SaleRefNo")
    private String FDDBNOTE_SALE_REF_NO;
    @SerializedName("TaxAmt")
    private String FDDBNOTE_TAX_AMT;
    @SerializedName("TaxComCode")
    private String FDDBNOTE_TAX_COM_CODE;
    @SerializedName("TotBal")
    private String FDDBNOTE_TOT_BAL;
    @SerializedName("TotBal1")
    private String FDDBNOTE_TOT_BAL1;
    @SerializedName("TxnDate")
    private String FDDBNOTE_TXN_DATE;
    @SerializedName("TxnType")
    private String FDDBNOTE_TXN_TYPE;
    @SerializedName("PdaAmt")
    private String FDDBNOTE_PDA_AMT;

    private String refNo;
    private String refNo1;
    private String debCode;
    private String txnDate;
    private String creditPeriod;
    private String amt;
    private long id;
    private String FDDBNOTE_ID;
    private String FDDBNOTE_RECORD_ID;
    private String FDDBNOTE_CR_ACC;
    private String FDDBNOTE_PRT_COPY;
    private String FDDBNOTE_GL_POST;
    private String FDDBNOTE_GL_BATCH;
    private String FDDBNOTE_REPNAME;
    private String  FDDBNOTE_ENTER_AMT;

    public String getFDDBNOTE_ENT_REMARK() {
        return FDDBNOTE_ENT_REMARK;
    }

    public void setFDDBNOTE_ENT_REMARK(String FDDBNOTE_ENT_REMARK) {
        this.FDDBNOTE_ENT_REMARK = FDDBNOTE_ENT_REMARK;
    }

    public String getFDDBNOTE_PDA_AMT() {
        return FDDBNOTE_PDA_AMT;
    }

    public void setFDDBNOTE_PDA_AMT(String FDDBNOTE_PDA_AMT) {
        this.FDDBNOTE_PDA_AMT = FDDBNOTE_PDA_AMT;
    }

    public String getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(String creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public String getFDDBNOTE_REPNAME() {
        return FDDBNOTE_REPNAME;
    }

    public void setFDDBNOTE_REPNAME(String FDDBNOTE_REPNAME) {
        this.FDDBNOTE_REPNAME = FDDBNOTE_REPNAME;
    }

    public String getFDDBNOTE_ENTER_AMT() {
        return FDDBNOTE_ENTER_AMT;
    }

    public void setFDDBNOTE_ENTER_AMT(String FDDBNOTE_ENTER_AMT) {
        this.FDDBNOTE_ENTER_AMT = FDDBNOTE_ENTER_AMT;
    }

    public String getFDDBNOTE_ID() {
        return FDDBNOTE_ID;
    }

    public void setFDDBNOTE_ID(String FDDBNOTE_ID) {
        this.FDDBNOTE_ID = FDDBNOTE_ID;
    }

    public String getFDDBNOTE_RECORD_ID() {
        return FDDBNOTE_RECORD_ID;
    }

    public void setFDDBNOTE_RECORD_ID(String FDDBNOTE_RECORD_ID) {
        this.FDDBNOTE_RECORD_ID = FDDBNOTE_RECORD_ID;
    }

    public String getFDDBNOTE_REFNO() {
        return FDDBNOTE_REFNO;
    }

    public void setFDDBNOTE_REFNO(String FDDBNOTE_REFNO) {
        this.FDDBNOTE_REFNO = FDDBNOTE_REFNO;
    }

    public String getFDDBNOTE_REF_INV() {
        return FDDBNOTE_REF_INV;
    }

    public void setFDDBNOTE_REF_INV(String FDDBNOTE_REF_INV) {
        this.FDDBNOTE_REF_INV = FDDBNOTE_REF_INV;
    }

    public String getFDDBNOTE_SALE_REF_NO() {
        return FDDBNOTE_SALE_REF_NO;
    }

    public void setFDDBNOTE_SALE_REF_NO(String FDDBNOTE_SALE_REF_NO) {
        this.FDDBNOTE_SALE_REF_NO = FDDBNOTE_SALE_REF_NO;
    }

    public String getFDDBNOTE_MANU_REF() {
        return FDDBNOTE_MANU_REF;
    }

    public void setFDDBNOTE_MANU_REF(String FDDBNOTE_MANU_REF) {
        this.FDDBNOTE_MANU_REF = FDDBNOTE_MANU_REF;
    }

    public String getFDDBNOTE_TXN_TYPE() {
        return FDDBNOTE_TXN_TYPE;
    }

    public void setFDDBNOTE_TXN_TYPE(String FDDBNOTE_TXN_TYPE) {
        this.FDDBNOTE_TXN_TYPE = FDDBNOTE_TXN_TYPE;
    }

    public String getFDDBNOTE_TXN_DATE() {
        return FDDBNOTE_TXN_DATE;
    }

    public void setFDDBNOTE_TXN_DATE(String FDDBNOTE_TXN_DATE) {
        this.FDDBNOTE_TXN_DATE = FDDBNOTE_TXN_DATE;
    }

    public String getFDDBNOTE_CUR_CODE() {
        return FDDBNOTE_CUR_CODE;
    }

    public void setFDDBNOTE_CUR_CODE(String FDDBNOTE_CUR_CODE) {
        this.FDDBNOTE_CUR_CODE = FDDBNOTE_CUR_CODE;
    }

    public String getFDDBNOTE_CUR_RATE() {
        return FDDBNOTE_CUR_RATE;
    }

    public void setFDDBNOTE_CUR_RATE(String FDDBNOTE_CUR_RATE) {
        this.FDDBNOTE_CUR_RATE = FDDBNOTE_CUR_RATE;
    }

    public String getFDDBNOTE_DEB_CODE() {
        return FDDBNOTE_DEB_CODE;
    }

    public void setFDDBNOTE_DEB_CODE(String FDDBNOTE_DEB_CODE) {
        this.FDDBNOTE_DEB_CODE = FDDBNOTE_DEB_CODE;
    }

    public String getFDDBNOTE_REP_CODE() {
        return FDDBNOTE_REP_CODE;
    }

    public void setFDDBNOTE_REP_CODE(String FDDBNOTE_REP_CODE) {
        this.FDDBNOTE_REP_CODE = FDDBNOTE_REP_CODE;
    }

    public String getFDDBNOTE_TAX_COM_CODE() {
        return FDDBNOTE_TAX_COM_CODE;
    }

    public void setFDDBNOTE_TAX_COM_CODE(String FDDBNOTE_TAX_COM_CODE) {
        this.FDDBNOTE_TAX_COM_CODE = FDDBNOTE_TAX_COM_CODE;
    }

    public String getFDDBNOTE_TAX_AMT() {
        return FDDBNOTE_TAX_AMT;
    }

    public void setFDDBNOTE_TAX_AMT(String FDDBNOTE_TAX_AMT) {
        this.FDDBNOTE_TAX_AMT = FDDBNOTE_TAX_AMT;
    }

    public String getFDDBNOTE_B_TAX_AMT() {
        return FDDBNOTE_B_TAX_AMT;
    }

    public void setFDDBNOTE_B_TAX_AMT(String FDDBNOTE_B_TAX_AMT) {
        this.FDDBNOTE_B_TAX_AMT = FDDBNOTE_B_TAX_AMT;
    }

    public String getFDDBNOTE_AMT() {
        return FDDBNOTE_AMT;
    }

    public void setFDDBNOTE_AMT(String FDDBNOTE_AMT) {
        this.FDDBNOTE_AMT = FDDBNOTE_AMT;
    }

    public String getFDDBNOTE_B_AMT() {
        return FDDBNOTE_B_AMT;
    }

    public void setFDDBNOTE_B_AMT(String FDDBNOTE_B_AMT) {
        this.FDDBNOTE_B_AMT = FDDBNOTE_B_AMT;
    }

    public String getFDDBNOTE_TOT_BAL() {
        return FDDBNOTE_TOT_BAL;
    }

    public void setFDDBNOTE_TOT_BAL(String FDDBNOTE_TOT_BAL) {
        this.FDDBNOTE_TOT_BAL = FDDBNOTE_TOT_BAL;
    }

    public String getFDDBNOTE_TOT_BAL1() {
        return FDDBNOTE_TOT_BAL1;
    }

    public void setFDDBNOTE_TOT_BAL1(String FDDBNOTE_TOT_BAL1) {
        this.FDDBNOTE_TOT_BAL1 = FDDBNOTE_TOT_BAL1;
    }

    public String getFDDBNOTE_OV_PAY_AMT() {
        return FDDBNOTE_OV_PAY_AMT;
    }

    public void setFDDBNOTE_OV_PAY_AMT(String FDDBNOTE_OV_PAY_AMT) {
        this.FDDBNOTE_OV_PAY_AMT = FDDBNOTE_OV_PAY_AMT;
    }

    public String getFDDBNOTE_REMARKS() {
        return FDDBNOTE_REMARKS;
    }

    public void setFDDBNOTE_REMARKS(String FDDBNOTE_REMARKS) {
        this.FDDBNOTE_REMARKS = FDDBNOTE_REMARKS;
    }

    public String getFDDBNOTE_CR_ACC() {
        return FDDBNOTE_CR_ACC;
    }

    public void setFDDBNOTE_CR_ACC(String FDDBNOTE_CR_ACC) {
        this.FDDBNOTE_CR_ACC = FDDBNOTE_CR_ACC;
    }

    public String getFDDBNOTE_PRT_COPY() {
        return FDDBNOTE_PRT_COPY;
    }

    public void setFDDBNOTE_PRT_COPY(String FDDBNOTE_PRT_COPY) {
        this.FDDBNOTE_PRT_COPY = FDDBNOTE_PRT_COPY;
    }

    public String getFDDBNOTE_GL_POST() {
        return FDDBNOTE_GL_POST;
    }

    public void setFDDBNOTE_GL_POST(String FDDBNOTE_GL_POST) {
        this.FDDBNOTE_GL_POST = FDDBNOTE_GL_POST;
    }

    public String getFDDBNOTE_GL_BATCH() {
        return FDDBNOTE_GL_BATCH;
    }

    public void setFDDBNOTE_GL_BATCH(String FDDBNOTE_GL_BATCH) {
        this.FDDBNOTE_GL_BATCH = FDDBNOTE_GL_BATCH;
    }

    public String getFDDBNOTE_ADD_USER() {
        return FDDBNOTE_ADD_USER;
    }

    public void setFDDBNOTE_ADD_USER(String FDDBNOTE_ADD_USER) {
        this.FDDBNOTE_ADD_USER = FDDBNOTE_ADD_USER;
    }

    public String getFDDBNOTE_ADD_DATE() {
        return FDDBNOTE_ADD_DATE;
    }

    public void setFDDBNOTE_ADD_DATE(String FDDBNOTE_ADD_DATE) {
        this.FDDBNOTE_ADD_DATE = FDDBNOTE_ADD_DATE;
    }

    public String getFDDBNOTE_ADD_MACH() {
        return FDDBNOTE_ADD_MACH;
    }

    public void setFDDBNOTE_ADD_MACH(String FDDBNOTE_ADD_MACH) {
        this.FDDBNOTE_ADD_MACH = FDDBNOTE_ADD_MACH;
    }

    public String getFDDBNOTE_REFNO1() {
        return FDDBNOTE_REFNO1;
    }

    public void setFDDBNOTE_REFNO1(String FDDBNOTE_REFNO1) {
        this.FDDBNOTE_REFNO1 = FDDBNOTE_REFNO1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FddbNote() {
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getRefNo1() {
        return refNo1;
    }

    public void setRefNo1(String refNo1) {
        this.refNo1 = refNo1;
    }

    public String getDebCode() {
        return debCode;
    }

    public void setDebCode(String debCode) {
        this.debCode = debCode;
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public static FddbNote parseFddbnote(JSONObject instance) throws JSONException {

        if (instance != null) {
            FddbNote fdDbNote = new FddbNote();
            BigDecimal totbal = new BigDecimal(instance.getString("totBal").trim());
            BigDecimal pdaamt = new BigDecimal(instance.getString("pdaAmt").trim());
            BigDecimal roundOff_totbal = totbal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            BigDecimal roundOff_pdaamt = pdaamt.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            fdDbNote.setFDDBNOTE_ADD_DATE("0");
            fdDbNote.setFDDBNOTE_ADD_MACH("0");
            fdDbNote.setFDDBNOTE_ADD_USER("0");
            fdDbNote.setFDDBNOTE_AMT(instance.getString("amt").trim());
            fdDbNote.setFDDBNOTE_B_AMT("0");
            fdDbNote.setFDDBNOTE_B_TAX_AMT("0");
            fdDbNote.setFDDBNOTE_CUR_CODE("0");
            fdDbNote.setFDDBNOTE_CUR_RATE("0");
            fdDbNote.setFDDBNOTE_DEB_CODE(instance.getString("debCode").trim());
            fdDbNote.setFDDBNOTE_ENT_REMARK(instance.getString("enremark").trim());
            fdDbNote.setFDDBNOTE_MANU_REF(instance.getString("manuRef").trim());
            fdDbNote.setFDDBNOTE_OV_PAY_AMT(instance.getString("ovPayAmt").trim());
            fdDbNote.setFDDBNOTE_PDA_AMT(instance.getString("pdaAmt").trim());
            fdDbNote.setFDDBNOTE_REF_INV(instance.getString("refInv").trim());
            fdDbNote.setFDDBNOTE_REFNO(instance.getString("refNo").trim());
            fdDbNote.setFDDBNOTE_REFNO1(instance.getString("refNo1").trim());
            fdDbNote.setFDDBNOTE_REMARKS(instance.getString("remarks").trim());
            fdDbNote.setFDDBNOTE_REP_CODE(instance.getString("repCode").trim());
            fdDbNote.setFDDBNOTE_REPNAME(instance.getString("repName").trim());
            fdDbNote.setFDDBNOTE_SALE_REF_NO(instance.getString("saleRefNo").trim());
            fdDbNote.setFDDBNOTE_TAX_AMT("0");
            fdDbNote.setFDDBNOTE_TAX_COM_CODE("0");
            fdDbNote.setFDDBNOTE_TOT_BAL(String.valueOf((roundOff_totbal.subtract(roundOff_pdaamt))));
            fdDbNote.setFDDBNOTE_TOT_BAL1(instance.getString("totBal1").trim());
            fdDbNote.setFDDBNOTE_TXN_DATE(instance.getString("txnDateOnly").trim());
            fdDbNote.setFDDBNOTE_TXN_TYPE(instance.getString("txnType").trim());
            fdDbNote.setFDDBNOTE_ENTER_AMT("0");

            return fdDbNote;
        }

        return null;
    }
}
