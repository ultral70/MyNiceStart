package uem.dam.mynicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Ventana de bienvenida con una animación y un scrim
 * @author Jorge
 * @see LoginActivity
 */

/*
Con el código de arriba, al crear un javaDoc en tools, generate javaDoc
se crea un archivo javaDoc en la que se ven todos los comentarios que se
han realizado en todo el proyecto, utilizando el / * *
 */

public class SplashActivity extends AppCompatActivity {

    ImageView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        openApp(true);

        ImageView icono = (ImageView) findViewById(R.id.imageView2);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        icono.startAnimation(animacion);
        /*
        Este código, el de arriba, se usa para añadir una animación ya creada a
        un imageview, pero se puede aplicar a cualquier elemento
         */

        fondo = findViewById(R.id.fondo);

        /*
        Con el glide creamos la imagen ajustada a un image view,
        como el image view tiene el tamaño del padre, la ventana entera,
        no habrá problemas de renderizado
        centercrop sirve para centrar la imagen en el imageview
        transition hace una transicióm,
        placeholder muestra un color si la imagen pesa mucho y tarda en cargar

         */

        Glide.with(this)
                /*
                El load puede cargar todoo tipo de imágenes, desde enlaces hasta imágenes físicas
                 */
                .load(R.drawable.cielo)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade()).placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorAccent)))
                .into(fondo);

        openApp(true);

    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

}