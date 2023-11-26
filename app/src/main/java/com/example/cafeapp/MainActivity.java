package com.example.cafeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static List<Product> list = new ArrayList<>();
    TextView tv;
    EditText edit_id, edit_name, edit_unit, edit_price, edit_count;
    MaterialButton button_add, button_calc, button_find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.showtext_tv);
        edit_id = findViewById(R.id.edit_id);
        edit_name = findViewById(R.id.edit_name);
        edit_unit = findViewById(R.id.edit_unit);
        edit_price = findViewById(R.id.edit_price);
        edit_count = findViewById(R.id.edit_count);

        Process(button_add, R.id.button_add);
        Process(button_calc, R.id.button_calc);
        Process(button_find, R.id.button_find);
    }

    private void Process(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();

        String id = String.valueOf(edit_id.getText());
        String name = String.valueOf(edit_name.getText());
        String unit = String.valueOf(edit_unit.getText());
        int price = Integer.valueOf(String.valueOf(edit_price.getText()));
        int count = Integer.valueOf(String.valueOf(edit_count.getText()));

        Product tmp = new Product(id, name, unit, price, count);

        if (buttonText.equals("add")){
            list.add(tmp);
            String res = "Danh Sach hang da nhap: \n";
            for (Product pr: list) {
                res += pr.toString() + "\n";
            }
            tv.setText(res);
            return;
        }
        if (buttonText.equals("calc")){
            int totals = 0;
            for (Product pr: list){
                totals += pr.getTotal();
            }
            tv.setText(String.valueOf(totals) + "size: " + String.valueOf(list.size()));
            return;
        }

        if (buttonText.equals("top")){
            List<Product> tmplist = list;
            Collections.sort(tmplist, new Comparator<Product> (){
                @Override
                public int compare(Product o1, Product o2){
                    return (o1.getTotal() > o2.getTotal()) ? 1 : -1;
                }
            });

            String res = "Top 3 MIN va Top 3 MAX: \n";
            for (int i = 0; i < 3; ++i){
                res += tmplist.get(i).toString() + "\n";
            }

            for (int i = tmplist.size() - 1; i >= tmplist.size() - 3; --i){
                res += tmplist.get(i).toString() + "\n";
            }

            tv.setText(res);
        }
    }
}