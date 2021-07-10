package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.provider.ContactsContract;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contract> dulieu = new ArrayList<>();
    ContractAdapter adapter;
    ListView listViewContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContract = findViewById(R.id.listView);
        adapter = new ContractAdapter(this, R.layout.layout_contract, dulieu);
        listViewContract.setAdapter(adapter);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 111);
        }
        else {
            LoadContracts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            LoadContracts();
        }
    }

    private void LoadContracts(){
        Uri uri = Uri.parse("content://contacts/people");

        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        while(cursor.moveToNext()){
            Contract contract = new Contract();
            contract.hoTen = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            contract.soDienThoai = "123456";

            dulieu.add(contract);
            return;
        }
    }

   
}