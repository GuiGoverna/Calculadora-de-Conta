package com.example.calculadordeconta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etConsumoTotal, etCouvertArtistico, etNumPessoas;
    private TextView tvContaTotal, tvValorPorPessoa;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etConsumoTotal = findViewById(R.id.et_consumo_total);
        etCouvertArtistico = findViewById(R.id.et_couvert_artistico);
        etNumPessoas = findViewById(R.id.et_num_pessoas);
        tvContaTotal = findViewById(R.id.tv_conta_total);
        tvValorPorPessoa = findViewById(R.id.tv_valor_por_pessoa);
        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularConta();
            }
        });
    }

    private void calcularConta() {
        double consumoTotal = Double.parseDouble(etConsumoTotal.getText().toString());
        double couvertArtistico = Double.parseDouble(etCouvertArtistico.getText().toString());
        int numPessoas = Integer.parseInt(etNumPessoas.getText().toString());

        double taxaServico = 0.1 * consumoTotal;
        double contaTotal = consumoTotal + couvertArtistico + taxaServico;
        double valorPorPessoa = contaTotal / numPessoas;

        tvContaTotal.setText(String.format("Conta Total: R$ %.2f", contaTotal));
        tvValorPorPessoa.setText(String.format("Valor por Pessoa: R$ %.2f", valorPorPessoa));
    }
}
