package com.utng.tutorialKotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title="El Tutorial de Kotlin" //Esto es el titulo principal del activity

        val tema1 = Segunda("Manejo de ListView",R.drawable.list,
            "Un ListView es un componente de vista de lista " +
                    "que nos servirá para mostrar datos, " +
                    "tal como puede ser una lista de contactos, lista de productos, lista de opciones, etc."
                    ,R.drawable.listcode)//Componenete de la lista Listview
        val tema2 = Segunda("Manejo de Activities",R.drawable.activity,"Una Activity " +
                "'es un componente de la aplicación que contiene una pantalla con la que los usuarios" +
                " pueden interactuar para realizar una acción, como marcar" +
                " un número telefónico, tomar una foto, enviar un correo electrónico o ver un mapa. " +
                "A cada actividad se le asigna una ventana en la que se puede dibujar su interfaz " +
                "de usuario.",R.drawable.activitycode )//Componenete del Manejo de activities
        val tema3 = Segunda("SheredPreferences",R.drawable.shared,"Almacenamiento " +
                "interno con SharedPreferences:\n" +
                "Android ofrece diferentes opciones para que guardes los datos de tu aplicación. " +
                "La solución que elijas dependerá de tus necesidades específicas\n" +
                "SharedPreferences: Si tu aplicación no necesita almacenar muchos datos ni requiere " +
                "una estructura, sirve para almacenar datos privados de primitivas en pares clave-valor" +
                ".\n",R.drawable.sharedcode )//Componenete del SharedPreferences
        val tema4 = Segunda("Controles de Audio",R.drawable.audio,"Para implementar" +
                " audio a tu App existen diferentes formas, tanto Online o local.\n" +
                "La clase MediaPlayer se puede usar para controlar la reproducción de archivos de " +
                "audio/vídeo y transmisiones.\n",R.drawable.audiocode)//Componenete del Control de audio
        val tema5 = Segunda("SQLite",R.drawable.sqllite,"Es un motor de base de " +
                "datos SQL transaccional de código abierto, ligero, autónomo, de configuración simple " +
                "y sin servidor\n" +
                "Así mismo, por ser de dominio público es gratuito tanto para fines privados como " +
                "para comerciales\n" +
                "SQLite cumple con las características ACID (atomicidad, consistencia, aislamiento y " +
                "durabilidad), forma parte integral de las aplicaciones basadas en el cliente, SQLite " +
                "utiliza una sintaxis SQL dinámica y realiza múltiples tareas para hacer lecturas y " +
                "escrituras al mismo tiempo, ambas (lectura y escritura) se efectúan directamente en " +
                "los archivos de disco ordinarios.\n",R.drawable.sqlcode )//Componenete de SQLite


        val listaTemas = listOf(tema1, tema2,tema3,tema4,tema5)//Toma los valores para la lista

        val adapter = SegundaAdapter(this, listaTemas)//Adaptador de la lista

        lista.adapter = adapter//Establece el adaptador a la variable adaptador de la lista

        lista.setOnItemClickListener { parent, view, position, id ->//Llama al adaptador de la lista al accionar el botón
            val intent = Intent(this, SegundaActivity::class.java)//Hace el intent al segundo activity
            intent.putExtra("segunda", listaTemas[position])//Manda la informacion al otro activity
            startActivity(intent)//Inicia la actividad
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {//Codigo del menú lateral
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Selcción del item dentro del Menú
        var mensaje: String=""
        when (item.itemId) {
            R.id.itmAcerca -> {//Se toman los valores para el Acerca de del menú
                mensaje="El Tutorial de Kotlin.\n"+
                "Desarrollado por \nCarlos Antonio Suárez Olvera.\n"+"GDS0143\n"+"Desarrollo de Software Multiplatafomra\n"+"Diseño de Apps"
            }
            R.id.itmObjetivo -> {//Se toman los valores para el Objetivo de de la aplicación del menú
                mensaje= "El objetivo de este tutorial es: \nMostrar el funcionamiento de diferentes temas en Kotlin\n"+
                        "con diferentes componentes para un mejor aprendizaje"

            }
            R.id.itmSalir -> {//Salir
                System.exit(0)
            }

        }
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()//Widget para la salida del mensaje
        return  super.onOptionsItemSelected(item)
    }
}
