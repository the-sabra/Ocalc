package com.egyptiondev.ocalac;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  Button backSpace,mulbtn,minbtn,dividbtn,plusbtn,equlbtn,modbtn,acbtn,dot,n1,n2,n3,n4,n5,n6,n7,n8,n9,n0;
  TextView his,numV;
    private double first;
    private double second;
    private double res;
    private String opratore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aactivity_main);
        getSupportActionBar().hide();
        numV=findViewById(R.id.numbersV);
        his=findViewById(R.id.history);
        backSpace=findViewById(R.id.backspace);
        mulbtn=findViewById(R.id.multiply);
        minbtn=findViewById(R.id.min);
        dividbtn=findViewById(R.id.divide);
        plusbtn=findViewById(R.id.plus);
        equlbtn=findViewById(R.id.equal);
        modbtn=findViewById(R.id.mod);
        acbtn=findViewById(R.id.ac);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        n5=findViewById(R.id.n5);
        n6=findViewById(R.id.n6);
        n7=findViewById(R.id.n7);
        n8=findViewById(R.id.n8);
        n9=findViewById(R.id.n9);
        n0=findViewById(R.id.n0);
        dot=findViewById(R.id.dot);
        String opreatormul ="x";
        SpannableString op=new SpannableString(opreatormul);
        ForegroundColorSpan red=new ForegroundColorSpan(Color.RED);
        op.setSpan( red ,0,0, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"1");
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"2");
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"3");
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"4");
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"5");
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"6");
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"7");
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"8");
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"9");
            }
        });

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+"0");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numV.setText(numV.getText()+".");
            }
        });

        acbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numV!=null && his!=null){
                    first= 0;
                    numV.setText(null);
                    his.setText(null);
//                    second= Double.parseDouble(null);
                    Log.i("acbtn", "ac is Pressed");
                }
            }
        });

        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String back=null;
                if(numV.getText().length()>0){
                    StringBuilder stringBuilder=new StringBuilder(numV.getText());
                    stringBuilder.deleteCharAt(numV.getText().length()-1);
                    back=stringBuilder.toString();
                    numV.setText(back);
                }
            }
        });

        //   oprators Buttons

        modbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primary;
                if(!TextUtils.isEmpty(numV.getText().toString()) && !TextUtils.isEmpty(his.getText().toString()) ||
                        !TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())
                                && !numV.getText().toString().equals("-") ){

                    // check double dot or not


                        // if to the negative

                    if(!numV.getText().toString().equals("-") || !his.getText().toString().equals("Enter a number")) {
                        // check double dot or not
                        if ( numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(1)=='.' ||
                                numV.getText().length()>=4 && numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(3)=='.') {
                            // check double dot or not negative number
                            if(numV.getText().toString().charAt(2) == '.' && numV.getText().toString().charAt(3) == '.' ||
                                    numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ) {

                                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();

                                Log.i("else", "check double dot or not negative number ");
                            }
                            Log.i("else", "check double dot or not");

                        }else if(numV.getText().length()>=3 && numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ||
                                numV.getText().toString().charAt(0) == '.' && numV.getText().toString().charAt(1) =='.'){
                            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }else{
                                    first = Double.parseDouble((String) numV.getText());
                                primary = String.format("%.2f", first);
                                int t = (int) first;
                                if (t == first) {
                                    his.setText("" + (int) first + "%");
                                } else if (t < first) {
                                    his.setText("" + first + "%");
                                } else if (t > first) {
                                    his.setText("" + first + "%");
                                }
                                numV.setText("");
                                opratore = "%";
                          }
                        }

                }else if( !TextUtils.isEmpty(his.getText().toString()) && TextUtils.isEmpty(numV.getText().toString()) &&
                        !his.getText().toString().equals("Enter a number")){

                    int t = (int) first;
                    if (t == first) {
//                        his.setText("" + (int) first + "%");
                    } else if (t < first) {
                        his.setText("" + first + "%");
                    } else if (t > first) {
                        his.setText("" + first + "%");
                    }
                    numV.setText("");
                    opratore = "%";
                    Log.i("else1", "else is work1 ");
                }
                else if (TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())){
                    his.setText("Enter a number");
                    numV.setText("");
                    Log.i("else2", "else is work2 ");
                }
            }
        });


        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String primary;
                if(!TextUtils.isEmpty(numV.getText().toString()) && !TextUtils.isEmpty(his.getText().toString()) ||
                        !TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())
                                && !numV.getText().toString().equals("-")){



                        // if to the negative

                    if(!numV.getText().toString().equals("-") || !his.getText().toString().equals("Enter a number")) {
                        // check double dot or not
                        if ( numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(1)=='.' ||
                                numV.getText().length()>=4 && numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(3)=='.') {
                            // check double dot or not negative number
                            if(numV.getText().toString().charAt(2) == '.' && numV.getText().toString().charAt(3) == '.' ||
                                    numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ) {
                                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                Log.i("else", "check double dot or not negative number ");
                            }
                            Log.i("else", "check double dot or not");

                        }else if(numV.getText().length()>=3 && numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ||
                                numV.getText().toString().charAt(0) == '.' && numV.getText().toString().charAt(1) =='.'){
                            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }else{
                                first = Double.parseDouble((String) numV.getText());
                                primary = String.format("%.2f", first);
                                int t = (int) first;
                                if (t == first) {
                                    his.setText("" + (int) first + "+");
                                } else if (t < first) {
                                    his.setText("" + first + "+");
                                } else if (t > first) {
                                    his.setText("" + first + "+");
                                }
                                numV.setText("");
                                opratore = "+";
                           }
                        }

                }else if( !TextUtils.isEmpty(his.getText().toString()) && TextUtils.isEmpty(numV.getText().toString()) &&
                        !his.getText().toString().equals("Enter a number")){
                    int t = (int) first;
                    if (t == first) {
                        his.setText("" + (int) first + "+");
                    } else if (t < first) {
                        his.setText("" + first + "+");
                    } else if (t > first) {
                        his.setText("" + first + "+");
                    }
                    numV.setText("");
                    opratore = "+";
                    Log.i("else1", "else is work1 ");
                }
                else if (TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())){
                    his.setText("Enter a number");
                    numV.setText("");
                    Log.i("else2", "else is work2 ");
                }
            }
        });


        mulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primary;
                if(!TextUtils.isEmpty(numV.getText().toString()) && !TextUtils.isEmpty(his.getText().toString()) ||
                        !TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())
                              && !numV.getText().toString().equals("-") ){



                        // if to the negative

                    if(!numV.getText().toString().equals("-") || !his.getText().toString().equals("Enter a number")) {
                        // check double dot or not
                        if ( numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(1)=='.' ||
                                numV.getText().length()>=4 && numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(3)=='.') {
                            // check double dot or not negative number
                            if(numV.getText().toString().charAt(2) == '.' && numV.getText().toString().charAt(3) == '.' ||
                                    numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ) {
                                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                Log.i("else", "check double dot or not negative number ");
                            }
                            Log.i("else", "check double dot or not");

                        }else if(numV.getText().length()>=3 && numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ||
                                numV.getText().toString().charAt(0) == '.' && numV.getText().toString().charAt(1) =='.'){
                            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }else {
                                first = Double.parseDouble((String) numV.getText());
                                primary = String.format("%.2f", first);
                                int t = (int) first;
                                if (t == first) {
                                    his.setText("" + (int) first + op);
                                } else if (t < first) {
                                    Log.i("ifmul", "ifmul is work1 ");
                                    his.setText("" + first + "x");
                                } else if (t > first) {
                                    his.setText("" + first + "x");
                                    Log.i("ifmul", "ifmul is work1 ");
                                }
                                numV.setText("");
                                opratore = "x";
                            }
                        }

                }else if( !TextUtils.isEmpty(his.getText().toString()) && TextUtils.isEmpty(numV.getText().toString()) &&
                        !his.getText().toString().equals("Enter a number")){
                    int t = (int) first;
                    if (t == first) {
                        his.setText("" + (int) first + "x");
                    } else if (t < first) {
                        his.setText("" + first + "x");
                    } else if (t > first) {
                        his.setText("" + first + "x");
                    }
                    numV.setText("");
                    opratore = "x";
                    Log.i("else1", "else is work1 ");
                }
                else if (TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())){
                    his.setText("Enter a number");
                    numV.setText("");
                    Log.i("else2", "else is work2 ");
                }
            }
        });


        minbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String primary;
                if(!TextUtils.isEmpty(numV.getText().toString()) && !TextUtils.isEmpty(his.getText().toString()) ||
                    !TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())){
                         Log.i("else0", "else is work0 ");



                        // if to the negative
                    if(!numV.getText().toString().equals("-") || !his.getText().toString().equals("Enter a number")) {
                        // check double dot or not
                        if ( numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(1)=='.' ||
                                numV.getText().length()>=4 && numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(3)=='.') {
                            // check double dot or not negative number
                            if(numV.getText().toString().charAt(2) == '.' && numV.getText().toString().charAt(3) == '.' ||
                                    numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ) {
                                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                Log.i("else", "check double dot or not negative number ");
                            }
                            Log.i("else", "check double dot or not");

                        }else if(numV.getText().length()>=3 && numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ||
                                numV.getText().toString().charAt(0) == '.' && numV.getText().toString().charAt(1) =='.'){
                            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }else {
                                first = Double.parseDouble((String) numV.getText());
                                primary = String.format("%.2f", first);
                                int t = (int) first;
                                if (t == first) {
                                    his.setText("" + (int) first + "-");
                                } else if (t < first) {
                                    his.setText("" + first + "-");
                                } else if (t > first) {
                                    his.setText("" + first + "-");
                                }
                                numV.setText("");
                                opratore = "-";
                            }
                        }

                }else if( !TextUtils.isEmpty(his.getText().toString()) && TextUtils.isEmpty(numV.getText().toString() ) &&
                        !his.getText().toString().equals("Enter a number")){
                    int t = (int) first;
                    if (t == first) {
                        his.setText("" + (int) first + "-");
                    } else if (t < first) {
                        his.setText("" + first + "-");
                    } else if (t > first) {
                        his.setText("" + first + "-");
                    }
                    numV.setText("");
                    opratore = "-";
                    Log.i("else1", "else is work1 ");
                }
                else if (TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString()) ||
                        TextUtils.isEmpty(numV.getText().toString()) && !TextUtils.isEmpty(his.getText().toString())    ){
                    numV.setText("-");
                    Log.i("else2", "else is work2 ");
                }else if(numV.equals('-')){
                    numV.setText(numV.getText());
                }
            }
        });


        dividbtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                String primary;
                if(!TextUtils.isEmpty(numV.getText().toString()) && !TextUtils.isEmpty(his.getText().toString()) ||
                        !TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())
                && !numV.getText().toString().equals("-")){


                    if(!numV.getText().toString().equals("-") || !his.getText().toString().equals("Enter a number")) {
                        // check double dot or not
                        if ( numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(1)=='.' ||
                                numV.getText().length()>=4 && numV.getText().toString().charAt(0)=='-' && numV.getText().toString().charAt(3)=='.') {
                        // check double dot or not negative number
                            if(numV.getText().toString().charAt(2) == '.' && numV.getText().toString().charAt(3) == '.' ||
                                    numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ) {
                                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                                Log.i("else", "check double dot or not negative number ");
                            }
                                Log.i("else", "check double dot or not");

                        }else if(numV.getText().length()>=3 && numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ||
                                numV.getText().toString().charAt(0) == '.' && numV.getText().toString().charAt(1) =='.'){
                             Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }else{
                            first = Double.parseDouble(numV.getText().toString());
                            primary = String.format("%.2f", first);
                            int t = (int) first;
                            Log.i("else", "else is work divide  ");
//                            his.setText("" + first + "/");
                            if (t == first) {
                                his.setText("" + (int) first + "/");
                                Log.i("else0", "else is work divide  ");
                            } else if (t < first) {
                                his.setText("" + first + "/");
                                Log.i("else1", "else is work divide  ");
                            } else if (t > first) {
                                his.setText("" + first + "/");
                                Log.i("else2 ", "else is work divide  ");
                            }
                        numV.setText("");
                        opratore = "/";
                        }
                    }

                }else if( !TextUtils.isEmpty(his.getText().toString()) && TextUtils.isEmpty(numV.getText().toString()) &&
                        !his.getText().toString().equals("Enter a number")){
                    int t = (int) first;
                    if (t == first) {
                        his.setText("" + (int) first + "/");
                    } else if (t < res) {
                        his.setText("" + first + "/");
                    } else if (t > res) {
                        his.setText("" + first + "/");
                    }
                    numV.setText("");
                    opratore = "/";
                    Log.i("else1", "else is work1 ");
                }
                else if (TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())){
                    his.setText("Enter a number");
                    numV.setText("");
                    Log.i("else2", "else is work2 ");
                }
            }
        });


        // equal button

        equlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString()) ||

                        !TextUtils.isEmpty(numV.getText().toString()) && TextUtils.isEmpty(his.getText().toString())

                || numV.getText().toString().equals("-") || his.getText().toString().equals("Enter a number") ) {

                    his.setText("Enter a number");

                    numV.setText("");
                }else if(TextUtils.isEmpty(numV.getText().toString()) && !TextUtils.isEmpty(his.getText().toString())){
                    Toast.makeText(MainActivity.this, "Press a number", Toast.LENGTH_SHORT).show();
                    numV.setText("");
                }
                else {
                    if (numV.getText().length() >= 3 && numV.getText().toString().charAt(1) == '.' && numV.getText().toString().charAt(2) == '.' ||
                            numV.getText().toString().charAt(0) == '.' && numV.getText().toString().charAt(1) == '.') {
                        Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    } else {
                        second = Double.parseDouble((String) numV.getText());
                        if (opratore.equals("+")) {
                            res = first + second;
                            if (his.equals("Enter a number")) {
                                his.setText("");
                            }
                            his.setText(his.getText() + (String) numV.getText());
                            int t = (int) res;
                            if (t == res) {
                                numV.setText("" + (int) res);
                            } else if (t < res) {
                                numV.setText("" + res);

                            }

                        }
                        if (opratore.equals("-")) {
                            res = first - second;
                            if (his.equals("Enter a number")) {
                                his.setText("");
                            }
                            his.setText(his.getText() + (String) numV.getText());
                            int t = (int) res;
                            if (t == res) {
                                numV.setText("" + (int) res);
                            } else if (t < res) {
                                numV.setText("" + res);
                            } else if (t > res) {
                                numV.setText("" + res);
                            }
                        }
                        if (opratore.equals("x")) {
                            res = first * second;
                            if (his.equals("Enter a number")) {
                                his.setText("");
                            }
                            his.setText(his.getText() + (String) numV.getText());
                            int t = (int) res;
                            if (t == res) {
                                numV.setText("" + (int) res);
                            } else if (t < res) {
                                numV.setText("" + res);
                            }
                        }
                        if (opratore.equals("/")) {
                            res = first / second;
                            if (his.equals("Enter a number")) {
                                his.setText("");
                            }
                            his.setText(his.getText() + (String) numV.getText());
                            int t = (int) res;
                            if (t == res) {
                                numV.setText("" + (int) res);
                            } else if (t < res) {
                                numV.setText("" + res);
                            }
                        }
                        if (opratore.equals("%")) {
                            res = first % second;
                            if (his.equals("Enter a number")) {
                                his.setText("");
                            }
                            his.setText(his.getText() + (String) numV.getText());
                            int t = (int) res;
                            if (t == res) {
                                numV.setText("" + (int) res);
                            } else if (t < res) {
                                numV.setText("" + res);
                            }
                        }
                    }
                }
            }
        });


    }
}