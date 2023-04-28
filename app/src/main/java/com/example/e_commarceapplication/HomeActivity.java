package com.example.e_commarceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commarceapplication.databinding.ActivityHomeBinding;

public class HomeActivity extends DrawerBaseActivity {
    ImageView cartItem1, cartItem2, cartItem3, cartItem4;
    TextView cartItemName1, cartItemName2, cartItemName3, cartItemName4;
    TextView cartItemPrice1, cartItemPrice2, cartItemPrice3, cartItemPrice4;

    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocateActivityTitle("Home");

        cartItem1 = findViewById(R.id.cart_image_item_1);
        cartItem2 = findViewById(R.id.cart_image_item_2);
        cartItem3 = findViewById(R.id.cart_image_item_3);
        cartItem4 = findViewById(R.id.cart_image_item_4);
        cartItemName1 = findViewById(R.id.cart_name_item_1);
        cartItemName2 = findViewById(R.id.cart_name_item_2);
        cartItemName3 = findViewById(R.id.cart_name_item_3);
        cartItemName4 = findViewById(R.id.cart_name_item_4);
        cartItemPrice1 = findViewById(R.id.cart_price_item_1);
        cartItemPrice2 = findViewById(R.id.cart_price_item_2);
        cartItemPrice3 = findViewById(R.id.cart_price_item_3);
        cartItemPrice4 = findViewById(R.id.cart_price_item_4);


        cartItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itName = cartItemName1.getText().toString();
                String itPrice = cartItemPrice1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("item1_name", itName);
                intent.putExtra("item_price", itPrice);
                Toast.makeText(HomeActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();

            }
        });
        cartItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itName = cartItemName2.getText().toString();
                String itPrice = cartItemPrice2.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("item1_name", itName);
                intent.putExtra("item_price", itPrice);
                Toast.makeText(HomeActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();

            }
        });
        cartItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itName = cartItemName1.getText().toString();
                String itPrice = cartItemPrice1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("item1_name", itName);
                intent.putExtra("item_price", itPrice);
                Toast.makeText(HomeActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();

            }
        });
        cartItem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itName = cartItemName1.getText().toString();
                String itPrice = cartItemPrice1.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("item1_name", itName);
                intent.putExtra("item_price", itPrice);
                Toast.makeText(HomeActivity.this, "Added to cart", Toast.LENGTH_SHORT).show();

            }
        });


    }
}