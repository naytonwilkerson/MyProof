package com.example.naytonwilkerson.myproof;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

public class MainActivity extends Activity {

    private EditText visor;
    private Integer operando1, operando2;
    private String operador, resposta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (EditText) findViewById(R.id.visor);
    }


    public void operacao2(View botao) {
        visor.setText("");
    }

    public void operacao(View botao) {
        switch (botao.getId()) {
            case R.id.b0:
            case R.id.b1:
            case R.id.b2:
            case R.id.b3:
            case R.id.b4:
            case R.id.b5:
            case R.id.b6:
            case R.id.b7:
            case R.id.b8:
            case R.id.b9:
                visor.setText(visor.getText().append(((Button) botao).getText()));
                break;
            case R.id.divisao:
            case R.id.multiplcação:
            case R.id.soma:
            case R.id.subtração:
                operando1 = Integer.parseInt((visor.getText().toString()));
                operador = ((Button) botao).getText().toString();
                visor.setText("");
                break;
            case R.id.igual:
                operando2 = Integer.parseInt((visor.getText().toString()));
                NumberFormat resultado = NumberFormat.getNumberInstance();
                switch (operador) {
                    case "+":
                        resposta = resultado.format(operando1 + operando2);
                        visor.setText(resultado.format(operando1 + operando2));
                        break;
                    case "-":
                        resposta = resultado.format(operando1 - operando2);
                        visor.setText(resultado.format(operando1 - operando2));
                        break;
                    case "*":
                        resposta = resultado.format(operando1 * operando2);
                        visor.setText(resultado.format(operando1 * operando2));
                        break;
                    case "/":
                        resposta = resultado.format(operando1 / operando2);
                        visor.setText(resultado.format(operando1 / operando2));
                        break;
                }
                break;
            case R.id.bM:
                visor.setText(operando1 + operador + operando2 + "=" + resposta);
                break;
        }
    }
}

