package com.example.reproductormusicaparcial_i;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer reproductor;
    private ImageView imgPerfil, imgPlay, imgPause, imgStop, img1, img2, img3, img4, img5;
    private TextView titulo, cantante, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CAPTURA DE COMPONENTES
        imgPerfil = (ImageView) findViewById(R.id.imgvPerfil);
        imgPlay = (ImageView) findViewById(R.id.IvPlay);
        imgPause = (ImageView) findViewById(R.id.IvPause);
        imgStop = (ImageView) findViewById(R.id.IvStop);

        img1 = (ImageView) findViewById(R.id.imgv1);
        img2 = (ImageView) findViewById(R.id.imgv2);
        img3 = (ImageView) findViewById(R.id.imgv3);
        img4 = (ImageView) findViewById(R.id.imgv4);
        img5 = (ImageView) findViewById(R.id.imgv5);

        titulo = (TextView) findViewById(R.id.tvTituloCancion);
        cantante = (TextView) findViewById(R.id.tvCantante);
        descripcion = (TextView) findViewById(R.id.tvDescripcionCancion);

        //Animacion de img
        animacion();

        //EventosListener
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.dnd);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img1);
                titulo.setText("Modo DND");
                cantante.setText("Xavi, Tony Aguirre");
                descripcion.setText("Xavi, Tony Aguirre - Modo DND");
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.nena);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img2);
                titulo.setText("Nena Ven");
                cantante.setText("Tornillo");
                descripcion.setText("Tornillo - Nena Ven");
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.slim);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img3);
                titulo.setText("The Real Slim Shady");
                cantante.setText("Eminem");
                descripcion.setText("Eminem - The Real Slim Shady");
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.epico);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img4);
                titulo.setText("Epico");
                cantante.setText("Canserbero");
                descripcion.setText("Canserbero - Epico");
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.tocame);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img5);
                titulo.setText("Tocame");
                cantante.setText("Santa Grifa");
                descripcion.setText("Santa Grifa - Tocame");
            }
        });
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.start();
                    imgStop.setVisibility(View.VISIBLE);
                    imgPause.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.seekTo(000);
                    reproductor.pause();
                    imgStop.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.pause();
                    imgPause.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void animacion(){
        //Animación de rotación
        RotateAnimation rotateAnimation = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        //Configurar la animación
        rotateAnimation.setInterpolator(new LinearInterpolator());
        //Duración en milisegundos
        rotateAnimation.setDuration(8000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);

        //Iniciar  animación
        imgPerfil.startAnimation(rotateAnimation);
    }
}