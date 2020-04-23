package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isOperate = false;
    boolean isMinus = false;
    boolean isMul = false;
    boolean isDiv = false;
    boolean isMOD = false;
    String key_savestate_result="";

    TextView result;
    int index=0;
    double firstnum = 0;
    String screenContent;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.through_linear_layout);
        final Button one = (Button)findViewById(R.id.one);
        final Button two = (Button)findViewById(R.id.two);
        final Button three = (Button)findViewById(R.id.three);
        final Button four = (Button)findViewById(R.id.four);
        final Button five = (Button)findViewById(R.id.five);
        final Button six = (Button)findViewById(R.id.six);
        final Button seven = (Button)findViewById(R.id.btn_seven);
        final Button eight = (Button)findViewById(R.id.eight);
        final Button nine = (Button)findViewById(R.id.nine);
        final Button zero = (Button)findViewById(R.id.zero);
        final Button dot = (Button)findViewById(R.id.dot);
        final Button plus = (Button)findViewById(R.id.plus);
        final Button minus = (Button)findViewById(R.id.minus);
        final Button mul = (Button)findViewById(R.id.mul);
        final Button div = (Button)findViewById(R.id.btn_div);
        final Button mod = (Button)findViewById(R.id.btn_percent);
        final Button c = (Button)findViewById(R.id.btn_C);
        final Button ce = (Button)findViewById(R.id.btn_CE);
        final Button equal = (Button)findViewById(R.id.equal);
        result = (TextView)findViewById(R.id.tv_result);
        result.setText("0");

        final View.OnClickListener calc = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final int id = v.getId();
                    switch (id) {
                        case R.id.btn_CE:
                            result.setText("0");
                            isMinus = false;
                            isMOD = false;
                            isDiv = false;
                            isMul = false;
                            isOperate = false;
                            j=0;
                            break;
                        case R.id.btn_C:
                                screenContent = result.getText().toString();
                                String n = screenContent.substring(0, screenContent.length() - 1);
                                result.setText(n);
                                break;

                        case R.id.one:
                            result.append("1");
                            break;
                        case R.id.two:
                            result.append("2");
                            break;
                        case R.id.three:
                            result.append("3");
                            break;
                        case R.id.four:
                            result.append("4");
                            break;
                        case R.id.five:
                            result.append("5");
                            break;
                        case R.id.six:
                            result.append("6");
                            break;
                        case R.id.btn_seven:
                            result.append("7");
                            break;
                        case R.id.eight:
                            result.append("8");
                            break;
                        case R.id.nine:
                            result.append("9");
                            break;
                        case R.id.zero:
                            result.append("0");
                            break;
                        case R.id.dot:
                            if(j==0) {
                                result.append(".");
                                j++;
                            }else {
                                Toast.makeText(MainActivity.this,"Dot can only pressed once",Toast.LENGTH_SHORT).show();
                            }
                            break;

                        case R.id.plus:
                            screenContent = result.getText().toString();
                            if (screenContent.isEmpty()) {
                                Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                            }else {
                                if (isOperate == true) {
                                    //Toast.makeText(MainActivity.this, "Don't", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    secnum += firstnum;
                                    result.setText(String.valueOf(secnum));
                                    j=0;
                                    isOperate = false;
                                    break;
                                } else if (isMul == true || isDiv == true || isMinus == true || isMOD == true) {
                                    //Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();
                                    //this else if is important because it automaticaly calculate the needed ans and makes us ready for new calculation
                                    //eg:2+2+ it will show 4 directly
                                    // tryed result.append("+")
                                } else {
                                    screenContent = result.getText().toString();
                                    index = screenContent.length() + 1;
                                    firstnum = Double.parseDouble(screenContent);
                                    result.append("+");
                                    j=0;
                                    isOperate = true;
                                    break;
                                }
                            }
                        case R.id.minus:
                            screenContent = result.getText().toString();
                            if (screenContent.isEmpty()) {
                                Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                            }else {
                                if (isMinus == true) {
                                    //Toast.makeText(MainActivity.this, "Don't try to be smart minus", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum - secnum;
                                    result.setText(String.valueOf(ans));
                                    isMinus = false;
                                    j=0;
                                    break;
                                } else if (isOperate == true || isMul == true || isDiv == true || isMOD == true) {
                                    //Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();
                                } else {
                                    screenContent = result.getText().toString();
                                    index = screenContent.length() + 1;
                                    firstnum = Double.parseDouble(screenContent);
                                    isMinus = true;
                                    result.append("-");
                                    j=0;
                                    break;
                                }
                            }
                        case R.id.mul:
                            screenContent = result.getText().toString();
                            if (screenContent.isEmpty()) {
                                Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                            }else {
                                if (isMul == true) {
                                    //Toast.makeText(MainActivity.this, "Don't try to be smart mul", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum * secnum;
                                    result.setText(String.valueOf(ans));
                                    isMul = false;
                                    j=0;
                                    break;
                                } else if (isOperate == true || isDiv == true || isMinus == true || isMOD == true) {
                                    //Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();
                                } else {
                                    screenContent = result.getText().toString();
                                    index = screenContent.length() + 1;
                                    firstnum = Double.parseDouble(screenContent);
                                    isMul = true;
                                    result.append("*");
                                    j=0;
                                    break;
                                }
                            }

                        case R.id.btn_div:
                            screenContent = result.getText().toString();
                            if (screenContent.isEmpty()) {
                                Toast.makeText(MainActivity.this,"EMpty",Toast.LENGTH_SHORT).show();
                            }else {
                                if (isDiv == true) {
                                    //Toast.makeText(MainActivity.this, "Don't try to be smart div", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum / secnum;
                                    result.setText(String.valueOf(ans));
                                    isDiv = false;
                                    j=0;
                                    break;
                                } else if (isOperate == true || isMul == true || isMinus == true || isMOD == true) {
                                    //Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();
                                } else {
                                    screenContent = result.getText().toString();
                                    index = screenContent.length() + 1;
                                    firstnum = Double.parseDouble(screenContent);
                                    isDiv = true;
                                    result.append("/");
                                    j=0;
                                    break;
                                }
                            }

                        case R.id.btn_percent:
                            screenContent = result.getText().toString();
                            if (screenContent.isEmpty()) {
                                Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_SHORT).show();
                            }else {
                                if (isMOD == true) {
                                    //Toast.makeText(MainActivity.this, "Can't use two operator", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum / secnum * 100;
                                    result.setText(String.valueOf(ans));
                                    isMOD = false;
                                    j=0;
                                    break;
                                } else if (isOperate == true || isMul == true || isDiv == true || isMinus == true) {
                                    //Toast.makeText(MainActivity.this, "asdf", Toast.LENGTH_SHORT).show();

                                } else {
                                    screenContent = result.getText().toString();
                                    index = screenContent.length() + 1;
                                    firstnum = Double.parseDouble(screenContent);
                                    isMOD = true;
                                    result.append("%");
                                    j=0;
                                    break;
                                }
                            }

                        case R.id.equal:
                                if (isOperate == true) {
                                    //Toast.makeText(MainActivity.this, "Pluse else", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    secnum += firstnum;
                                    result.setText(String.valueOf(secnum));
                                    isOperate = false;
                                    break;
                                } else if (isMinus == true) {
                                    //Toast.makeText(MainActivity.this, "Minus else", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum - secnum;
                                    result.setText(String.valueOf(ans));
                                    isMinus = false;
                                    break;
                                } else if (isDiv == true) {
                                    //Toast.makeText(MainActivity.this, "Div else", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum / secnum;
                                    result.setText(String.valueOf(ans));
                                    isDiv = false;
                                    break;
                                } else if (isMul == true) {
                                    //Toast.makeText(MainActivity.this, "Mul else", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum * secnum;
                                    result.setText(String.valueOf(ans));
                                    isMul = false;
                                    break;
                                } else if (isMOD == true) {
                                    //Toast.makeText(MainActivity.this, " Mod else", Toast.LENGTH_SHORT).show();
                                    screenContent = result.getText().toString();
                                    Double secnum = Double.parseDouble(screenContent.substring(index, screenContent.length()));
                                    Double ans = firstnum / secnum * 100;
                                    result.setText(String.valueOf(ans));
                                    isMOD = false;
                                    break;
                                } else {
                                    Toast.makeText(MainActivity.this, "Please Enter Right Number", Toast.LENGTH_SHORT).show();
                                }


                    }
                }catch (Exception e){
                    //Toast.makeText(MainActivity.this,"BIG ERRor",Toast.LENGTH_SHORT).show();
                    switch (v.getId()){
                        case R.id.plus:
                            Toast.makeText(MainActivity.this,"Don't Pluse press twice",Toast.LENGTH_SHORT).show();
                            screenContent = result.getText().toString();
                            String cutplussign = screenContent.substring(0, screenContent.length() - 1);
                            firstnum = Double.parseDouble(cutplussign);
                            index = cutplussign.length() + 1;
                            break;
                        case R.id.minus:
                            screenContent = result.getText().toString();
                            String cutminusign = screenContent.substring(0, screenContent.length() - 1);
                            firstnum = Double.parseDouble(cutminusign);
                            index = cutminusign.length() + 1;
                            Toast.makeText(MainActivity.this,"Don't Minus press twice",Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.btn_div:
                            Toast.makeText(MainActivity.this,"Don't Divide press twice",Toast.LENGTH_SHORT).show();
                            screenContent = result.getText().toString();
                            String cutdivsign = screenContent.substring(0, screenContent.length() - 1);
                            firstnum = Double.parseDouble(cutdivsign);
                            index = cutdivsign.length() + 1;
                            break;
                        case R.id.mul:
                            Toast.makeText(MainActivity.this,"Don't Mul press twice",Toast.LENGTH_SHORT).show();
                            screenContent = result.getText().toString();
                            String cutmulsign = screenContent.substring(0, screenContent.length() - 1);
                            firstnum = Double.parseDouble(cutmulsign);
                            index = cutmulsign.length() + 1;
                            break;
                        case R.id.btn_percent:
                            Toast.makeText(MainActivity.this,"Don't  Mod press twice",Toast.LENGTH_SHORT).show();
                            screenContent = result.getText().toString();
                            String cutmodsign = screenContent.substring(0, screenContent.length() - 1);
                            firstnum = Double.parseDouble(cutmodsign);
                            index = cutmodsign.length() + 1;
                            break;
                        case R.id.dot:
                            Toast.makeText(MainActivity.this,"Don't  Dot press twice",Toast.LENGTH_SHORT).show();
                        default:
                            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        };

        one.setOnClickListener(calc);
        two.setOnClickListener(calc);
        three.setOnClickListener(calc);
        four.setOnClickListener(calc);
        five.setOnClickListener(calc);
        six.setOnClickListener(calc);
        seven.setOnClickListener(calc);
        eight.setOnClickListener(calc);
        nine.setOnClickListener(calc);
        zero.setOnClickListener(calc);
        dot.setOnClickListener(calc);
        plus.setOnClickListener(calc);
        minus.setOnClickListener(calc);
        mul.setOnClickListener(calc);
        div.setOnClickListener(calc);
        mod.setOnClickListener(calc);
        c.setOnClickListener(calc);
        ce.setOnClickListener(calc);
        equal.setOnClickListener(calc);

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(key_savestate_result,result.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
