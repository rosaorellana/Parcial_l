package com.example.parcial_l;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

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

    public void Calcular1(View v) {
        try {
            TextView tempval = (TextView) findViewById(R.id.txtnum2);

            double cant = Double.parseDouble(tempval.getText().toString());
            Spinner spn;
            double valores[][] = {
                    new double[]{1, 9, 3, 10.763910417, 6768.34687, 75820.984975, 107.639},
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


        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    void Convertir(View v) {
        try {
            TextView tempval1 = (TextView) findViewById(R.id.txt1);
            TextView tempval2 = (TextView) findViewById(R.id.txt2);
            TextView tempval3 = (TextView) findViewById(R.id.txt3);

            int cantidad, uni1, uni2, div = 0, res = 0;

            try {
                cantidad = Integer.parseInt(tempval1.getText().toString());
            } catch (NumberFormatException e) {
                cantidad = 0;
            }

            try {
                uni1 = Integer.parseInt(tempval2.getText().toString());
            } catch (NumberFormatException e) {
                uni1 = 0;
            }

            try {
                uni2 = Integer.parseInt(tempval3.getText().toString());
            } catch (NumberFormatException e) {
                uni2 = 0;
            }

            if (tempval3.getText().toString().equals("")) {
                div = cantidad / uni1;
                res = cantidad % uni1;

                tempval3.setText(div + "/" + res);
            } else if (tempval1.getText().toString().equals("")) {

                String[] arrOfStr = tempval3.getText().toString().split("/", 2);

                div = Integer.parseInt(arrOfStr[0]) * uni1 + Integer.parseInt(arrOfStr[1]);


                tempval1.setText(Integer.toString(div));
            }

        } catch (Exception ex) {
            Toast toast1 = Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT);
            toast1.show();
        }
    }
}
