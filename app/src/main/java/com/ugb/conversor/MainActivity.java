package com.ugb.conversor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tbh = findViewById(R.id.tbhconversor);
        tbh.setup();

        TabHost.TabSpec tab1 = tbh.newTabSpec("LON");
        tab1.setContent(R.id.tablongitud);
        tab1.setIndicator("LONGITUD");
        tbh.addTab(tab1);

        TabHost.TabSpec tab2 = tbh.newTabSpec("ALM");
        tab2.setContent(R.id.tabalmacenamiento);
        tab2.setIndicator("ALMACENAMIENTO");
        tbh.addTab(tab2);

        TabHost.TabSpec tab3 = tbh.newTabSpec("MON");
        tab3.setContent(R.id.tabmonedas);
        tab3.setIndicator("MONEDAS");
        tbh.addTab(tab3);
    }
}
