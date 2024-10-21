package br.edu.fateczl.atividade06_01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.atividade06_01.model.ProfessorHorista;
import br.edu.fateczl.atividade06_01.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {
    /*
     *@author: Gustavo Guimarães de Oliveira
     */

    private EditText etSalIni;
    private EditText etAnos;
    private EditText etTotalHoras;
    private EditText etValorHora;
    private TextView tvResultado;
    private RadioGroup rgProf;
    private RadioButton rbProfTitu;
    private RadioButton rbProfHor;
    private Button btnCalc;
    private ProfessorTitular profTitular;
    private ProfessorHorista profHorista;
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
        etSalIni = findViewById(R.id.etSalIni);
        etAnos = findViewById(R.id.etAnos);
        etTotalHoras = findViewById(R.id.etTotalHoras);
        etValorHora = findViewById(R.id.etValorHora);
        tvResultado = findViewById(R.id.tvResultado);
        rgProf = findViewById(R.id.rgProf);
        rbProfTitu = findViewById(R.id.rbProfTitu);
        rbProfHor = findViewById(R.id.rbProfHor);
        rbProfTitu.setChecked(true);
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        if (rbProfTitu.isChecked()){
            profTitular = new ProfessorTitular();
            calcTitular();
        } else 
        if (rbProfHor.isChecked()) {
            profHorista = new ProfessorHorista();
            calcHorista();
        }
    }

    private void calcHorista() {
        double valorHora = 0d;
        int totalHoras = 0;
        try {
            valorHora = Double.parseDouble(etValorHora.getText().toString());
            totalHoras = Integer.parseInt(etTotalHoras.getText().toString());
        }
        catch (Exception e) {
            System.err.println(e);
        }

        profHorista.setValorHoraAula(valorHora);
        profHorista.setHorasAula(totalHoras);

        double salarioHorista = profHorista.calcSalario();
        String res = String.format("Salário do Professor Horista:\nR$%.2f", salarioHorista);
        tvResultado.setText(res);
    }

    private void calcTitular() {
        double salarioInicial = 0d;
        int totalAnos = 0;

        try {
            salarioInicial = Double.parseDouble(etSalIni.getText().toString());
            totalAnos = Integer.parseInt(etAnos.getText().toString());
        } catch (Exception e) {
            System.err.println(e);
        }

        profTitular.setSalario(salarioInicial);
        profTitular.setAnosInstituicao(totalAnos);

        double salarioTitular = profTitular.calcSalario();
        String res = String.format("Salário do Professor Titular:\nR$%.2f", salarioTitular);
        tvResultado.setText(res);
    }
}