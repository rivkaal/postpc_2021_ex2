package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }

    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    "@+id/textViewCalculatorOutput"
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */

    TextView eqButton = findViewById(R.id.buttonEquals);
    TextView minusButton = findViewById(R.id.buttonMinus);
    TextView plusButton = findViewById(R.id.buttonPlus);
    TextView button0 = findViewById(R.id.button0);
    TextView button1 = findViewById(R.id.button1);
    TextView button2 = findViewById(R.id.button2);
    TextView button3 = findViewById(R.id.button3);
    TextView button4 = findViewById(R.id.button4);
    TextView button5 = findViewById(R.id.button5);
    TextView button6 = findViewById(R.id.button6);
    TextView button7 = findViewById(R.id.button7);
    TextView button8 = findViewById(R.id.button8);
    TextView button9 = findViewById(R.id.button9);
    TextView buttonClear = findViewById(R.id.buttonClear);
    View buttonBack = findViewById(R.id.buttonBackSpace);
    TextView output = findViewById(R.id.textViewCalculatorOutput);
    output.setText(calculator.output());

    eqButton.setOnClickListener(v -> {
      calculator.insertEquals();
      output.setText(calculator.output());
    });
    button0.setOnClickListener(v -> {
      calculator.insertDigit(0);
      output.setText(calculator.output());
    });
    button1.setOnClickListener(v -> {
      calculator.insertDigit(1);
      output.setText(calculator.output());
    });
    button2.setOnClickListener(v -> {
      calculator.insertDigit(2);
      output.setText(calculator.output());
    });
    button3.setOnClickListener(v -> {
      calculator.insertDigit(3);
      output.setText(calculator.output());
    });
    button4.setOnClickListener(v -> {
      calculator.insertDigit(4);
      output.setText(calculator.output());
    });
    button5.setOnClickListener(v -> {
      calculator.insertDigit(5);
      output.setText(calculator.output());
    });
    button6.setOnClickListener(v -> {
      calculator.insertDigit(6);
      output.setText(calculator.output());
    });
    button7.setOnClickListener(v -> {
      calculator.insertDigit(7);
      output.setText(calculator.output());
    });
    button8.setOnClickListener(v -> {
      calculator.insertDigit(8);
      output.setText(calculator.output());
    });
    button9.setOnClickListener(v -> {
      calculator.insertDigit(9);
      output.setText(calculator.output());
    });
    minusButton.setOnClickListener(v -> {
      calculator.insertMinus();
      output.setText(calculator.output());
    });
    plusButton.setOnClickListener(v -> {
      calculator.insertPlus();
      output.setText(calculator.output());
    });
    buttonBack.setOnClickListener(v -> {
      calculator.deleteLast();
      output.setText(calculator.output());
    });
    buttonClear.setOnClickListener(v -> {
      calculator.clear();
      output.setText(calculator.output());
    });

  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
    outState.putSerializable("calculator", calculator.saveState());
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
    Serializable state = savedInstanceState.getSerializable("calculator");
    this.calculator.loadState(state);
    TextView output = findViewById(R.id.textViewCalculatorOutput);
    output.setText(calculator.output());

  }
}