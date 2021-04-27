package android.exercise.mini.calculator.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalculatorImpl implements SimpleCalculator {

    String out = "";
    ArrayList<Integer> digits = new ArrayList<Integer>(10);
    boolean plus  = true;

    @Override
    public String output() {
        if (digits.size() == 0) {
            return "0";
        }
        return out;
    }

    @Override
    public void insertDigit(int digit) {
        if (digit > 9 || digit < 0) {
            throw new IllegalArgumentException();
        }
        out += digit;
        if(digits.size() == 0)
        {
            digits.add(0);
        }
        if (!plus) {
            digits.set(digits.size() - 1, digits.get(digits.size() - 1) * 10 - digit);
        }
        else
        {
            digits.set(digits.size() - 1, digits.get(digits.size() - 1) * 10 + digit);
        }
    }

    @Override
    public void insertPlus() {
        if(digits.size() == 0 )
        {
            out += "0";
        }
        plus = true;
        out += "+";
        digits.add(0);
    }

    @Override
    public void insertMinus() {
        if(digits.size() == 0 )
        {
            out += "0";
        }
        plus = false;
        out += "-";
        digits.add(0);
    }

    @Override
    public void insertEquals() {
        // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
        //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
        int sum = 0;
        for (int i : digits) {
            sum += i;
        }
        out = String.valueOf(sum);
    }

    @Override
    public void deleteLast() {
        // todo: delete the last input (digit, plus or minus)
        //  e.g.
        //  if input was "12+3" and called `deleteLast()`, then delete the "3"
        //  if input was "12+" and called `deleteLast()`, then delete the "+"
        //  if no input was given, then there is nothing to do here
        if (digits.size() > 0) {
            if(out.length() == 1)
            {
                digits.remove(0);
                out = "";
                return;
            }
            char last = out.charAt(out.length() - 1);
            out = out.substring(0, out.length() - 1);

            if (last == '+' || last == '-') {
                digits.remove(digits.size() - 1);
                if(digits.get(digits.size() - 1) >= 0)
                {
                    plus = true;
                }
                else
                {
                    plus = false;
                }
            } else {
                digits.set(digits.size() - 1, digits.get(digits.size() - 1) / 10);
            }
        }
    }

    @Override
    public void clear() {
        // todo: clear everything (same as no-input was never given)
        digits.clear();
        out = "";
        plus = true;
    }

    @Override
    public Serializable saveState() {
        CalculatorState state = new CalculatorState();
        // todo: insert all data to the state, so in the future we can load from this state
        state.digits = new ArrayList<Integer>(digits);
        state.out = out;
        state.plus = plus;
        return state;
    }

    @Override
    public void loadState(Serializable prevState) {
        if (!(prevState instanceof CalculatorState)) {
            return; // ignore
        }
        CalculatorState casted = (CalculatorState) prevState;
        // todo: use the CalculatorState to load
        this.digits = new ArrayList<Integer>(casted.digits);
        this.out = casted.out;
        this.plus = casted.plus;
    }

    private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
        ArrayList<Integer> digits;
        String out;
        boolean plus;
    }
}
