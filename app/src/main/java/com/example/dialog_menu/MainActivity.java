package com.example.dialog_menu;

import static com.example.dialog_menu.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button bt1, bt2, bt3, bt4, bt5;

    // Método llamado cuando se crea la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Establece el layout de la actividad
        relacionarVistas(); // Llama al método para relacionar las vistas de la interfaz de usuario con las variables
    }

    // Método llamado para crear el menú de opciones en la barra de acciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el archivo de menú especificado en el objeto MenuInflater
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); // Infla el menú desde el archivo XML menu.xml
        return true; // Devuelve verdadero para indicar que se ha creado correctamente el menú de opciones

    }
    public void relacionarVistas() {
        // Busca los botones por su ID en el diseño XML y los asigna a los objetos Button
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        // Configura el OnClickListener para cada botón para manejar los clics en ellos
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
    }


    // Método para relacionar las vistas de los botones en el diseño XML con los objetos Button en Java

    // Método para manejar los clics en los botones
    @Override
    public void onClick(View v) {
        // Determina qué botón se ha presionado usando el ID de la vista
        if (v == bt1) {
            showDialog(0);
        }

        if (v == bt2) {
            showDialog(1);
        }

        if (v == bt3) {
            // Crea un nuevo diálogo usando AlertDialog.Builder para mostrar un mensaje
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setMessage("Hola mundo")
                    .setCancelable(false) // No permite cerrar el diálogo presionando fuera de él
                    .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Muestra un mensaje si se presiona el botón "SI"
                            Toast.makeText(getApplicationContext(), "dialogo moderno", Toast.LENGTH_SHORT).show();
                        }
                    });
            // Configura el botón "NO" en el diálogo
            dialogo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Muestra un mensaje si se presiona el botón "NO"
                    Toast.makeText(getApplicationContext(), "negativo", Toast.LENGTH_SHORT).show();
                }
            });
            // Configura el botón "NEUTRAL" en el diálogo
            dialogo.setNeutralButton("NEUTRAL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Muestra un mensaje si se presiona el botón "NEUTRAL"
                    Toast.makeText(getApplicationContext(), "neutral", Toast.LENGTH_SHORT).show();
                }
            });
            // Muestra el diálogo
            dialogo.show();
        }
        if (v == bt4) {
            AlertDialog.Builder dialogo4 = new AlertDialog.Builder(this);
            dialogo4.setMessage("hola")
                    .setTitle("TESCHA") // Título del diálogo
                    .setIcon(R.mipmap.ic_launcher) // Icono del diálogo
                    .show(); // Muestra el diálogo
        }
        if (v == bt5) {
            // Define una lista de elementos para mostrar en el diálogo
            CharSequence[] items = {"México", "Brasil", "Perú"};
            Dialog dialogoPrincipal = null;
            // Crea un nuevo diálogo usando AlertDialog.Builder para mostrar una lista de elementos
            AlertDialog.Builder dialogo5 = new AlertDialog.Builder(this);
            dialogo5.setTitle("Lista de elementos"); // Título del diálogo
            // Configura los elementos de la lista y su comportamiento al hacer clic en cada uno
            dialogo5.setItems(items, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Muestra un mensaje según el elemento seleccionado en la lista
                    if (which == 0) {
                        Toast.makeText(getApplicationContext(), "Mèxico", Toast.LENGTH_SHORT).show();
                    } else if (which == 1) {
                        Toast.makeText(getApplicationContext(), "Brasil", Toast.LENGTH_SHORT).show();
                    } else if (which == 2) {
                        Toast.makeText(getApplicationContext(), "Perú", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            // Crea el diálogo
            dialogoPrincipal = dialogo5.create();
            // Muestra el diálogo
            dialogoPrincipal.show();
        }
    }
        @Override
        protected Dialog onCreateDialog (int id){
            Dialog dialogo = null;

            if (id == 0) {
                AlertDialog.Builder objeto = new AlertDialog.Builder(this);
                objeto.setMessage("BIENVENIDO AL CURSO 2020");
                objeto.setTitle("TESCHA");
                objeto.setIcon(R.mipmap.ic_launcher);
                objeto.setPositiveButton("Boton", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "hola",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialogo = objeto.create();

            }

            return dialogo;
        }
    }

