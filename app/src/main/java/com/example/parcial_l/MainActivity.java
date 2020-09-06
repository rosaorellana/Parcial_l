package com.example.parcial_l;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TabHost tbhconversores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbhconversores = (TabHost) findViewById(R.id.tbhconversores);
        tbhconversores.setup();

        tbhconversores.addTab(tbhconversores.newTabSpec("D").setContent(R.id.universal).setIndicator("Universal"));
        tbhconversores.addTab(tbhconversores.newTabSpec("A").setContent(R.id.area).setIndicator("Area"));

    }
    public void Calcular1(View v){
        try {
            TextView tempval = (TextView) findViewById(R.id.txtnum2);

            double cant = Double.parseDouble(tempval.getText().toString());
            Spinner spn;
            double valores[][] = {
                    new double[]{1,9,3,10.763910417,6768.34687,75820.984975,107.639},
            };
            int de = 0, a = 0;
            double resp = 0;
            switch (tbhconversores.getCurrentTabTag()) {
                case "A":

                    spn = (Spinner) findViewById(R.id.optoperaciones);

                    de = spn.getSelectedItemPosition();
                    spn = (Spinner) findViewById(R.id.optoperaciones1);
                    a = spn.getSelectedItemPosition();
                    resp = cant * valores[0][a] / valores[0][de];
                    break;

            }
            tempval = (TextView) findViewById(R.id.lblRespuesta);
            tempval.setText("respuesta: " + resp);


        }catch (Exception ex){
            ex.getMessage();
        }
    }

}