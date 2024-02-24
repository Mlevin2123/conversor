package com.ugb.conversor;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    Spinner spnDeArea, spnAArea;
    EditText txtCantidadArea;
    Button btnConvertirArea;
    Conversores miobj = new Conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1Spec = tabHost.newTabSpec("Tab One");
        tab1Spec.setContent(R.id.consumo);
        tab1Spec.setIndicator("Tab One");
        tabHost.addTab(tab1Spec);

        TabHost.TabSpec tab2Spec = tabHost.newTabSpec("Tab Two");
        tab2Spec.setContent(R.id.tabarea);
        tab2Spec.setIndicator("Tab Two");
        tabHost.addTab(tab2Spec);

        spnDeArea = findViewById(R.id.spnDeArea);
        spnAArea = findViewById(R.id.spnAArea);
        txtCantidadArea = findViewById(R.id.txtCantidadArea); // Asignar EditText
        btnConvertirArea = findViewById(R.id.btnConvertirArea);

        btnConvertirArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int de = spnDeArea.getSelectedItemPosition();
                int a = spnAArea.getSelectedItemPosition();
                double cantidad = Double.parseDouble(txtCantidadArea.getText().toString()); // Utilizar getText()
                double resp = miobj.convertir(de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta: " + resp, Toast.LENGTH_LONG).show();
            }
        });
    }
}

class Conversores {
    double[][] valores = {
            // a. Pie Cuadrado   b. Vara Cuadrada  c. Yarda Cuadrada  d. Metro Cuadrado  e. Tareas  f. Manzana  g. Hectárea
            {1, 0.00694444, 0.111111, 0.092903, 0.0001, 0.000698896, 0.000070}, // a. Pie Cuadrado
            {144, 1, 16, 13.1168, 0.00000092, 0.0000645161, 0.00000645161}, // b. Vara Cuadrada
            {9, 0.0625, 1, 0.836127, 0.00000929, 0.000645161, 0.0000645161}, // c. Yarda Cuadrada
            {10.7639, 0.092903, 1.19599, 1, 0.0001, 0.00698896, 0.000698896}, // d. Metro Cuadrado
            {10000, 69.8896, 1076.39, 10000, 1, 7000, 0.7}, // e. Tareas
            {14400, 10000, 155000, 144000, 14, 1, 0.999999}, // f. Manzana
            {142857.142857, 99225.225, 1532816.04656, 1428571.42857, 142.857143, 10.0007143, 1} // g. Hectárea
    };

    public double convertir(int de, int a, double cantidad) {
        return valores[a][de] * cantidad;
    }
}
