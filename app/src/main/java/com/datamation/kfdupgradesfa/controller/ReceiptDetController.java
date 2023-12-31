package com.datamation.kfdupgradesfa.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.datamation.kfdupgradesfa.helpers.DatabaseHelper;
import com.datamation.kfdupgradesfa.helpers.ValueHolder;
import com.datamation.kfdupgradesfa.model.OrderDetail;
import com.datamation.kfdupgradesfa.model.RecDet;
import com.datamation.kfdupgradesfa.model.ReceiptDet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ReceiptDetController {

	private SQLiteDatabase dB;
	private DatabaseHelper dbHelper;
	Context context;
	private String TAG = "KdfUpgrade";

	public static final String CREATE_FPRECDET_TABLE = "CREATE  TABLE IF NOT EXISTS " + ValueHolder.TABLE_FPRECDET + " (" + ValueHolder.FPRECDET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ValueHolder.REFNO + " TEXT, " + ValueHolder.FPRECDET_REFNO1 + " TEXT, " + ValueHolder.FPRECDET_REFNO2 + " TEXT, " + ValueHolder.DEBCODE + " TEXT, " + ValueHolder.FPRECDET_SALEREFNO + " TEXT, "

			+ ValueHolder.FPRECDET_MANUREF + " TEXT, " + ValueHolder.FPRECDET_TXNTYPE + " TEXT, " + ValueHolder.TXNDATE + " TEXT, "
			+ ValueHolder.FPRECDET_DTXNDATE + " TEXT, " + ValueHolder.FPRECDET_DTXNTYPE + " TEXT, " + ValueHolder.FPRECDET_DCURCODE + " TEXT, " + ValueHolder.FPRECDET_DCURRATE + " TEXT, "
			+ ValueHolder.FPRECDET_OCURRATE + " TEXT, " + ValueHolder.REPCODE + " TEXT, " + ValueHolder.FPRECDET_AMT + " TEXT, " + ValueHolder.FPRECDET_BAMT + " TEXT, "
			+ ValueHolder.FPRECDET_ALOAMT + " TEXT, " + ValueHolder.FPRECDET_OVPAYAMT + " TEXT, " + ValueHolder.FPRECDET_REMARK + " TEXT, " + ValueHolder.FPRECDET_OVPAYBAL + " TEXT, " + ValueHolder.FPRECDET_RECORDID + " TEXT, " + ValueHolder.FPRECDET_ISDELETE + " TEXT, " + ValueHolder.FPRECDET_TIMESTAMP + " TEXT );";

	/*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/


	public static final String CREATE_FPRECDETS_TABLE = "CREATE  TABLE IF NOT EXISTS " + ValueHolder.TABLE_FPRECDETS  + " (" + ValueHolder.FPRECDET_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ValueHolder.REFNO + " TEXT, " + ValueHolder.FPRECDET_REFNO1 + " TEXT, " + ValueHolder.FPRECDET_REFNO2 + " TEXT, " + ValueHolder.DEBCODE + " TEXT, " + ValueHolder.FPRECDET_SALEREFNO + " TEXT, "

			+ ValueHolder.FPRECDET_MANUREF + " TEXT, " + ValueHolder.FPRECDET_TXNTYPE + " TEXT, " + ValueHolder.TXNDATE + " TEXT, "

			+ ValueHolder.FPRECDET_DTXNDATE + " TEXT, " + ValueHolder.FPRECDET_DTXNTYPE + " TEXT, " + ValueHolder.FPRECDET_DCURCODE + " TEXT, " + ValueHolder.FPRECDET_DCURRATE + " TEXT, "

			+ ValueHolder.FPRECDET_OCURRATE + " TEXT, " + ValueHolder.REPCODE + " TEXT, " + ValueHolder.FPRECDET_AMT + " TEXT, " + ValueHolder.FPRECDET_BAMT + " TEXT, " + ValueHolder.FPRECDET_ISDELETE + " TEXT, "

			+ ValueHolder.FPRECDET_REMARK + " TEXT, " + ValueHolder.FPRECDET_ALOAMT + " TEXT, " + ValueHolder.FPRECDET_OVPAYAMT + " TEXT, " + ValueHolder.FPRECDET_OVPAYBAL + " TEXT, " + ValueHolder.FPRECDET_RECORDID + " TEXT, " + ValueHolder.FPRECDET_TIMESTAMP + " TEXT );";

	public ReceiptDetController(Context context) {
		this.context = context;
		dbHelper = new DatabaseHelper(context);
	}

	public void open() throws SQLException {
		dB = dbHelper.getWritableDatabase();
	}

	public ArrayList<ReceiptDet> getTodayPayments() {
		int curYear = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
		int curMonth = Integer.parseInt(new SimpleDateFormat("MM").format(new Date()));
		int curDate = Integer.parseInt(new SimpleDateFormat("dd").format(new Date()));
		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;
		ArrayList<ReceiptDet> list = new ArrayList<ReceiptDet>();

		try {
			String selectQuery = "select hed.refno, det.RefNo1, hed.paytype,det.aloamt, fddb.totbal, det.dtxndate from fprecheds hed, fprecdets det," +
					//			" fddbnote fddb where hed.refno = det.refno and det.FPRECDET_REFNO1 = fddb.refno and hed.txndate = '2019-04-12'";
					" fddbnote fddb where hed.refno = det.refno and det.RefNo1 = fddb.refno and hed.txndate = '" + curYear + "-" + String.format("%02d", curMonth) + "-" + String.format("%02d", curDate) +"'";

			cursor = dB.rawQuery(selectQuery, null);

			while (cursor.moveToNext()) {

				ReceiptDet recDet = new ReceiptDet();

//
				recDet.setFPRECDET_REFNO(cursor.getString(cursor.getColumnIndex(ValueHolder.REFNO)));
				recDet.setFPRECDET_REFNO1(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REFNO1)));
				recDet.setFPRECDET_REPCODE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECHED_PAYTYPE)));
				recDet.setFPRECDET_ALOAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_ALOAMT)));
				recDet.setFPRECDET_AMT(cursor.getString(cursor.getColumnIndex(ValueHolder.TOT_BAL)));
				recDet.setFPRECDET_TXNDATE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DTXNDATE)));

				list.add(recDet);
			}

		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}

		return list;

	}

	//------------------------------------------------------------old functions
	public int createOrUpdateRecDet(ArrayList<ReceiptDet> list) {

		int count = 0;

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;

		try {

			for (ReceiptDet recDet : list) {

				String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDET + " WHERE " + ValueHolder.FPRECDET_ID + " = '" + recDet.getFPRECDET_ID() + "'";

				cursor = dB.rawQuery(selectQuery, null);

				ContentValues values = new ContentValues();

				values.put(ValueHolder.FPRECDET_ALOAMT, recDet.getFPRECDET_ALOAMT());
				values.put(ValueHolder.FPRECDET_AMT, recDet.getFPRECDET_AMT());
				values.put(ValueHolder.FPRECDET_BAMT, recDet.getFPRECDET_BAMT());
				values.put(ValueHolder.FPRECDET_DCURCODE, recDet.getFPRECDET_DCURCODE());
				values.put(ValueHolder.FPRECDET_DCURRATE, recDet.getFPRECDET_DCURRATE());
				values.put(ValueHolder.FPRECDET_DTXNDATE, recDet.getFPRECDET_DTXNDATE());
				values.put(ValueHolder.FPRECDET_DTXNTYPE, recDet.getFPRECDET_DTXNTYPE());
				values.put(ValueHolder.FPRECDET_MANUREF, recDet.getFPRECDET_MANUREF());
				values.put(ValueHolder.FPRECDET_OCURRATE, recDet.getFPRECDET_OCURRATE());
				values.put(ValueHolder.FPRECDET_OVPAYAMT, recDet.getFPRECDET_OVPAYAMT());
				values.put(ValueHolder.FPRECDET_OVPAYBAL, recDet.getFPRECDET_OVPAYBAL());
				values.put(ValueHolder.FPRECDET_RECORDID, recDet.getFPRECDET_RECORDID());
				values.put(ValueHolder.REFNO, recDet.getFPRECDET_REFNO());
				values.put(ValueHolder.FPRECDET_REFNO1, recDet.getFPRECDET_REFNO1());
				values.put(ValueHolder.REPCODE, recDet.getFPRECDET_REPCODE());
				values.put(ValueHolder.FPRECDET_SALEREFNO, recDet.getFPRECDET_SALEREFNO());
				values.put(ValueHolder.FPRECDET_TIMESTAMP, recDet.getFPRECDET_TIMESTAMP());
				values.put(ValueHolder.TXNDATE, recDet.getFPRECDET_TXNDATE());
				values.put(ValueHolder.FPRECDET_TXNTYPE, recDet.getFPRECDET_TXNTYPE());
				values.put(ValueHolder.DEBCODE, recDet.getFPRECDET_DEBCODE());
				values.put(ValueHolder.FPRECDET_REFNO2, recDet.getFPRECDET_REFNO2());
				values.put(ValueHolder.FPRECDET_ISDELETE, recDet.getFPRECDET_ISDELETE());
				values.put(ValueHolder.FPRECDET_REMARK, recDet.getFPRECDET_REMARK());

				int cn = cursor.getCount();
				if (cn > 0) {
					count = dB.update(ValueHolder.TABLE_FPRECDET, values, ValueHolder.FPRECDET_ID + " =?", new String[] { String.valueOf(recDet.getFPRECDET_ID()) });
				} else {
					count = (int) dB.insert(ValueHolder.TABLE_FPRECDET, null, values);
				}

			}
		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}
		return count;

	}

	/*
	create for single receipt save
	 */


	public int createOrUpdateRecDetS(ArrayList<ReceiptDet> list) {

		int count = 0;

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;

		try {

			for (ReceiptDet recDet : list) {

				String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDETS + " WHERE " + ValueHolder.FPRECDET_ID + " = '" + recDet.getFPRECDET_ID() + "'";

				cursor = dB.rawQuery(selectQuery, null);

				ContentValues values = new ContentValues();

				values.put(ValueHolder.FPRECDET_ALOAMT, recDet.getFPRECDET_ALOAMT());
				values.put(ValueHolder.FPRECDET_AMT, recDet.getFPRECDET_AMT());
				values.put(ValueHolder.FPRECDET_BAMT, recDet.getFPRECDET_BAMT());
				values.put(ValueHolder.FPRECDET_DCURCODE, recDet.getFPRECDET_DCURCODE());
				values.put(ValueHolder.FPRECDET_DCURRATE, recDet.getFPRECDET_DCURRATE());
				values.put(ValueHolder.FPRECDET_DTXNDATE, recDet.getFPRECDET_DTXNDATE());
				values.put(ValueHolder.FPRECDET_DTXNTYPE, recDet.getFPRECDET_DTXNTYPE());
				values.put(ValueHolder.FPRECDET_MANUREF, recDet.getFPRECDET_MANUREF());
				values.put(ValueHolder.FPRECDET_OCURRATE, recDet.getFPRECDET_OCURRATE());
				values.put(ValueHolder.FPRECDET_OVPAYAMT, recDet.getFPRECDET_OVPAYAMT());
				values.put(ValueHolder.FPRECDET_OVPAYBAL, recDet.getFPRECDET_OVPAYBAL());
				values.put(ValueHolder.FPRECDET_RECORDID, recDet.getFPRECDET_RECORDID());
				values.put(ValueHolder.REFNO, recDet.getFPRECDET_REFNO());
				values.put(ValueHolder.FPRECDET_REFNO1, recDet.getFPRECDET_REFNO1());
				values.put(ValueHolder.REPCODE, recDet.getFPRECDET_REPCODE());
				values.put(ValueHolder.FPRECDET_SALEREFNO, recDet.getFPRECDET_SALEREFNO());
				values.put(ValueHolder.FPRECDET_TIMESTAMP, recDet.getFPRECDET_TIMESTAMP());
				values.put(ValueHolder.TXNDATE, recDet.getFPRECDET_TXNDATE());
				values.put(ValueHolder.FPRECDET_TXNTYPE, recDet.getFPRECDET_TXNTYPE());
				values.put(ValueHolder.DEBCODE, recDet.getFPRECDET_DEBCODE());
				values.put(ValueHolder.FPRECDET_REFNO2, recDet.getFPRECDET_REFNO2());
				values.put(ValueHolder.FPRECDET_ISDELETE, recDet.getFPRECDET_ISDELETE());
				values.put(ValueHolder.FPRECDET_REMARK, recDet.getFPRECDET_REMARK());
				int cn = cursor.getCount();
				if (cn > 0) {
					count = dB.update(ValueHolder.TABLE_FPRECDETS, values, ValueHolder.FPRECDET_ID + " =?", new String[] { String.valueOf(recDet.getFPRECDET_ID()) });
				} else {
					count = (int) dB.insert(ValueHolder.TABLE_FPRECDETS, null, values);
				}

			}
		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}
		return count;

	}
	public boolean isAnyActiveReceipt(String debCode)
	{
		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}

		String selectQuery = "select * from " + ValueHolder.TABLE_FPRECHEDS + " WHERE " + ValueHolder.FPRECHED_ISACTIVE + "='" + "1" + "' and "+ValueHolder.DEBCODE+" = '"+debCode+"'";

		Cursor cursor = dB.rawQuery(selectQuery, null);

		try {
			if (cursor.getCount()>0)
			{
				return true;
			}
			else
			{
				return false;
			}

		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}

		return false;
	}
	public boolean isAnyActiveReceipts()
	{
		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}

		String selectQuery = "select * from " + ValueHolder.TABLE_FPRECHEDS + " WHERE " + ValueHolder.FPRECHED_ISACTIVE + "='" + "1" + "'";

		Cursor cursor = dB.rawQuery(selectQuery, null);

		try {
			if (cursor.getCount()>0)
			{
				return true;
			}
			else
			{
				return false;
			}

		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}

		return false;
	}
	/*-----------------------------------------------------------------------------------*/
	public int getItemCount(String refNo) {

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}

		try {
			String selectQuery = "SELECT count(RefNo) as RefNo FROM " + ValueHolder.TABLE_FPRECDETS + " WHERE  " + ValueHolder.REFNO + "='" + refNo + "'";
			Cursor cursor = dB.rawQuery(selectQuery, null);

			while (cursor.moveToNext()) {
				return Integer.parseInt(cursor.getString(cursor.getColumnIndex("RefNo")));
			}
			cursor.close();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			dB.close();
		}
		return 0;

	}
	//only can use for single receipt
	public ArrayList<ReceiptDet> GetReceiptByRefno(String Refno) {

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;
		ArrayList<ReceiptDet> list = new ArrayList<ReceiptDet>();

		try {
			String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDETS + " WHERE " + ValueHolder.REFNO + " = '" + Refno + "' and "
					+ ValueHolder.FPRECHED_ISDELETE + "='0'";

			cursor = dB.rawQuery(selectQuery, null);

			while (cursor.moveToNext()) {

				ReceiptDet recDet = new ReceiptDet();

				recDet.setFPRECDET_ALOAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_ALOAMT)));
				recDet.setFPRECDET_AMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_AMT)));
				recDet.setFPRECDET_BAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_BAMT)));
				recDet.setFPRECDET_DCURCODE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DCURCODE)));
				recDet.setFPRECDET_DCURRATE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DCURRATE)));
				recDet.setFPRECDET_DTXNDATE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DTXNDATE)));
				recDet.setFPRECDET_DTXNTYPE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DTXNTYPE)));
				recDet.setFPRECDET_ID(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_ID)));
				recDet.setFPRECDET_MANUREF(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_MANUREF)));
				recDet.setFPRECDET_OCURRATE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OCURRATE)));
				recDet.setFPRECDET_OVPAYAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OVPAYAMT)));
				recDet.setFPRECDET_OVPAYBAL(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OVPAYBAL)));
				recDet.setFPRECDET_RECORDID(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_RECORDID)));
				recDet.setFPRECDET_REFNO(cursor.getString(cursor.getColumnIndex(ValueHolder.REFNO)));
				recDet.setFPRECDET_REFNO1(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REFNO1)));
				recDet.setFPRECDET_REPCODE(cursor.getString(cursor.getColumnIndex(ValueHolder.REPCODE)));
				recDet.setFPRECDET_SALEREFNO(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_SALEREFNO)));
				recDet.setFPRECDET_TIMESTAMP(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_TIMESTAMP)));
				recDet.setFPRECDET_TXNDATE(cursor.getString(cursor.getColumnIndex(ValueHolder.TXNDATE)));
				recDet.setFPRECDET_TXNTYPE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_TXNTYPE)));
				recDet.setFPRECDET_REMARK(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REMARK)));
				list.add(recDet);
			}

		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}

		return list;

	}

	public ArrayList<RecDet> GetReceiptDetByRefno(String Refno,String DebCode) {

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;
		ArrayList<RecDet> list = new ArrayList<RecDet>();

		try {
			String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDETS + " WHERE " + ValueHolder.REFNO + " = '" + Refno + "' and "+ValueHolder.DEBCODE+ " = '"+DebCode+"' and "
					+ ValueHolder.FPRECHED_ISDELETE + "='0'";

			cursor = dB.rawQuery(selectQuery, null);

			while (cursor.moveToNext()) {

				RecDet recDet = new RecDet();

				recDet.setRefNo(cursor.getString(cursor.getColumnIndex(ValueHolder.REFNO)));
				recDet.setRefNo1(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REFNO1)));
				recDet.setSaleRefNo(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_SALEREFNO)));
				recDet.setManuRef(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_MANUREF)));
				recDet.setTxnDate(cursor.getString(cursor.getColumnIndex(ValueHolder.TXNDATE)));
				recDet.setTxnType(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_TXNTYPE)));
				recDet.setDtxnDate(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DTXNDATE)));
				recDet.setDtxnType(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DTXNTYPE)));
				recDet.setDcurCode(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DCURCODE)));
				recDet.setDcurRate(Double.parseDouble(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DCURRATE))));
				recDet.setOcurRate(Double.parseDouble(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OCURRATE))));
				recDet.setRepCode(cursor.getString(cursor.getColumnIndex(ValueHolder.REPCODE)));
				recDet.setAmt(Double.parseDouble(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_AMT))));
				recDet.setBamt(Double.parseDouble(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_BAMT))));
				recDet.setAloAmt(Double.parseDouble(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_ALOAMT))));
				recDet.setOvPayAmt(Double.parseDouble(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OVPAYAMT))));
				recDet.setOvPayBal(Double.parseDouble(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OVPAYBAL))));
				recDet.setRemarks(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REMARK)));
				recDet.setRefno2(cursor.getString(cursor.getColumnIndex(ValueHolder.REFNO)));

				list.add(recDet);
			}

		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}

		return list;

	}

	public ArrayList<ReceiptDet> GetMReceiptByRefno(String Refno) {

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;
		ArrayList<ReceiptDet> list = new ArrayList<ReceiptDet>();

		try {
			String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDET + " WHERE " + ValueHolder.REFNO + " = '" + Refno + "'";

			cursor = dB.rawQuery(selectQuery, null);

			while (cursor.moveToNext()) {

				ReceiptDet recDet = new ReceiptDet();

				recDet.setFPRECDET_ALOAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_ALOAMT)));
				recDet.setFPRECDET_AMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_AMT)));
				recDet.setFPRECDET_BAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_BAMT)));
				recDet.setFPRECDET_DCURCODE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DCURCODE)));
				recDet.setFPRECDET_DCURRATE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DCURRATE)));
				recDet.setFPRECDET_DTXNDATE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DTXNDATE)));
				recDet.setFPRECDET_DTXNTYPE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_DTXNTYPE)));
				recDet.setFPRECDET_ID(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_ID)));
				recDet.setFPRECDET_MANUREF(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_MANUREF)));
				recDet.setFPRECDET_OCURRATE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OCURRATE)));
				recDet.setFPRECDET_OVPAYAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OVPAYAMT)));
				recDet.setFPRECDET_OVPAYBAL(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_OVPAYBAL)));
				recDet.setFPRECDET_RECORDID(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_RECORDID)));
				recDet.setFPRECDET_REFNO(cursor.getString(cursor.getColumnIndex(ValueHolder.REFNO)));
				recDet.setFPRECDET_REFNO1(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REFNO1)));
				recDet.setFPRECDET_REFNO2(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REFNO2)));
				recDet.setFPRECDET_REPCODE(cursor.getString(cursor.getColumnIndex(ValueHolder.REPCODE)));
				recDet.setFPRECDET_SALEREFNO(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_SALEREFNO)));
				recDet.setFPRECDET_TIMESTAMP(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_TIMESTAMP)));
				recDet.setFPRECDET_TXNDATE(cursor.getString(cursor.getColumnIndex(ValueHolder.TXNDATE)));
				recDet.setFPRECDET_TXNTYPE(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_TXNTYPE)));
				recDet.setFPRECDET_REMARK(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_REMARK)));
				list.add(recDet);
			}

		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}

		return list;

	}
	@SuppressWarnings("static-access")
	public int restDataForMR(String refno) {

		int count = 0;

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;

		try {

			String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDET + "  WHERE RefNo = '" + refno + "'";
			cursor = dB.rawQuery(selectQuery, null);
			int cn = cursor.getCount();

			if (cn > 0) {
				count = dB.delete(ValueHolder.TABLE_FPRECDET, ValueHolder.REFNO + " ='" + refno + "'", null);
				Log.v("Success Stauts", count + "");
			}
		} catch (Exception e) {
			Log.v(TAG + " Exception", e.toString());
		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}
		return count;

	}
	public int UpdateDeleteStatusMR(String refno) {

		int count = 0;

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;

		try {

			String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDET + " WHERE " + ValueHolder.FPRECDET_REFNO2 + " = '" + refno + "'";
			cursor = dB.rawQuery(selectQuery, null);


			ContentValues values = new ContentValues();

			values.put(ValueHolder.FPRECDET_ISDELETE, "1");

			int cn = cursor.getCount();

			if (cn > 0) {
				count = dB.update(ValueHolder.TABLE_FPRECDET, values,ValueHolder.FPRECDET_REFNO2 + " ='" + refno + "'", null);
				Log.v("Success Stauts", count + "");
			}
			else {
				count = (int) dB.insert(ValueHolder.TABLE_FPRECDET, null, values);
			}
		} catch (Exception e) {
			Log.v(TAG + " Exception", e.toString());
		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}
		return count;

	}
	public int UpdateDeleteStatus(String refno) {

		int count = 0;

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;

		try {

			String selectQuery = "SELECT * FROM " + ValueHolder.TABLE_FPRECDETS + " WHERE " + ValueHolder.REFNO + " = '" + refno + "'";
			cursor = dB.rawQuery(selectQuery, null);


			ContentValues values = new ContentValues();

			values.put(ValueHolder.FPRECDET_ISDELETE, "1");

			int cn = cursor.getCount();

			if (cn > 0) {
				count = dB.update(ValueHolder.TABLE_FPRECDETS, values,ValueHolder.REFNO + " ='" + refno + "'", null);
				Log.v("Success Stauts", count + "");
			}
			else {
				count = (int) dB.insert(ValueHolder.TABLE_FPRECDETS, null, values);
			}
		} catch (Exception e) {
			Log.v(TAG + " Exception", e.toString());
		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}
		return count;

	}
	public String getTotal(String refNo) {

		String sum = null;

		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}
		Cursor cursor = null;

		try {

			String selectQuery = "SELECT SUM("+ValueHolder.FPRECDET_ALOAMT+") FROM " + ValueHolder.TABLE_FPRECDET + " WHERE "
					+ ValueHolder.REFNO + " = '" + refNo + "'";

			cursor = dB.rawQuery(selectQuery, null);

			sum = cursor.getString(0);

		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}
		return sum;

	}

	//   *%*%*%*%*%*%*%%%*%*%* MMS 2022/02/11 *%*%%*%*%*%*%*%*%*//
	public ArrayList<ReceiptDet> getTodayreceiptsDets(String refno, String from, String to) {


		if (dB == null) {
			open();
		} else if (!dB.isOpen()) {
			open();
		}

		ArrayList<ReceiptDet> list = new ArrayList<ReceiptDet>();

		String selectQuery = "";

		if(from.equals("") && to.equals("")){
			selectQuery = "select * from TblRecDetS WHERE "	+ ValueHolder.REFNO + "='" + refno + "' ";
		}else{
			selectQuery = "select * from TblRecDetS WHERE "	+ ValueHolder.REFNO + "='" + refno + "' "
					+ " and  txndate between '" + from + "' and '" + to + "'";
		}



		Cursor cursor = dB.rawQuery(selectQuery, null);

		try {
			while (cursor.moveToNext()) {

				ReceiptDet recDet = new ReceiptDet();

				recDet.setFPRECDET_ID(cursor.getString(cursor.getColumnIndex(ValueHolder.ID)));
				recDet.setFPRECDET_AMT(cursor.getString(cursor.getColumnIndex(ValueHolder.AMT)));
				recDet.setFPRECDET_DEBCODE(cursor.getString(cursor.getColumnIndex(ValueHolder.DEBCODE)));
				recDet.setFPRECDET_REFNO1(cursor.getString(cursor.getColumnIndex(ValueHolder.REFNO1)));
				recDet.setFPRECDET_TXNTYPE(cursor.getString(cursor.getColumnIndex(ValueHolder.TXNTYPE)));
				recDet.setFPRECDET_TXNDATE(cursor.getString(cursor.getColumnIndex(ValueHolder.TXNDATE)));
				recDet.setFPRECDET_ALOAMT(cursor.getString(cursor.getColumnIndex(ValueHolder.FPRECDET_ALOAMT)));

				list.add(recDet);

			}
		} catch (Exception e) {

			Log.v(TAG + " Exception", e.toString());

		} finally {
			if (cursor != null) {
				cursor.close();
			}
			dB.close();
		}

		return list;
	}
}
