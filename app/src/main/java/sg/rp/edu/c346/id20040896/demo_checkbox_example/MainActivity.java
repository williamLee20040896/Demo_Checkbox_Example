package sg.rp.edu.c346.id20040896.demo_checkbox_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cbEnable;
    Button btnCheck;
    TextView tvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbEnable = findViewById(R.id.checkBoxDiscount);
        btnCheck  = findViewById(R.id.buttonCheck);
        tvShow = findViewById(R.id.textView);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Checkbox:" + cbEnable.isChecked());
                Toast.makeText(MainActivity.this, "Button Clicked",Toast.LENGTH_SHORT).show();
                if(cbEnable.isChecked() == true){
                    double pay = calcPay(100, 20);
                    tvShow.setText("The discount is given, pay $"+ pay );
                }
                else{
                    double pay = calcPay(100, 0);
                    tvShow.setText("DIscount is not given, pay $" + pay);
                }
            }
        });
    }
    private double calcPay(double price, double discount){
        double pay = price * (1 - discount/100);
        return pay;

    }
}