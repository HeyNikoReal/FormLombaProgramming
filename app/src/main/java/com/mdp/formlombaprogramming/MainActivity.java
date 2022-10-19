package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etNoWhatsapp, etAlamat, etPassword, etPin;
    RadioGroup rgJenisKelamin;
    RadioButton rbJenisKelamin;
    Button btnDaftar, btnreset;
    String nama, jenisKelamin, noWhatsapp, alamat, password, pin;
    int jenisKelaminID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = findViewById(R.id.et_nama);
        etNoWhatsapp = findViewById(R.id.et_no_whatsapp);
        etAlamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);
        rgJenisKelamin = findViewById(R.id.rg_jenis_kelamin);
        btnDaftar = findViewById(R.id.btn_daftar);
        btnreset = findViewById(R.id.btn_reset);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etNama.setText("");
                etNoWhatsapp.setText("");
                etAlamat.setText("");
                etPassword.setText("");
                etPin.setText("");
                rgJenisKelamin.check(R.id.rb_pria);
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = etNama.getText().toString();
                noWhatsapp = etNoWhatsapp.getText().toString();
                alamat = etAlamat.getText().toString();
                password = etPassword.getText().toString();
                pin = etPin.getText().toString();
                jenisKelaminID = rgJenisKelamin.getCheckedRadioButtonId();
                rbJenisKelamin = findViewById(jenisKelaminID);
                jenisKelamin = rbJenisKelamin.getText().toString();

                if (nama.trim().equals("")) {
                    etNama.setError("Nama Tidak Boleh Kosong");
                } else if (noWhatsapp.trim().equals("")) {
                    etNoWhatsapp.setError("No Whatsapp Tidak Boleh Kosong");
                } else if (alamat.trim().equals("")) {
                    etAlamat.setError("Alamat Tidak Boleh Kosong");
                } else if (password.trim().equals("")) {
                    etPassword.setError("Password Tidak Boleh Kosong");
                } else if (pin.trim().equals("")) {
                    etPin.setError("PIN Tidak Boleh Kosong");
                } else {
                    Intent kirim = new Intent(MainActivity.this, ConfirmActivity.class);
                    kirim.putExtra("varNama", nama);
                    kirim.putExtra("varNoWhatsapp", noWhatsapp);
                    kirim.putExtra("varAlamat", alamat);
                    kirim.putExtra("varJenisKelamin", jenisKelamin);
                    startActivity(kirim);
                }
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etNoWhatsapp.setText("");
        etAlamat.setText("");
        etPassword.setText("");
        etPin.setText("");
        rgJenisKelamin.check(R.id.rb_pria);
    }
}