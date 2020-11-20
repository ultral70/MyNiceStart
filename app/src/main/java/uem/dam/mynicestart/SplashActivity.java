package uem.dam.mynicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

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