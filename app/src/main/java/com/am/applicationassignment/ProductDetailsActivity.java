package com.am.applicationassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    private int quantity = 1;
    private TextView quantityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Get the passed product details from the intent
        String productName = getIntent().getStringExtra("product_name");
        String productPrice = getIntent().getStringExtra("product_price");
        int productImage = getIntent().getIntExtra("product_image", R.drawable.coffee_image_1);

        // Find views
        ImageView productImageView = findViewById(R.id.product_image);
        TextView productNameView = findViewById(R.id.product_name);
        TextView productPriceView = findViewById(R.id.product_price);
        quantityText = findViewById(R.id.quantity_text);
        Button increaseQuantityButton = findViewById(R.id.increase_quantity);
        Button decreaseQuantityButton = findViewById(R.id.decrease_quantity);
        Button backButton = findViewById(R.id.back_button);

        // Set product details
        productImageView.setImageResource(productImage);
        productNameView.setText(productName);
        productPriceView.setText("Price: " + productPrice);

        // Increase quantity button listener
        increaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantityText.setText(String.valueOf(quantity));
            }

        });

        // Decrease quantity button listener
        decreaseQuantityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 1) {
                    quantity--;
                    quantityText.setText(String.valueOf(quantity));
                }
            }
        });

        // Set back button listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Goes back to the previous screen
            }
        });

        // Handle click event for the Click Here button
        Button clickHereButton = findViewById(R.id.click_here_button);
        clickHereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+1234567890"));
                startActivity(intent);
            }
        });
    }
}

