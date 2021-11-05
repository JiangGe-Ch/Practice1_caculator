package com.example.practice1_caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrator vb=(Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        int numVbMisec=10;
        int operVbMisec=30;
        int erroeVbMisec=300;

        /*
        文本框对象
         */
        TextView textView_input = (TextView) findViewById(R.id.input);

        /*
        AC按钮
         */
        Button bt_oper_ac = (Button) findViewById(R.id.button_oper_ac);
        bt_oper_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.setText("");
                vb.vibrate(operVbMisec);
            }
        });

        /*
        退格按钮按钮
         */
        Button bt_oper_backspace = (Button) findViewById(R.id.button_oper_backspace);
        bt_oper_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence currentChars = textView_input.getText();
                /*
                退格时表达式为空判断提示
                 */
                if(currentChars.length()==0){
                    Toast.makeText(MainActivity.this, "已经没有了！", Toast.LENGTH_LONG).show();
                    vb.vibrate(erroeVbMisec);
                }else{
                    textView_input.setText(currentChars.subSequence(0, currentChars.length() - 1));
                    vb.vibrate(operVbMisec);
                }
            }
        });

        /*
        %按钮
         */
        Button bt_oper_percent = (Button) findViewById(R.id.button_oper_percent);
        bt_oper_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("%");
                vb.vibrate(operVbMisec);
            }
        });

        /*
        除号按钮
         */
        Button bt_oper_divide = (Button) findViewById(R.id.button_oper_divide);
        bt_oper_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("/");
                vb.vibrate(operVbMisec);
            }
        });

        /*
        数字7按钮
         */
        Button bt_num_seven = (Button) findViewById(R.id.button_num_seven);
        bt_num_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("7");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        数字8按钮
         */
        Button bt_num_eight = (Button) findViewById(R.id.button_num_eight);
        bt_num_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("8");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        数字9按钮
         */
        Button bt_num_nine = (Button) findViewById(R.id.button_num_nine);
        bt_num_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("9");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        操作符X按钮
         */
        Button bt_oper_multiply = (Button) findViewById(R.id.button_oper_multiply);
        bt_oper_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("X");
                vb.vibrate(operVbMisec);
            }
        });

        /*
        数字4按钮
         */
        Button bt_num_four = (Button) findViewById(R.id.button_num_four);
        bt_num_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("4");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        数字5按钮
         */
        Button bt_num_five = (Button) findViewById(R.id.button_num_five);
        bt_num_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("5");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        数字6按钮
         */
        Button bt_num_six = (Button) findViewById(R.id.button_num_six);
        bt_num_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("6");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        操作符-按钮
         */
        Button bt_oper_sub = (Button) findViewById(R.id.button_oper_sub);
        bt_oper_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("-");
                vb.vibrate(operVbMisec);
            }
        });

        /*
        数字1按钮
         */
        Button bt_num_one = (Button) findViewById(R.id.button_num_one);
        bt_num_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("1");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        数字2按钮
         */
        Button bt_num_two = (Button) findViewById(R.id.button_num_two);
        bt_num_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("2");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        数字3按钮
         */
        Button bt_num_three = (Button) findViewById(R.id.button_num_three);
        bt_num_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("3");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        操作符+按钮
         */
        Button bt_oper_add = (Button) findViewById(R.id.button_oper_add);
        bt_oper_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("+");
                vb.vibrate(operVbMisec);
            }
        });

        /*
        数字0按钮
         */
        Button bt_num_zero = (Button) findViewById(R.id.button_num_zero);
        bt_num_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("0");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        操作符.按钮
         */
        Button bt_oper_dot = (Button) findViewById(R.id.button_oper_dot);
        bt_oper_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append(".");
                vb.vibrate(numVbMisec);
            }
        });

        /*
        操作符√按钮
         */
        Button bt_oper_square=(Button)findViewById(R.id.button_oper_square);
        bt_oper_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_input.append("√");
                vb.vibrate(operVbMisec);
            }
        });

        /*
        操作符=按钮
         */
        Button bt_oper_equal = (Button) findViewById(R.id.button_oper_equal);
        bt_oper_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                表达式输入与展示区为空判断提示
                 */
                if(textView_input.getText().length()==0){
                    Toast toast=Toast.makeText(MainActivity.this, "请输入表达式！", Toast.LENGTH_LONG);
                    toast.show();
                    vb.vibrate(erroeVbMisec);
                }else{
                    textView_input.append("\n=");
                    /*
                    尝试对当前表达式进行运算
                    显示运算结果或显示错误提示信息
                     */
                    try {
                        String result=getResult();
                        textView_input.append(result);
                        vb.vibrate(operVbMisec);
                    }catch (Exception e){
                        textView_input.append("计算出错！表达式不合法或不支持此运算！");
                        vb.vibrate(erroeVbMisec);
                        Log.d(TAG, "onClick: bt_oper_equal "+e.getMessage());
                    }
                }
            }
        });
    }

    protected String getResult() {
        TextView textView_input = (TextView) findViewById(R.id.input);
        CharSequence input = textView_input.getText();
        CharSequence expression = input.subSequence(0, input.length() - 1);
        Log.d(TAG, "\ngetResult: expression:" + expression.toString());
        Stack<Double> numStack = new Stack<Double>();
        Stack<String> operStack = new Stack<String>();
        String numStr = "";
        /*
        从左到右扫描表达式
         */
        for (int i = 0; i < expression.length(); i++) {
            char cChar = expression.charAt(i);
            Log.d(TAG, "getResult: for:cChar="+cChar+",i="+i);
            /*
            当前扫描元素是数字
             */
            if (Character.isDigit(cChar) || cChar == '.') {
                Log.d(TAG, "getResult: isDigit:cChar="+cChar);
                numStr = numStr + String.valueOf(cChar);
                continue;
            } else if(!numStr.isEmpty()){
                numStack.push(Double.parseDouble(numStr));
                numStr = "";
            }
            /*
            扫描到等号
             */
            if(cChar=='='){
                numStack.clear();
                operStack.clear();
            }
            /*
            根号
             */
            if(cChar=='√'){
                Log.d(TAG, "getResult: is sqrtNum");
                /*
                执行开放处理方法并跳过已扫描间隔
                 */
                i= pushSqrtNum(numStack, expression, i+1);
                if(i==-1){
                    Toast.makeText(MainActivity.this, "负数不能开平方！", Toast.LENGTH_LONG).show();
                    return "运算出错！";
                }else {
                    i--;
                }
                continue;
            }
            Log.d(TAG, "getResult: push num pass");
            /*
            扫描到运算符
             */
            if(cChar=='+' || cChar=='-' || cChar=='X' || cChar=='/'){
                Log.d(TAG, "getResult: push operator");
                char preOper = 0;
                /*
                第一个数是负数的特殊判断
                 */
                if(operStack.isEmpty() && cChar=='-' && i==0){
                    Log.d(TAG, "getResult: is empty negative");
                    i=pushNegativeNum(numStack, expression, i+1)-1;
                    continue;
                    /*
                    表达式非开头的附属判断
                     */
                }else if(i>0){
                    preOper=expression.charAt(i-1);
                }
                if(cChar=='-' && (preOper=='+'||preOper=='-'||preOper=='X'||preOper=='/')){
                    Log.d(TAG, "getResult: negative");
                    i=pushNegativeNum(numStack, expression, i+1)-1;
                    continue;
                }
                String notNum = String.valueOf(cChar);
                /*
                扫描到的第一个符号不用优先级比较，直接入栈
                 */
                if (operStack.isEmpty()) {
                    operStack.push(notNum);
                    Log.d(TAG, "getResult: operStack is empty, pushed");
                } else {
                    /*
                    当前优先级比前一优先级大时，入栈
                     */
                    if (priorityOf(notNum) > priorityOf(operStack.peek())) {
                        operStack.push(notNum);
                        /*
                        否则，取出两数与一符号计算，将结果入数字站，再将当前扫描到的符号入栈
                         */
                    } else {
                        Log.d(TAG, "getResult: priority of "+notNum+"< priorityOf"+operStack.peek());
                        double num1 = numStack.pop();
                        double num2 = numStack.pop();
                        double resultTemp = 0;
                        String oper = operStack.pop();
                        if (oper.equals("+")) {
                            resultTemp = num1 + num2;
                        } else if (oper.equals("-")) {
                            resultTemp = num2 - num1;
                        } else if (oper.equals("X")) {
                            resultTemp = num1 * num2;
                        } else if (oper.equals("/")) {
                            resultTemp = num2 / num1;
                        }
                        numStack.push(resultTemp);
                        operStack.push(notNum);
                    }
                }
            }
            /*
            后缀符号%判别
            取出一数字，除以100后将结果入数字栈
             */
            if(cChar=='%'){
                Log.d(TAG, "getResult: % cChar="+cChar);
                double preNum=numStack.pop();
                double resultTemp=preNum/100;
                Log.d(TAG, "getResult: % resultTemp="+resultTemp);
                numStack.push(resultTemp);
                Log.d(TAG, "getResult: % pushed");
            }
        }
        /*
        入栈完毕
        依次从数字栈中取出两个数，从符号栈中取出一个符号，运算后将结果入数字栈，依次反复
         */
        while (!operStack.isEmpty()) {
            double num1 = numStack.pop();
            double num2 = numStack.pop();
            String oper = operStack.pop();
            double resultTemp = 0;
            if (oper.equals("+")) {
                resultTemp = num1 + num2;
            } else if (oper.equals("-")) {
                resultTemp = num2 - num1;
            } else if (oper.equals("X")) {
                resultTemp = num1 * num2;
            } else if (oper.equals("/")) {
                if(num1==0){
                    return "除数不能为0";
                }
                resultTemp = num2 / num1;
            }
            numStack.push(resultTemp);
        }
        return String.valueOf(numStack.pop());          /*返回运算结果的字符串描述*/
    }

    /*
    扫描到负数的处理方法
     */
    protected int pushNegativeNum(Stack<Double> numStack, CharSequence expression, int i){
        Log.d(TAG, "pushNegativeNum: charAt(i)="+expression.charAt(i)+", i="+i);
        if(expression.charAt(i)=='√'){
            int step=pushSqrtNum(numStack, expression, i+1);
            String numStr="-"+String.valueOf(numStack.pop());
            Log.d(TAG, "pushNegativeNum: pushed num="+numStr);
            numStack.push(Double.parseDouble(numStr));
            return step;
        }
        String naNumStr="-";
        while(Character.isDigit(expression.charAt(i)) || expression.charAt(i)=='.' || expression.charAt(i)=='√'){
            Log.d(TAG, "pushNegativeNum: while");
            naNumStr=naNumStr+String.valueOf(expression.charAt(i));
            i++;
        }
        Log.d(TAG, "pushNegativeNum: pushed negative num:"+naNumStr);
        numStack.push(Double.parseDouble(naNumStr));
        return i;           //返回已扫描间隔
    }

    /*
    扫描到根号的处理方法
     */
    protected int pushSqrtNum(Stack<Double> numStack, CharSequence expression, int i){
        /*
        被开方数为负数时返回-1
         */
        if(expression.charAt(i)=='-'){
            return -1;
        }
        String sNumStr="";
        Log.d(TAG, "pushSquareNum: push squ num charAt(i)="+expression.charAt(i)+"i="+i);
        while(Character.isDigit(expression.charAt(i)) || expression.charAt(i)=='.'){
            sNumStr=sNumStr+String.valueOf(expression.charAt(i));
            i++;
        }
        double squResult=Math.sqrt(Double.parseDouble(sNumStr));
        Log.d(TAG, "pushSquareNum: pushed sqrt num:√"+sNumStr+"="+squResult);
        numStack.push(squResult);
        return i;           //返回已扫描间隔
    }

    /*
    返回运算符优先级
     */
    protected int priorityOf(String oper) {
        switch (oper) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "X":
                return 2;
            case "/":
                return 2;
            case "(":
                return 0;
            case ")":
                return 3;
        }
        return 0;
    }
}