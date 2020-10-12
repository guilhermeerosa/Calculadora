package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String firstNumber = "";
    private String secondNumber = "";
    private String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.box_display);
    }

    public void onClickBtn0(View v) {
        updateNumber("0");
        showDisplay("0");
    }

    public void onClickBtn1(View v) {
        updateNumber("1");
        showDisplay("1");
    }

    public void onClickBtn2(View v) {
        updateNumber("2");
        showDisplay("2");
    }

    public void onClickBtn3(View v) {
        updateNumber("3");
        showDisplay("3");
    }

    public void onClickBtn4(View v) {
        updateNumber("4");
        showDisplay("4");
    }

    public void onClickBtn5(View v) {
        updateNumber("5");
        showDisplay("5");
    }

    public void onClickBtn6(View v) {
        updateNumber("6");
        showDisplay("6");
    }

    public void onClickBtn7(View v) {
        updateNumber("7");
        showDisplay("7");
    }

    public void onClickBtn8(View v) {
        updateNumber("8");
        showDisplay("8");
    }

    public void onClickBtn9(View v) {
        updateNumber("9");
        showDisplay("9");
    }

    public void onClickBtnDot(View v) {
        updateNumber(".");
        showDisplay(",");
    }

    public void onClickBtnPlus(View v) {
        if (firstNumber.isEmpty()) {
            notExistNumber();
        } else {
            if (operation.isEmpty()) {
                operation = "+";
                showDisplay("+");
            }
        }
    }

    public void onClickBtnMinus(View v) {
        if (firstNumber.isEmpty()) {
            notExistNumber();
        } else {
            if (operation.isEmpty()) {
                operation = "-";
                showDisplay("-");
            }
        }
    }

    public void onClickBtnTimes(View v) {
        if (firstNumber.isEmpty()) {
            notExistNumber();
        } else {
            if (operation.isEmpty()) {
                operation = "x";
                showDisplay("x");
            }
        }
    }

    public void onClickBtnDiv(View v) {
        if (firstNumber.isEmpty()) {
            notExistNumber();
        } else {
            if (operation.isEmpty()) {
                operation = "÷";
                showDisplay("÷");
            }
        }
    }

    public void onClickBtnClearDisplay(View v) {
        clearDisplay();
    }

    @SuppressLint("SetTextI18n")
    public void onClickBtnEqual(View v) {
        if (secondNumber.isEmpty()) {
            notExistNumber();
        } else {
            double number1 = Double.parseDouble(firstNumber);
            double number2 = Double.parseDouble(secondNumber);
            switch (operation) {
                case "+": {
                    double result = number1 + number2;
                    clearDisplay();
                    String valor = showResult(result);
                    display.setText(valor);
                    firstNumber = valor;
                    break;
                }
                case "-": {
                    double result = number1 - number2;
                    clearDisplay();
                    String valor = showResult(result);
                    display.setText(valor);
                    firstNumber = valor;
                    break;
                }
                case "x": {
                    double result = number1 * number2;
                    clearDisplay();
                    String valor = showResult(result);
                    display.setText(valor);
                    firstNumber = valor;
                    break;
                }
                case "÷": {
                    if (number2 != 0) {
                        double result = number1 / number2;
                        clearDisplay();
                        String valor = showResult(result);
                        display.setText(valor);
                        firstNumber = valor;
                        break;
                    } else {
                        Toast.makeText(MainActivity.this, "Não é possivel dividir por 0", Toast.LENGTH_LONG).show();
                        String number1div = showResult(number1);
                        display.setText(number1div + "÷");
                        secondNumber = "";
                    }
                }
            }
        }
    }

    public void showDisplay(String text) {
        String textDisplay = display.getText().toString();
        textDisplay = textDisplay + text;
        display.setText(textDisplay);
    }

    public void updateNumber(String number) {
        if (operation.isEmpty()) {
            firstNumber = firstNumber + number;
        } else {
            secondNumber = secondNumber + number;
        }
    }

    public void notExistNumber() {
            Toast.makeText(MainActivity.this, "Atribua um valor!", Toast.LENGTH_LONG).show();
    }

    public void clearDisplay() {
        display.setText(String.valueOf(""));
        firstNumber = "";
        secondNumber = "";
        operation = "";
    }

    public String showResult(double result) {
        return String.valueOf(result).replaceAll("(\\.?0+|\\.)$", "");
    }

}