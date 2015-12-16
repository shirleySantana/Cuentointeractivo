package com.example.profesoresi.cuentointeractivo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class StoryActivity extends ActionBarActivity {
    private Story cuento = new Story();
    private Page paginaActual;
    private ImageView imageView;
    private TextView textView;
    private Button choice1;
    private Button choice2;
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        imageView=(ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        choice1 = (Button) findViewById(R.id.botonPrimero);
        choice2 = (Button) findViewById(R.id.botonSegundo);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        //Toast.makeText(this, nombre, Toast.LENGTH_LONG).show();
        cargarPagina(0);
    }
    private void cargarPagina (int choice){
        paginaActual = cuento.getPage(choice);
        Drawable drawable = getResources().getDrawable(paginaActual.getImageId());
        imageView.setImageDrawable(drawable);
        String textConNombre = String.format(paginaActual.getText(), nombre);
        textView.setText(textConNombre);
        if (paginaActual.isFinal()){
            choice1.setVisibility(View.INVISIBLE);
            choice2.setText("Play again");
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            choice1.setText(paginaActual.getChoice1().getText());
            choice2.setText(paginaActual.getChoice2().getText());
            choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sigPagina = paginaActual.getChoice1().getNextId();
                    cargarPagina(sigPagina);
                }
            });
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sigPagina = paginaActual.getChoice2().getNextId();
                    cargarPagina(sigPagina);
                }
            });
        }
    }

}
