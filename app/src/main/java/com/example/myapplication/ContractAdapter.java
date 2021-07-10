package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContractAdapter extends ArrayAdapter {

    Context context;
    ArrayList<Contract> dulieu;
    int layout_contract;

    public ContractAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contract> dulieu) {
        super(context, resource, dulieu);
        this.context = context;
        this.dulieu = dulieu;
        layout_contract = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(layout_contract, null);

        TextView hoTen = convertView.findViewById(R.id.txtHoTen);
        TextView soDT = convertView.findViewById(R.id.txtSoDT);

        Contract contract = dulieu.get(position);

        hoTen.setText(contract.getHoTen());
        soDT.setText(contract.getSoDienThoai());

        return convertView;
    }
}
