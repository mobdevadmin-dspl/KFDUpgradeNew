package com.datamation.kfdupgradesfa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.datamation.kfdupgradesfa.R;
import com.datamation.kfdupgradesfa.model.Reason;

import java.util.ArrayList;

public class NonProductiveReasonAdapter extends ArrayAdapter<Reason> {
    Context context;
    ArrayList<Reason> list;

    public NonProductiveReasonAdapter(Context context, ArrayList<Reason> list) {
        super(context, R.layout.row_nonprod_reason_detail, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        LayoutInflater inflater = null;
        View row = null;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.row_nonprod_reason_detail, parent, false);

        TextView Itemname = (TextView) row.findViewById(R.id.row_nonprd_Reason);
        TextView Itemcode = (TextView) row.findViewById(R.id.row_nonprd_reasonCode);

        Itemname.setText(list.get(position).getFREASON_NAME());
        Itemcode.setText(list.get(position).getFREASON_CODE());

        return row;
    }
}
