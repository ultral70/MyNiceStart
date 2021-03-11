package uem.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);

        //click event en el  FAB
        //Accede al botón FAB
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        //click event en el Hamburguer menu
        //Accede al botón del menú
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });

        //click event en el Bottom bar menu item
        //Este método accede al bootom_app_bar_menu,
        // para saber qué estás clickando en el momento
        //Accede a cada item para saberlo
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_share:
                        Toast.makeText(MainActivity2.this, "Share clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(MainActivity2.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_bookmark:
                        Toast.makeText(MainActivity2.this, "Bookmark clicked.", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }

    public void cambiarVentana2(View view) {

        Intent i = new Intent(this, MainActivity.class);

        startActivity(i);

    }

}