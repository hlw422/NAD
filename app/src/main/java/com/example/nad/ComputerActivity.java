package com.example.nad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ComputerActivity extends AppCompatActivity {

    BigDecimal calc_One=BigDecimal.valueOf(0);
    BigDecimal calc_Two=BigDecimal.valueOf(0);
    String operator="";
    String input="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);



        Button btn_1=findViewById(R.id.btn_one);
        btn_1.setOnClickListener(new MyClickListener());

        Button btn_2=findViewById(R.id.btn_two);
        btn_2.setOnClickListener(new MyClickListener());

        Button btn_3=findViewById(R.id.btn_three);
        btn_3.setOnClickListener(new MyClickListener());

        Button btn_4=findViewById(R.id.btn_four);
        btn_4.setOnClickListener(new MyClickListener());


        Button btn_5=findViewById(R.id.btn_five);
        btn_5.setOnClickListener(new MyClickListener());

        Button btn_6=findViewById(R.id.btn_six);
        btn_6.setOnClickListener(new MyClickListener());

        Button btn_7=findViewById(R.id.btn_seven);
        btn_7.setOnClickListener(new MyClickListener());

        Button btn_8=findViewById(R.id.btn_eight);
        btn_8.setOnClickListener(new MyClickListener());

        Button btn_9=findViewById(R.id.btn_nine);
        btn_9.setOnClickListener(new MyClickListener());

        Button btn_0=findViewById(R.id.btn_zero);
        btn_0.setOnClickListener(new MyClickListener());

        Button btn_plus=findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(new MyClickListener());

        Button btn_minus=findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(new MyClickListener());

        Button multiply=findViewById(R.id.btn_multiply);
        multiply.setOnClickListener(new MyClickListener());

        Button btn_divide=findViewById(R.id.btn_divide);
        btn_divide.setOnClickListener(new MyClickListener());

        Button btn_clear=findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new MyClickListener());

        Button btn_cancel=findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new MyClickListener());

        Button btn_equal=findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(new MyClickListener());
    }
    private BigDecimal Calculate(){
        if(operator.equals("＋")){
            return calc_One.add(calc_Two);
        }
        else if(operator.equals("－")){
            return calc_One.subtract(calc_Two);
        }
        else if(operator.equals("×")){
            return calc_One.multiply(calc_Two);
        }
        else if(operator.equals("÷")){
            return calc_One.divide(calc_Two,3, RoundingMode.HALF_UP);
        }
        return BigDecimal.valueOf(0);
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String text= (String) ((Button)view).getText();
            TextView textView=findViewById(R.id.tv_result);
            input=input+text;
            textView.setText(input);



                if(view.getId()==R.id.btn_zero||
                        view.getId()==R.id.btn_one||
                        view.getId()==R.id.btn_two||
                        view.getId()==R.id.btn_three||
                        view.getId()==R.id.btn_four||
                        view.getId()==R.id.btn_five||
                        view.getId()==R.id.btn_six||
                        view.getId()==R.id.btn_seven||
                        view.getId()==R.id.btn_eight||
                        view.getId()==R.id.btn_nine) {
                    if (operator == "") {
                         calc_One=new BigDecimal(calc_One.toString()+text);
                    }else{
                        calc_Two=new BigDecimal(calc_Two.toString()+text);
                    }
                }
                else if(view.getId()==R.id.btn_clear){
                    calc_Two=BigDecimal.valueOf(0);
                    calc_One=BigDecimal.valueOf(0);
                    operator="";
                    input="";
                    textView.setText("0");

                }
                else if(view.getId()==R.id.btn_plus||
                        view.getId()==R.id.btn_divide||
                        view.getId()==R.id.btn_multiply||
                        view.getId()==R.id.btn_minus){
                        operator=(String) ((Button)view).getText();
                }
                else if(view.getId()==R.id.btn_equal){
                    if(operator==""){
                        Toast.makeText(ComputerActivity.this,"请输入操作运算符", Toast.LENGTH_SHORT).show();

                    }else{
                        if(calc_Two.equals(BigDecimal.valueOf(0))){
                            calc_Two=BigDecimal.valueOf(0);
                            calc_One=BigDecimal.valueOf(0);
                            operator="";
                            input="";
                            textView.setText("错误");
                        }
                        else {
                            calc_One = Calculate();
                            operator = "";
                            calc_Two = BigDecimal.valueOf(0);
                            textView.setText(calc_One.toString());
                            input = calc_One.toString();
                        }
                    }

                }

        }
    }
}
