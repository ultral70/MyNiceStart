package uem.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    ImageView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fondo = findViewById(R.id.fondo);

        Glide.with(this)
                /*
                El load puede cargar toddoo tipo de imágenes, desde enlaces hasta imágenes físicas
                 */
                .load(R.drawable.imagen)
                .circleCrop()
                .into(fondo);

    }


    public void cambiarVentana2(View view) {

            Intent i = new Intent(this, MainActivity2.class);

            startActivity(i);

    }
}