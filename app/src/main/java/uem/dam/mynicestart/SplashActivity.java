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
                .load("http://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
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