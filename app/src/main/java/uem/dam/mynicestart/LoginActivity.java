package uem.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Ventana de Login con espacios para introducir tus datos de inicio
 * de sesión
 * @author Jorge
 * @see SigninActivity
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void regitro(View view) {

        Intent i = new Intent(this, SigninActivity.class);

        startActivity(i);

    }

    public void cambiarVentana2(View view) {

        Intent i = new Intent(this, MainActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(i);

    }
}