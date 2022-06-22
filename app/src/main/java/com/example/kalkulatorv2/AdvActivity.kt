package com.example.kalkulatorv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.math.BigDecimal
import kotlin.math.*

class AdvActivity : AppCompatActivity() {

    var sign = ""
    var liczba1 = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adv)
        val toast = Toast.makeText(applicationContext, "Wpisz najpierw liczby, by zmienić znak!", Toast.LENGTH_SHORT)
        val toastDivide = Toast.makeText(applicationContext, "Nie dziel przez 0!", Toast.LENGTH_SHORT)
        val toastEmpty = Toast.makeText(applicationContext, "Wartość jest pusta!", Toast.LENGTH_SHORT)
        val toastDot = Toast.makeText(applicationContext, "Kropka już jest!", Toast.LENGTH_SHORT)
        val toastWar = Toast.makeText(applicationContext, "Operacja niedozwolona!", Toast.LENGTH_SHORT)
        val toastINF = Toast.makeText(applicationContext, "Wartość operacji jest równa INF=0!", Toast.LENGTH_SHORT)
        val result = findViewById<TextView>(R.id.Tekst)
        val op = findViewById<TextView>(R.id.operation)
        if(savedInstanceState!=null)
        {
            result.text = savedInstanceState.getString("memory1").toString()
            op.text = savedInstanceState.getString("memory2").toString()
            sign = savedInstanceState.getString("memory3").toString()
            liczba1 = savedInstanceState.getString("memory4").toString()
        }


        val buttonSIN = findViewById<Button>(R.id.sinus)
        buttonSIN.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                val wynik = sin(double_value)
                result.text = wynik.toString()
            }

        }
        val buttonCOS = findViewById<Button>(R.id.cosinus)
        buttonCOS.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                val wynik = cos(double_value)
                result.text = wynik.toString()
            }

        }
        val buttonTAN = findViewById<Button>(R.id.tangens)
        buttonTAN.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                val wynik = tan(double_value)
                result.text = wynik.toString()
            }

        }
        val buttonSQ = findViewById<Button>(R.id.square)
        buttonSQ.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                val wynik = double_value*double_value
                result.text = wynik.toString()
            }

        }
        val buttonLN = findViewById<Button>(R.id.logN)
        buttonLN.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                if(double_value>0)
                {
                    val wynik = ln(double_value)
                    result.text = wynik.toString()
                }
                else
                {
                    toastWar.show();
                }
            }

        }
        val buttonSQRT = findViewById<Button>(R.id.pierwiastek)
        buttonSQRT.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                if(double_value>=0)
                {
                    val wynik = sqrt(double_value)
                    result.text = wynik.toString()
                }
                else
                {
                    toastWar.show();
                }
            }
            deleteZero(result);
        }
        val buttonLOG = findViewById<Button>(R.id.log)
        buttonLOG.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                if(double_value>0)
                {
                    val wynik = log2(double_value)
                    result.text = wynik.toString()
                }
                else
                {
                    toastWar.show();
                }
            }

        }
        val buttonPER = findViewById<Button>(R.id.percent)
        buttonPER.setOnClickListener {


            val s1 = result.text as String
            if(s1.isEmpty() || s1=="." || s1=="-.")
            {
                toastEmpty.show()
            }
            else
            {
                val double_value: Double = s1.toDouble()
                val wynik = double_value/100
                result.text = wynik.toString()
            }

        }
        val button = findViewById<Button>(R.id.but_return1)
        button.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val buttonClear = findViewById<Button>(R.id.clear)
        buttonClear.setOnClickListener {

            result.text = ""
            op.text = ""
            sign = ""
            liczba1=""
        }
        val buttonN1 = findViewById<Button>(R.id.number1)
        buttonN1.setOnClickListener {
            val s1 = result.text as String
            val s2 = "1"
            result.text = s1+s2
        }
        val buttonN2 = findViewById<Button>(R.id.number2)
        buttonN2.setOnClickListener {
            val s1 = result.text as String
            val s2 = "2"
            result.text = s1+s2
        }
        val buttonN3 = findViewById<Button>(R.id.number3)
        buttonN3.setOnClickListener {
            val s1 = result.text as String
            val s2 = "3"
            result.text = s1+s2
        }
        val buttonN4 = findViewById<Button>(R.id.number4)
        buttonN4.setOnClickListener {
            val s1 = result.text as String
            val s2 = "4"
            result.text = s1+s2
        }
        val buttonN5 = findViewById<Button>(R.id.number5)
        buttonN5.setOnClickListener {
            val s1 = result.text as String
            val s2 = "5"
            result.text = s1+s2
        }
        val buttonN6 = findViewById<Button>(R.id.number6)
        buttonN6.setOnClickListener {
            val s1 = result.text as String
            val s2 = "6"
            result.text = s1+s2
        }
        val buttonN7 = findViewById<Button>(R.id.number7)
        buttonN7.setOnClickListener {
            val s1 = result.text as String
            val s2 = "7"
            result.text = s1+s2
        }
        val buttonN8 = findViewById<Button>(R.id.number8)
        buttonN8.setOnClickListener {
            val s1 = result.text as String
            val s2 = "8"
            result.text = s1+s2
        }
        val buttonN9 = findViewById<Button>(R.id.number9)
        buttonN9.setOnClickListener {
            val s1 = result.text as String
            val s2 = "9"
            result.text = s1+s2
        }
        val buttonN0 = findViewById<Button>(R.id.number0)
        buttonN0.setOnClickListener {
            val s1 = result.text as String
            val s2 = "0"
            result.text = s1+s2
        }
        val buttonBackSpace = findViewById<Button>(R.id.backspace)
        buttonBackSpace.setOnClickListener {
            val s1 = result.text as String
            var drop = 1
            if(s1.length==2 && s1.dropLast(drop)=="-")
            {
                result.text = ""
                sign = ""
            }
            else
            {
                result.text = s1.dropLast(drop)
            }

        }

        val plusAndMinus = findViewById<Button>(R.id.change_sign)
        plusAndMinus.setOnClickListener {
            val s1 = result.text as String
            if(!result.text.isEmpty())
            {
                if(sign == "-")//jest minus//chcemy go usunąć
                {
                    sign = ""
                    result.text = sign + s1.drop(1)
                }
                else //nie ma minusa//go dodajemy
                {
                    val len = s1.length;
                    val temp = s1.dropLast(len-1)
                    if(temp=="-")//jest minus w wyniku operacji np: 5-6
                    {
                        sign = "-"
                    }
                    else
                    {
                        sign="-"
                        result.text = sign + s1
                    }
                }
            }
            else
            {
                toast.show();
            }
        }

        val buttonDot = findViewById<Button>(R.id.dot)
        buttonDot.setOnClickListener {

            val str = result.text as String
            if(!str.contains("."))
            {
                result.text = str + "."
            }
            else
            {
                toastDot.show()
            }

        }
        val buttonPowerOf = findViewById<Button>(R.id.powerN)
        buttonPowerOf.setOnClickListener {
            calculateOP(result,op,toastDivide,toastEmpty,"^")
        }
        val buttonPlus = findViewById<Button>(R.id.plus)
        buttonPlus.setOnClickListener {
            calculateOP(result,op,toastDivide,toastEmpty,"+")
        }
        val buttonMinus = findViewById<Button>(R.id.minus)
        buttonMinus.setOnClickListener {
            calculateOP(result,op,toastDivide,toastEmpty,"-")
        }
        val buttonMultiply = findViewById<Button>(R.id.multiply)
        buttonMultiply.setOnClickListener {
            calculateOP(result, op, toastDivide, toastEmpty, "*")
        }
        val buttonDivide = findViewById<Button>(R.id.divide)
        buttonDivide.setOnClickListener {
            calculateOP(result,op,toastDivide,toastEmpty,"/")
        }
        val buttonEqual = findViewById<Button>(R.id.equals)
        buttonEqual.setOnClickListener {
            val tempOp = op.text as String
            op.text = "="
            val s1 = result.text as String
            if(s1.isEmpty() || liczba1.isEmpty() || s1=="." || liczba1=="." || s1=="-." || liczba1=="-.")
            {
                toastEmpty.show()
                liczba1 = ""
                op.text = ""
                result.text = ""
                sign = ""

            }
            else
            {
                val double1: Double = s1.toDouble()
                val double2: Double = liczba1.toDouble()
                if(tempOp=="+")
                {
                    val doubleSum = double1.toBigDecimal()+double2.toBigDecimal()
                    liczba1 = ""
                    result.text = doubleSum.toString()
                    sign = ""
                }
                else if(tempOp=="-")
                {
                    val doubleSum = double2.toBigDecimal()-double1.toBigDecimal()
                    liczba1 = ""
                    result.text = doubleSum.toString()
                    sign = ""
                }
                else if(tempOp=="*")
                {
                    val doubleSum = double1.toBigDecimal() * double2.toBigDecimal()
                    liczba1 = ""
                    result.text = doubleSum.toString()
                    sign = ""
                }
                else if(tempOp=="^")
                {
                    val doubleSum = double2.pow(double1)
                    println(doubleSum)
                    liczba1 = ""
                    result.text = doubleSum.toString()
                    sign = ""
                }
                else if(tempOp=="/")
                {
                    if(double1!=0.0)
                    {
                        val doubleSum = double2.toBigDecimal()/double1.toBigDecimal()
                        liczba1 = ""
                        result.text = doubleSum.toString()
                        sign = ""
                    }
                    else
                    {
                        toastDivide.show()
                        result.text = ""
                        op.text = ""
                        liczba1 = ""
                        sign = ""
                    }
                }
            }

            changeInfinity(result,toastINF,op)
            deleteZero(result)


        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val result = findViewById<TextView>(R.id.Tekst)
        outState.putString("memory1", result.text.toString())
        val op = findViewById<TextView>(R.id.operation)
        outState.putString("memory2", op.text.toString())
        outState.putString("memory3",sign)
        outState.putString("memory4",liczba1)
    }

    fun deleteZero(result : TextView)
    {
        val s1 = result.text as String

        if(s1.contains('.'))
        {
            while(true)
            {
                val s2 = result.text as String
                val len = s2.length
                if(len==1) break;
                if(s2.drop(len-1)=="0" || s2.drop(len-1)==".")
                {
                    result.text=s2.dropLast(1);
                    //liczba1= result.text as String
                }
                else
                {
                    break;
                }

            }
        }
    }


    fun changeInfinity(result : TextView,toastINF : Toast, op : TextView)
    {
        if(result.text == "Infinity")
        {
            result.text = ""
            liczba1 = ""
            op.text=""
            sign = ""
            toastINF.show()
        }
    }
    fun calculateOP(result : TextView,op : TextView,toastDivide : Toast,toastEmpty : Toast,next_op : String)
    {
        val s1 = result.text as String
        if(!s1.isEmpty())
        {
            if(s1=="." || liczba1=="." || s1=="-." || liczba1=="-.")
            {
                liczba1=""
                result.text=""
                op.text=""
                sign = ""
            }
            else if(!liczba1.isEmpty() && !result.text.isEmpty())
            {

                val double2: Double = s1.toDouble()
                val double1: Double = liczba1.toDouble()


                if(op.text=="+")
                {
                    val wynik = double2+double1
                    liczba1 = wynik.toString()
                    op.text = next_op
                    result.text = ""
                    sign = ""
                }
                else if(op.text=="-")
                {
                    val wynik = double1-double2
                    liczba1 = wynik.toString()
                    op.text = next_op
                    result.text = ""
                    sign = ""
                }
                else if(op.text=="*")
                {
                    val wynik = double1*double2
                    liczba1 = wynik.toString()
                    op.text = next_op
                    result.text = ""
                    sign = ""
                }
                else if(op.text=="^")
                {
                    val wynik = double1.pow(double2)
                    liczba1 = wynik.toString()
                    op.text = next_op
                    result.text = ""
                    sign = ""
                }
                else if(op.text=="/")
                {
                    if(double2!=0.0)
                    {
                        val wynik = double1/double2
                        liczba1 = wynik.toString()
                        op.text = next_op
                        result.text = ""
                        sign = ""
                    }
                    else
                    {
                        toastDivide.show()
                        result.text = ""
                        op.text = ""
                        liczba1 = ""
                        sign = ""
                    }
                }

            }
            else
            {
                op.text = next_op
                val double1: Double? = s1.toDouble()
                liczba1 = double1.toString();

                result.text = ""
                sign = ""
            }
        }
        else
        {
            toastEmpty.show()
        }
    }
}