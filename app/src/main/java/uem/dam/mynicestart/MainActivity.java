package uem.dam.mynicestart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    ImageView fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EXPANDABLE CARD
        /*
        Este método, que viene de la implementation añadida en el gradle,
        hace que se muestre una carta expandible en el fondo del layout
         */
        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {

                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                        "Collapsed!", Toast.LENGTH_SHORT).show();

            }
        });
        //FIN EXPANDABLE CARD


        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.mySwipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


        fondo = findViewById(R.id.fondo);

        registerForContextMenu(fondo);

        Glide.with(this)
                /*
                El load puede cargar toddoo tipo de imágenes, desde enlaces hasta imágenes físicas
                 */
                .load(R.drawable.imagen)
                .circleCrop()
                .into(fondo);

    }

    public void showAlertyDialogButtonClicked(MainActivity view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        /*
        Un diálogo stándar tiene un título o icono:
        builder.setTitle("");

        Un mensaje:
        builder.setMessage("");

        y el icono:
        builder.setIcon();

        O también se puede hacer un xml a medida para el diálogo

        EL null sirve para evitar algunas excepciones al introducir un editText en el dialog
         */

        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        //Añadimos los botones
        //El botón positivo
        builder.setPositiveButton("Glide", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });

        //El botón negativo
        builder.setNegativeButton("ChatBot", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });

        builder.setNeutralButton("MotionLayout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        /*
        Este método invoca a la creación de un objeto donde, en el constructor, se aplica el método onrefresh
         */

        @Override
        public void onRefresh() {

        /*
           El onrefresh muestra algo cuando se refresca la app


            OPCIÓN TOAST

          Toast toastRef = Toast.makeText(MainActivity.this, R.string.toast_refresh, Toast.LENGTH_LONG);
            toastRef.show();
            swipeLayout.setRefreshing(false);
         */



            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.lyMain);

            /*
            Creamos un snackbar para que se muestre la acción de restaurar,
            esto se puede realizar con cualquier acción

                            OPCIÓN SNACKBAR
             */

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        /*
                        Como se puede observar, un snacckbar es, fundamentalmente,
                        un toast, pero al cual se le pueden añadir acciones para
                        pulsar en ellas
                         */
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };

    public void cambiarVentana2(View view) {

            Intent i = new Intent(this, MainActivity2.class);

            startActivity(i);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "EDITING", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "DELETING", Toast.LENGTH_LONG);
                toast2.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflamos el menu, y añade los item a la action bar, si está presente.
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        /*
        Estos objetos se invocan de la clase padre, a la que sobreescriben,
        pero son métodos creados con un fin específico, nosotros solo los invocamos.

        Maneja los clicks dirigidos a los item del app bar
        La action bar manejará automáticamente si se pulsa en el botón de atrás o el de home
         */

        int id = item.getItemId();

        if (id == R.id.settings) {

            return true;

        }

        if (id == R.id.carrito) {

            Toast.makeText(this, R.string.toast_carrito, Toast.LENGTH_LONG).show();
            showAlertyDialogButtonClicked(MainActivity.this);

        }

        /*
        Utilizamos el return para devolver la clase padre, porque si no se bloquea la app y el pc

        Esta línea se utiliza por si tuviéramos un Activity con
        Fragments de forma que al devolver true
         todos los fragments tengan el mismo menú, super es una
         llamada al activity parent de todos los fragments, es decir,
         que se mantiene en el padre de todos los fragments del activity

         */
        return super.onOptionsItemSelected(item);

    }
}