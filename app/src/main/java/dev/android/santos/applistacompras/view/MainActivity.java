package dev.android.santos.applistacompras.view;

import androidx.appcompat.app.AppCompatActivity;

import dev.android.santos.applistacompras.controller.CarrinhoController;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import dev.android.santos.applistacompras.R;
import dev.android.santos.applistacompras.controller.ComprasController;
import dev.android.santos.applistacompras.model.Compras;

public class MainActivity extends AppCompatActivity {
    //Instanciação de Variaveis
    ComprasController controller;
    CarrinhoController carrinhoController;

    Compras compra;
    List<String> listaCompras;

    EditText editNomeProduto;
    EditText editLocalCompra;

    Button btnLimpar;
    Button btnSalvar;
    Button btnComprar;
    Button btnFinalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ComprasController(MainActivity.this);
        controller.toString();

        carrinhoController = new CarrinhoController();

        listaCompras = carrinhoController.getListaCompras();

        compra = new Compras();
        controller.procurar(compra);

        editNomeProduto = findViewById(R.id.editNomeProduto);
        editLocalCompra = findViewById(R.id.editLocalCompra);

        spinner = findViewById(R.id.spinnerQtdDesejada);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnComprar = findViewById(R.id.btnComprar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carrinhoController.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        editNomeProduto.setText(compra.getNomeItem());
        editLocalCompra.setText(compra.getLocalCompra());


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dados informados limpados com sucesso !", Toast.LENGTH_LONG).show();
                editNomeProduto.setText("");
                editLocalCompra.setText("");
                controller.limpar();
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

                Toast.makeText(MainActivity.this, "Dados salvos com sucesso !" + compra.toString(), Toast.LENGTH_LONG).show();
                controller.salvar(compra);
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