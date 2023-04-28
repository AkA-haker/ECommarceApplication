package com.example.e_commarceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commarceapplication.databinding.ActivityCartBinding;

public class CartActivity extends DrawerBaseActivity {
    ActivityCartBinding activityCartBinding;
    TextView orderItName1, orderItPrice1;
    Button placeOrderBtn;
    String name,price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCartBinding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(activityCartBinding.getRoot());
        allocateActivityTitle("Cart");
        orderItName1 = findViewById(R.id.order_item_1);
        orderItPrice1 = findViewById(R.id.order_price_item_1);
        placeOrderBtn = findViewById(R.id.button_place_order);

        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}