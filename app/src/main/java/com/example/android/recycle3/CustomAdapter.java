package com.example.android.recycle3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;

    Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View mll_View;

        public ViewHolder(View v) {
            super(v);
            mll_View = v;
        }

        public View getll_tView() {
            return mll_View;
        }

    }

    public CustomAdapter(String[] dataSet, Context cont) {
        mDataSet = dataSet;
        mContext =  cont;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position)
    {
        LayoutInflater inf = (LayoutInflater) parent.getContext().getSystemService( parent.getContext().LAYOUT_INFLATER_SERVICE);;
        View ll = (View) inf.inflate(R.layout.fragment_card_view, null);
        LinearLayout.LayoutParams param_ll =new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );
        ll.setLayoutParams(param_ll);

        ViewHolder vh = new ViewHolder( ll );
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
 Log.d(TAG, "Element " + position + " set.");

        View ll = viewHolder.getll_tView();
        TextView tt= (TextView)ll.findViewById(R.id.lbl_text);
        tt.setText( mDataSet[position]);
        ll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
Log.d(TAG,   "position="+ String.valueOf(position));
                Intent intent = new Intent( mContext.getApplicationContext(), SubAct.class );
                intent.putExtra( "pos", String.valueOf(position) );
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
