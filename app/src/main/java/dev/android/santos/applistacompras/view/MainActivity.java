package dev.android.santos.applistacompras.view;

import androidx.appcompat.app.AppCompatActivity;
import dev.android.santos.applistacompras.model.Compras;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dev.android.santos.applistacompras.R;

public class MainActivity extends AppCompatActivity {
    Compras compra;

    EditText editNomeProduto;
    EditText editQuantidadeDesejada;
    EditText editLocalCompra;

    Button btnLimpar;
    Button btnSalvar;
    Button btnComprar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compra = new Compras();
        compra.setNomeItem("Teclado Switch Brown");
        compra.setQtdDesejada("1");
        compra.setLocalCompra("Pichau");

        editNomeProduto = findViewById(R.id.editNomeProduto);
        editQuantidadeDesejada = findViewById(R.id.editQuantidadeDesejada);
        editLocalCompra = findViewById(R.id.editLocalCompra);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnComprar = findViewById(R.id.btnComprar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNomeProduto.setText(compra.getNomeItem());
        editQuantidadeDesejada.setText(compra.getQtdDesejada());
        editLocalCompra.setText(compra.getLocalCompra());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dados informados limpados com sucesso !", Toast.LENGTH_LONG).show();
                editNomeProduto.setText("");
                editQuantidadeDesejada.setText("");
                editLocalCompra.setText("");
            }
        });

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Produto comprado com sucesso !", Toast.LENGTH_LONG).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compra.setNomeItem(editNomeProduto.getText().toString());
                compra.setLocalCompra(editLocalCompra.getText().toString());
                compra.setQtdDesejada(editQuantidadeDesejada.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso !" + compra.toString(), Toast.LENGTH_LONG).show();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre !", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}