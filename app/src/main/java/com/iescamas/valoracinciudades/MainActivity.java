package com.iescamas.valoracinciudades;

import android.graphics.Typeface;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;


public class MainActivity extends AppCompatActivity {

    String pais,ciudad,pueblo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int idpais = ((RadioGroup)findViewById(R.id.rg_paises)).getCheckedRadioButtonId();
        if(idpais!=-1){
            asignaPais(idpais);
            pais = ((RadioButton)findViewById(idpais)).getText().toString();

            mostrarMensaje(pais,ciudad,pueblo);
        }
        ((Spinner)findViewById(R.id.spCiudades)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((RadioGroup) findViewById(R.id.rg_paises)).setOnCheckedChangeListener((radioGroup, i1) -> {asignaPais(radioGroup.getCheckedRadioButtonId());
                pais = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();});
                asignaCiudades();
                ciudad = ((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().toString();
                int idpueblos1 = ((RadioGroup)findViewById(R.id.rgProvincias1)).getCheckedRadioButtonId();
                int idpueblos2 = ((RadioGroup)findViewById(R.id.rgProvincias2)).getCheckedRadioButtonId();
                if (idpueblos1!=-1){
                    pueblo = ((RadioButton) findViewById(idpueblos1)).getText().toString();
                }
                if (idpueblos2!=-1){
                    pueblo = ((RadioButton) findViewById(idpueblos2)).getText().toString();
                }

                mostrarMensaje(pais,ciudad,pueblo);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        int idProvincia1 = ((RadioGroup)findViewById(R.id.rgProvincias1)).getCheckedRadioButtonId();
        if(idProvincia1!=-1){

            pueblo = ((RadioButton)findViewById(idProvincia1)).getText().toString();
            mostrarMensaje(pais,ciudad,pueblo);
        }
        int idProvincia2 = ((RadioGroup)findViewById(R.id.rgProvincias2)).getCheckedRadioButtonId();
        if(idProvincia2!=-1){
            pueblo = ((RadioButton)findViewById(idProvincia2)).getText().toString();
            mostrarMensaje(pais,ciudad,pueblo);
        }

        findViewById(R.id.rbProvincia1).setOnClickListener(view ->{excluyeGrupo(2); pueblo = ((RadioButton)findViewById(R.id.rbProvincia1)).getText().toString();;mostrarMensaje(pais,ciudad,pueblo);});
        findViewById(R.id.rbProvincia2).setOnClickListener(view ->{excluyeGrupo(2); pueblo = ((RadioButton)findViewById(R.id.rbProvincia2)).getText().toString();;mostrarMensaje(pais,ciudad,pueblo);});
        findViewById(R.id.rbProvincia3).setOnClickListener(view ->{excluyeGrupo(2); pueblo = ((RadioButton)findViewById(R.id.rbProvincia3)).getText().toString();;mostrarMensaje(pais,ciudad,pueblo);});

        findViewById(R.id.rbProvincia4).setOnClickListener(view ->{excluyeGrupo(1); pueblo = ((RadioButton)findViewById(R.id.rbProvincia4)).getText().toString();;mostrarMensaje(pais,ciudad,pueblo);});
        findViewById(R.id.rbProvincia5).setOnClickListener(view ->{excluyeGrupo(1); pueblo = ((RadioButton)findViewById(R.id.rbProvincia5)).getText().toString();;mostrarMensaje(pais,ciudad,pueblo);});
        findViewById(R.id.rbProvicia6).setOnClickListener(view ->{excluyeGrupo(1); pueblo = ((RadioButton)findViewById(R.id.rbProvicia6)).getText().toString();;mostrarMensaje(pais,ciudad,pueblo);});

        findViewById(R.id.cb1).setOnClickListener(view -> asignaEstilo( findViewById(R.id.cb1),findViewById(R.id.cb2)));
        findViewById(R.id.cb2).setOnClickListener(view -> asignaEstilo( findViewById(R.id.cb1),findViewById(R.id.cb2)));
        ((RatingBar)findViewById(R.id.rb)).setOnRatingBarChangeListener((ratingBar, v, b) -> cambiaColor(v));
        findViewById(R.id.swc).setOnClickListener(this::asignaModo);

    }

    private void asignaPais(int pais){

        ArrayAdapter<CharSequence> adapter;
        int idArray;
        if(pais == R.id.rbpais1){
            idArray = R.array.rbEspanna;
        } else if (pais == R.id.rbpais2) {
            idArray = R.array.rbAlemania;
        }
        else{
            idArray = R.array.rbItalia;
       }
        adapter = ArrayAdapter.createFromResource(this,idArray, android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) findViewById(R.id.spCiudades)).setAdapter(adapter);
    }
    private void asignaCiudades(){

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Madrid")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosMadrid1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosMadrid2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosMadrid3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosMadrid4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosMadrid5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosMadrid6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Barcelona")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosBarcelona1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosBarcelona2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosBarcelona3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosBarcelona4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosBarcelona5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosBarcelona6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Sevilla")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosSevilla1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosSevilla2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosSevilla3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosSevilla4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosSevilla5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosSevilla6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Baviera")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosBaviera1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosBaviera2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosBaviera3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosBaviera4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosBaviera5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosBaviera6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Hesse")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosHesse1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosHesse2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosHesse3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosHesse4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosHesse5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosHesse6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Sajonia")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosSajonia1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosSajonia2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosSajonia3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosSajonia4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosSajonia5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosSajonia6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Roma")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosRoma1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosRoma2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosRoma3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosRoma4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosRoma5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosRoma6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Milan")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosMilan1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosMilan2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosMilan3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosMilan4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosMilan5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosMilan6);
        }

        if (((Spinner)findViewById(R.id.spCiudades)).getSelectedItem().equals("Florencia")){
            ((RadioButton)findViewById(R.id.rbProvincia1)).setText(R.string.rbPueblosFlorencia1);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setText(R.string.rbPueblosFlorencia2);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setText(R.string.rbPueblosFlorencia3);
            ((RadioButton)findViewById(R.id.rbProvincia4)).setText(R.string.rbPueblosFlorencia4);
            ((RadioButton)findViewById(R.id.rbProvincia5)).setText(R.string.rbPueblosFlorencia5);
            ((RadioButton)findViewById(R.id.rbProvicia6)).setText(R.string.rbPueblosFlorencia6);
        }

    }
    private void excluyeGrupo(int n){
        switch (n){
            case 1:((RadioButton)findViewById(R.id.rbProvincia1)).setChecked(false);
            ((RadioButton)findViewById(R.id.rbProvincia2)).setChecked(false);
            ((RadioButton)findViewById(R.id.rbProvincia3)).setChecked(false);
            break;
            case 2:((RadioButton)findViewById(R.id.rbProvincia4)).setChecked(false);
                ((RadioButton)findViewById(R.id.rbProvincia5)).setChecked(false);
                ((RadioButton)findViewById(R.id.rbProvicia6)).setChecked(false);
                break;
        }
    }
    private void mostrarMensaje(String city,String provi,String villa){
        ((TextView) findViewById(R.id.lbl_info)).setText(city +","+provi+","+villa);
    }
    private void cambiaColor(float puntuacion){
        if(puntuacion>=0 && puntuacion<=2){
            ((TextView) findViewById(R.id.lbl_info)).setTextColor(getResources().getColor(R.color.malaPuntuacion));
        }
        else if(puntuacion>2 && puntuacion<4){
            ((TextView) findViewById(R.id.lbl_info)).setTextColor(getResources().getColor(R.color.mediaPuntuacion));
        }
        else {
            ((TextView) findViewById(R.id.lbl_info)).setTextColor(getResources().getColor(R.color.buenaPuntuacion));
        }
    }
    private void asignaEstilo(View view,View view2){
        CheckBox cb = (CheckBox) view;
        CheckBox cb2 = (CheckBox) view2;
        if (cb.isChecked() && cb2.isChecked()){
            ((TextView)findViewById(R.id.lbl_info)).setTypeface(null,Typeface.BOLD_ITALIC);
        }
        else if((cb.isChecked() && !cb2.isChecked())){
            ((TextView)findViewById(R.id.lbl_info)).setTypeface(null,Typeface.BOLD);
        } else if ((!cb.isChecked() && cb2.isChecked())) {
            ((TextView)findViewById(R.id.lbl_info)).setTypeface(null,Typeface.ITALIC);
        }
        else{
            ((TextView)findViewById(R.id.lbl_info)).setTypeface(null,Typeface.NORMAL);
        }
    }
    private void asignaModo(View view){
        SwitchCompat sw = (SwitchCompat) view;
        if(sw.isChecked()){
            modoObscuro();
        }
        else{
            modoNoObscuro();
        }
    }
    private void modoObscuro(){
        findViewById(R.id.LayoutPrincipal).setBackgroundColor(getColor(R.color.fondoNegro));
        ((TextView)findViewById(R.id.lbl_Paises)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbpais1)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbpais2)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbpais3)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbProvincia1)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbProvincia2)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbProvincia3)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbProvincia4)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbProvincia5)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.rbProvicia6)).setTextColor(getColor(R.color.letrasBlancas));
        ((CheckBox)findViewById(R.id.cb1)).setTextColor(getColor(R.color.letrasBlancas));
        ((CheckBox)findViewById(R.id.cb2)).setTextColor(getColor(R.color.letrasBlancas));
        ((TextView)findViewById(R.id.lbl_info2)).setTextColor(getColor(R.color.letrasBlancas));
        ((SwitchCompat)findViewById(R.id.swc)).setTextColor(getColor(R.color.letrasBlancas));
        Toast.makeText(this, "Se puso el modo obscuro", Toast.LENGTH_LONG).show();
    }
    private void modoNoObscuro(){
        findViewById(R.id.LayoutPrincipal).setBackgroundColor(getColor(R.color.fondoBlanco));
        ((TextView)findViewById(R.id.lbl_Paises)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbpais1)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbpais2)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbpais3)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbProvincia1)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbProvincia2)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbProvincia3)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbProvincia4)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbProvincia5)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.rbProvicia6)).setTextColor(getColor(R.color.letrasNegras));
        ((CheckBox)findViewById(R.id.cb1)).setTextColor(getColor(R.color.letrasNegras));
        ((CheckBox)findViewById(R.id.cb2)).setTextColor(getColor(R.color.letrasNegras));
        ((TextView)findViewById(R.id.lbl_info2)).setTextColor(getColor(R.color.letrasNegras));
        ((SwitchCompat)findViewById(R.id.swc)).setTextColor(getColor(R.color.letrasNegras));
        Toast.makeText(this, "Se puso el modo no obscuro", Toast.LENGTH_LONG).show();
    }

}