package com.datamation.kfdupgradesfa.adapter;


import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.datamation.kfdupgradesfa.R;
import com.datamation.kfdupgradesfa.controller.FreeMslabController;
import com.datamation.kfdupgradesfa.controller.ProductController;
import com.datamation.kfdupgradesfa.dialog.CustomKeypadDialog;
import com.datamation.kfdupgradesfa.model.Product;

import java.util.ArrayList;

public class NewProduct_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    Context context;
    ArrayList<Product> list;
    String preText = null;

    public NewProduct_Adapter(Context context, final ArrayList<Product> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        if(list !=null){
            return list.size();
        }
        return 0;
    }

    @Override
    public Product getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView,ViewGroup parent) {
     final ViewHolder viewHolder;

        if(convertView ==null){
            viewHolder =new ViewHolder();
            convertView =inflater.inflate(R.layout.row_product_item,parent,false);

            viewHolder.lnStripe = (LinearLayout) convertView.findViewById(R.id.lnProductStripe);
            viewHolder.itemCode =(TextView)convertView.findViewById(R.id.row_itemcode);
            viewHolder.ItemName =(TextView)convertView.findViewById(R.id.row_itemname);
            viewHolder.Price =(TextView)convertView.findViewById(R.id.row_price);
            viewHolder.HoQ =(TextView)convertView.findViewById(R.id.row_qoh);
            viewHolder.lblQty =(TextView)convertView.findViewById(R.id.et_qty);
            viewHolder.btnPlus =(ImageButton)convertView.findViewById(R.id.btnAddition);
            viewHolder.btnMinus =(ImageButton) convertView.findViewById(R.id.btnSubtract);
            viewHolder.freeSchema=(TextView)convertView.findViewById(R.id.row_free_schema);
            
 
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
           final  Product product=getItem(position); 

        viewHolder.itemCode.setText(product.getFPRODUCT_ITEMCODE());
        viewHolder.ItemName.setText(product.getFPRODUCT_ITEMNAME() + "   || " +product.getFPRODUCT_PACK());
        viewHolder.Price.setText(product.getFPRODUCT_PRICE());
        viewHolder.HoQ.setText(product.getFPRODUCT_QOH());
        viewHolder.lblQty.setText(product.getFPRODUCT_QTY());
        viewHolder.freeSchema.setTextColor(Color.parseColor("#000000"));
        
        int compvalue = 0;
        compvalue = Integer.parseInt(product.getFPRODUCT_QOH());
//			 || product.getFPRODUCT_QOH().equals("0")
         if(compvalue<=0){
         	viewHolder.HoQ.setTextColor(Color.parseColor("#FF0000"));
         	viewHolder.ItemName.setTextColor(Color.parseColor("#FF0000"));
         }else{
        	 viewHolder.HoQ.setTextColor(Color.parseColor("#4682B4"));
        	 viewHolder.ItemName.setTextColor(Color.parseColor("#4682B4"));
         }
         
        if(product.getFPRODUCT_FREESCREMA()!=null && !product.getFPRODUCT_FREESCREMA().isEmpty()){
        	 viewHolder.freeSchema.setText(product.getFPRODUCT_FREESCREMA());
        }else{
        	 viewHolder.freeSchema.setText("BONUS");
        }
       

        /*Change colors*/
        if (Integer.parseInt(viewHolder.lblQty.getText().toString()) > 0){
            viewHolder.lnStripe.setBackground(context.getResources().getDrawable(R.drawable.custom_textbox_new));
        }else{
            viewHolder.lnStripe.setBackground(context.getResources().getDrawable(R.drawable.custom_textbox));
        }
        
        
        viewHolder.freeSchema.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				viewHolder.freeSchema.setText (new FreeMslabController(context).getFreeDetails(product.getFPRODUCT_ITEMCODE(),product.getFPRODUCT_DEBCODE()));
			}
		});
        
        /*-*-*-*-*-*-*--*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

        viewHolder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int qty = Integer.parseInt(viewHolder.lblQty.getText().toString());

                if (--qty >= 0) {
                    viewHolder.lblQty.setText((Integer.parseInt(viewHolder.lblQty.getText().toString()) - 1) + "");
                    list.get(position).setFPRODUCT_QTY(viewHolder.lblQty.getText().toString());
                    new ProductController(context).updateProductQty(product.getFPRODUCT_ITEMCODE(), viewHolder.lblQty.getText().toString());
                }

                /*Change colors*/
                if (qty == 0)
                    viewHolder.lnStripe.setBackground(context.getResources().getDrawable(R.drawable.custom_textbox));

            }
        });

        /*-*-*-*-*-*-*--*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

        viewHolder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double qty = Double.parseDouble(viewHolder.lblQty.getText().toString());

                viewHolder.lnStripe.setBackground(context.getResources().getDrawable(R.drawable.custom_textbox_new));

                if (qty >=0) {
                    viewHolder.lblQty.setText((Integer.parseInt(viewHolder.lblQty.getText().toString()) + 1) + "");
                    product.setFPRODUCT_QTY(viewHolder.lblQty.getText().toString());
                    new ProductController(context).updateProductQty(product.getFPRODUCT_ITEMCODE(), viewHolder.lblQty.getText().toString());
                }
            }
        });

        /*-*-*-*-*-*-*--*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

        viewHolder.btnPlus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        viewHolder.btnPlus.setBackground(context.getResources().getDrawable(R.drawable.icon_plus));
                    }
                    break;

                    case MotionEvent.ACTION_UP: {
                        viewHolder.btnPlus.setBackground(context.getResources().getDrawable(R.drawable.icon_plus));
                    }
                    break;
                }
                return false;
            }
        });

        /*-*-*-*-*-*-*--*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

        viewHolder.btnMinus.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        viewHolder.btnMinus.setBackground(context.getResources().getDrawable(R.drawable.icon_minus));
                    }
                    break;

                    case MotionEvent.ACTION_UP: {
                        viewHolder.btnMinus.setBackground(context.getResources().getDrawable(R.drawable.icon_minus));
                    }
                    break;
                }
                return false;
            }
        });

        //--------------------------------------------------------------------------------------------------------------------------
        viewHolder.lblQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomKeypadDialog keypad = new CustomKeypadDialog(context, false, new CustomKeypadDialog.IOnOkClickListener() {
                    @Override
                    public void okClicked(double value) {
                        String distrStock = product.getFPRODUCT_QOH();
                        int enteredQty = (int) value;
                        Log.d("<>+++++","" + distrStock);
                            new ProductController(context).updateProductQty(product.getFPRODUCT_ITEMCODE(), String.valueOf(enteredQty));
                            //Not check Exceeds Qty in Pre sales------------------------------------
                            product.setFPRODUCT_QTY(String.valueOf(enteredQty));
                            viewHolder.lblQty.setText(product.getFPRODUCT_QTY());
                       




                        //*Change colors*//**//*
                        if (Integer.parseInt(viewHolder.lblQty.getText().toString()) > 0)
                            viewHolder.lnStripe.setBackground(context.getResources().getDrawable(R.drawable.custom_textbox_new));
                        else
                            viewHolder.lnStripe.setBackground(context.getResources().getDrawable(R.drawable.custom_textbox));

                    }
                });

                keypad.show();

                keypad.setHeader("SELECT QUANTITY");
                keypad.loadValue(Double.parseDouble(product.getFPRODUCT_QTY()));


            }
        });


   return convertView;
    }

    private  static  class  ViewHolder{
        LinearLayout lnStripe;
        TextView itemCode;
        TextView ItemName;
        TextView Price;
        TextView HoQ;
        TextView lblQty;
        TextView freeSchema;
        ImageButton btnPlus;
        ImageButton btnMinus;

    }

}
