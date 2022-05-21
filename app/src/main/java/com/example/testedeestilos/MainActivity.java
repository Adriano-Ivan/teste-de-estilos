package com.example.testedeestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private TextView viewText;
    private EditText editText;
    private Button buttonShowText;
    private SeekBar seekBarSizeText;
    private TextView showSkbSizeText;
    private CheckBox chkNegrito;
    private CheckBox chkItalico;
    private CheckBox chkMaiuscula;
    private RadioGroup rdgCor;
    private RadioButton rdbVermelho;
    private RadioButton rdbVerde;
    private RadioButton rdbAzul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewText = findViewById(R.id.viewText);
        editText = findViewById(R.id.editText);
        buttonShowText = findViewById(R.id.buttonShowText);
        seekBarSizeText = findViewById(R.id.skbTextSize);
        showSkbSizeText = findViewById(R.id.showSkbTextSize);
        chkNegrito = findViewById(R.id.chkNegrito);
        chkItalico = findViewById(R.id.chkItalico);
        chkMaiuscula = findViewById(R.id.chkMaiuscula);
        rdgCor = findViewById(R.id.rdgCor);
        rdbVermelho = findViewById(R.id.rdbMVermelho);
        rdbAzul = findViewById(R.id.rdbAzul);
        rdbVerde = findViewById(R.id.rdbVerde);

        seekBarSizeText.setOnSeekBarChangeListener(this);

        buttonShowText.setOnClickListener(this);
        chkNegrito.setOnClickListener(this);
        chkItalico.setOnClickListener(this);
        chkMaiuscula.setOnClickListener(this);
        rdbVermelho.setOnClickListener(this);
        rdbAzul.setOnClickListener(this);
        rdbVerde.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonShowText){
            viewText.setText(editText.getText());
        } else if(view.getId() == R.id.chkItalico){
            if(chkItalico.isChecked()){
                viewText.setTypeface(null, Typeface.ITALIC);
            } else {
                viewText.setTypeface(null,Typeface.NORMAL);
            }

        } else if(view.getId() == R.id.chkNegrito){
            if(chkNegrito.isChecked() ){
                viewText.setTypeface(null,Typeface.BOLD);
            } else {
                viewText.setTypeface(null,Typeface.NORMAL);
            }
        } else if(view.getId() == R.id.chkMaiuscula){
            if(chkMaiuscula.isChecked()){
                viewText.setText(viewText.getText().toString().toUpperCase());
            } else {
                viewText.setText(viewText.getText().toString().toLowerCase());
            }
        } else if(view.getId() == R.id.rdbAzul){
            if(rdbAzul.isChecked()){
                viewText.setTextColor(Color.parseColor("#0000FF"));
            } else {
                viewText.setTextColor(Color.parseColor("#000000"));
            }
        } else if(view.getId() == R.id.rdbVerde){
            if(rdbVerde.isChecked()){
                viewText.setTextColor(Color.parseColor("#00FF00"));
            } else {
                viewText.setTextColor(Color.parseColor("#000000"));
            }
        } else if(view.getId() == R.id.rdbMVermelho){
            if(rdbVermelho.isChecked()){
                viewText.setTextColor(Color.parseColor("#FF0000"));
            } else {
                viewText.setTextColor(Color.parseColor("#000000"));
            }
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar.getId() == R.id.skbTextSize){
            showSkbSizeText.setText(progress+"dp");

            if(progress >= 10){
                viewText.setTextSize((float) progress);
            }

            if(progress < 10){
                seekBar.setProgress(10);
            }

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}