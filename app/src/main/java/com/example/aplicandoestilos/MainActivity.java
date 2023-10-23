package com.example.aplicandoestilos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private LinearLayout layPrincipal;
    private TextView lblRadio, lblCheck, lblPrueba;
    private RadioGroup radGr;
    private RadioButton radOp1, radOp2, radOp3;
    private CheckBox chkOp1, chkOp2;
    private SwitchCompat sw1, sw2;

    private boolean logActivado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layPrincipal = findViewById(R.id.layPrincipal);

        lblRadio = findViewById(R.id.lblRadio);
        lblCheck = findViewById(R.id.lblCheck);
        lblPrueba = findViewById(R.id.lblPrueba);

        radGr = findViewById(R.id.radGr);
        radGr.setOnCheckedChangeListener(this);

        radOp1 = findViewById(R.id.radOp1);
        radOp2 = findViewById(R.id.radOp2);
        radOp3 = findViewById(R.id.radOp3);

        chkOp1 = findViewById(R.id.chkOp1);
        chkOp2 = findViewById(R.id.chkOp2);
        chkOp1.setOnCheckedChangeListener(this);
        chkOp2.setOnCheckedChangeListener(this);

        sw1 = findViewById(R.id.sw1);
        sw2 = findViewById(R.id.sw2);
        sw1.setOnCheckedChangeListener(this);
        sw2.setOnCheckedChangeListener(this);

        radOp1.setChecked(true);
        logActivado = false;

    }

    @Override
    public void onCheckedChanged(CompoundButton cb, boolean b) {
        String cbText = cb.getText().toString();

        // Checkboxes
        if (cbText.equals(getString(R.string.chkOp1))) {
            if (b) {
                if (chkOp2.isChecked()) {
                    lblPrueba.setTypeface(null, Typeface.BOLD_ITALIC);
                } else {
                    lblPrueba.setTypeface(null, Typeface.BOLD);
                }
                if (logActivado) Log.d("Estilo", "Negrita activado.");
            } else {
                if (chkOp2.isChecked()) {
                    lblPrueba.setTypeface(null, Typeface.ITALIC);
                } else {
                    lblPrueba.setTypeface(null, Typeface.NORMAL);
                }
                if (logActivado) Log.d("Estilo", "Negrita desactivado.");
            }
        } else if (cbText.equals(getString(R.string.chkOp2))) {
            if (b) {
                if (chkOp1.isChecked()) {
                    lblPrueba.setTypeface(null, Typeface.BOLD_ITALIC);
                } else {
                    lblPrueba.setTypeface(null, Typeface.ITALIC);
                }
                if (logActivado) Log.d("Estilo", "Cursiva activado.");
            } else {
                if (chkOp1.isChecked()) {
                    lblPrueba.setTypeface(null, Typeface.BOLD);
                } else {
                    lblPrueba.setTypeface(null, Typeface.NORMAL);
                }
                if (logActivado) Log.d("Estilo", "Cursiva desactivado.");
            }
        }

        //Switches
        if (cbText.equals(getString(R.string.sw1))) {
            int colorBlack = getColor(R.color.black);
            int colorWhite = getColor(R.color.white);
            if (b) {
                layPrincipal.setBackgroundColor(colorBlack);
                lblRadio.setTextColor(colorWhite);
                lblCheck.setTextColor(colorWhite);
                radOp1.setTextColor(colorWhite);
                radOp2.setTextColor(colorWhite);
                radOp3.setTextColor(colorWhite);
                chkOp1.setTextColor(colorWhite);
                chkOp2.setTextColor(colorWhite);
                sw1.setTextColor(colorWhite);
                sw2.setTextColor(colorWhite);
                if (logActivado) Log.d("Modo oscuro", "Modo oscuro activado.");
            } else {
                layPrincipal.setBackgroundColor(colorWhite);
                lblRadio.setTextColor(colorBlack);
                lblCheck.setTextColor(colorBlack);
                radOp1.setTextColor(colorBlack);
                radOp2.setTextColor(colorBlack);
                radOp3.setTextColor(colorBlack);
                chkOp1.setTextColor(colorBlack);
                chkOp2.setTextColor(colorBlack);
                sw1.setTextColor(colorBlack);
                sw2.setTextColor(colorBlack);
                if (logActivado) Log.d("Modo oscuro", "Modo oscuro desactivado.");
            }
        } else if (cbText.equals(getString(R.string.sw2))) {
            logActivado = b;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup rg, int i) {
        String seleccionado = ((RadioButton)findViewById(i)).getText().toString();

        if (seleccionado.equals(getString(R.string.radOp1))) {
            lblPrueba.setTextColor(getColor(R.color.verde));
            if (logActivado) Log.d("Color", "Color verde activado.");
        } else if (seleccionado.equals(getString(R.string.radOp2))) {
            lblPrueba.setTextColor(getColor(R.color.rojo));
            if (logActivado) Log.d("Color", "Color rojo activado.");
        } else if (seleccionado.equals(getString(R.string.radOp3))) {
            lblPrueba.setTextColor(getColor(R.color.azul));
            if (logActivado) Log.d("Color", "Color azul activado.");
        }
    }
}