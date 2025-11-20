package br.gui.aula12so;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etPrimeiro;
    private EditText etSegundo;
    private EditText etTerceiro;
    private Button  btnCalc;
    private TextView tvDelta;
    private TextView tvX1;
    private TextView tvX2;
    private TextView tvErro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etPrimeiro = findViewById(R.id.etPrimeiro);
        etPrimeiro.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etSegundo = findViewById(R.id.etSegundo);
        etSegundo.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etTerceiro = findViewById(R.id.etTerceiro);
        etTerceiro.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvDelta = findViewById(R.id.tvDelta);
        tvDelta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX1 = findViewById(R.id.tvX1);
        tvX1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX2 = findViewById(R.id.tvX2);
        tvX2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvErro = findViewById(R.id.tvErro);
        tvErro.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());

    }

    private void calc() {
        double a = Double.parseDouble(etPrimeiro.getText().toString());
        double b = Double.parseDouble(etSegundo.getText().toString());
        double c = Double.parseDouble(etTerceiro.getText().toString());

        Controller conta = new Controller();

        if (a == 0) {
            tvDelta.setText(R.string.ne);
            tvX1.setText(" ");
            tvX2.setText(" ");
            return;
        }

        double delta = conta.calculaDelta(a, b, c);
        String res = getString(R.string.delta) + " " + delta;

        if (delta < 0) {
            tvDelta.setText(R.string.ntr);
            tvX1.setText(" ");
            tvX2.setText(" ");
            return;
        }

        double x1 = conta.calculaX1(a, b, delta);
        String mX1 = getString(R.string.x1) + " " + x1;

        double x2 = conta.calculaX2(a, b, delta);
        String mX2 = getString(R.string.x2) + " " + x2;

        tvDelta.setText(res);
        tvX1.setText(mX1);
        tvX2.setText(mX2);

        etPrimeiro.setText("");
        etSegundo.setText("");
        etTerceiro.setText("");

    }

}