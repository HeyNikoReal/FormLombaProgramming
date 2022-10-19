package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {

    DatePickerDialog dpd;
    TextView tvNama, tvJenisKelamin, tvNoWhatsapp, tvAlamat, tvTanggal;
    Button btnTanggal, btnKonfirmasi;
    String nama, jenisKelamin, noWhatsapp, alamat;
    String choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJenisKelamin = findViewById(R.id.tv_jenis_kelamin);
        tvNoWhatsapp = findViewById(R.id.tv_no_whatsapp);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);
        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar kalender = Calendar.getInstance();
                dpd = new DatePickerDialog
                        (ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                String tahun = Integer.toString(year);
                                String bulan = Integer.toString(month + 1);
                                String tanggal = Integer.toString(day);
                                choosenDate = tanggal + " / " + bulan + " / " + tahun;
                                tvTanggal.setText(choosenDate);
                            }
                        }
                                , kalender.get(Calendar.YEAR)
                                , kalender.get(Calendar.MONTH)
                                , kalender.get(Calendar.DAY_OF_MONTH));
                dpd.show();
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data anda sudah benar ?");

                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(ConfirmActivity.this, "Terima Kasih , Pendaftaran Anda Berhasil.", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });

                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }

                });

                dialog.show();

            }
        });

        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        noWhatsapp = terima.getStringExtra("varNoWhatsapp");
        alamat = terima.getStringExtra("varAlamat");
        jenisKelamin = terima.getStringExtra("varJenisKelamin");
        tvNama.setText(nama);
        tvNoWhatsapp.setText(noWhatsapp);
        tvAlamat.setText(alamat);
        tvJenisKelamin.setText(jenisKelamin);

    }
}