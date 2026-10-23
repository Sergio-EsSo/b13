package com.example.b13calendarpicker

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var calendario: CalendarView;
    private lateinit var fechaSeleccionada: TextView;
    private lateinit var fechaBuscada: TextView;
    private lateinit var buscar: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //referencias por id
        calendario = findViewById(R.id.calendario);
        fechaSeleccionada = findViewById(R.id.fechaMostrar);
        fechaBuscada = findViewById(R.id.textoDate);
        buscar = findViewById(R.id.btnSetDate);

        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val fechaSeleccionadaStr = "$dayOfMonth/${month+1}/$year";
            fechaSeleccionada.setText(fechaSeleccionadaStr);
        }

        buscar.setOnClickListener {
            val fechaBuscadaStr = fechaBuscada.text.toString();
            val partes = fechaBuscadaStr.split("/")
            if(partes.size==3){
                val dia = partes[0].toInt();
                val mes = partes[1].toInt()-1; //en java los meses van de 0 a 11
                val anio = partes[2].toInt();
            }
            //con dia mes y anio seteo el calendario

            val fechaBuscada = SimpleDateFormat("dd/MM/yyyy", locale.getDefault)
        }
    }
}