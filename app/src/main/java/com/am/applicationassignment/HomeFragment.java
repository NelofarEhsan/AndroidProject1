package com.am.applicationassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ListView coffeeListView;
    private List<String> coffeeList;

    public HomeFragment() {
        // Required empty public constructor
    }

    private void setupOrderButton(Button button, final String coffeeName, final String coffeePrice, final int coffeeImage) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass data to ProductDetailsActivity
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra("product_name", coffeeName);
                intent.putExtra("product_price", coffeePrice);
                intent.putExtra("product_image", coffeeImage);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize ListView and static data
        coffeeListView = view.findViewById(R.id.coffee_list_view);
        coffeeList = new ArrayList<>();

        // Add static products
        coffeeList.add("Sandwich - $3.00");
        coffeeList.add("Taco - $3.50");
        coffeeList.add("Hot dog - $4.00");
        coffeeList.add("Pizza - $3.75");
        coffeeList.add("Nuggets - $5.00");
        coffeeList.add("Donuts - $3.25");
        coffeeList.add("Affogato - $4.50");
        coffeeList.add("Croissant - $2.50");
        coffeeList.add("Apple Pie - $4.99");
        coffeeList.add("Cheese Cake - $3.99");
        coffeeList.add("Ice cream - $4.99");

        // Set up custom adapter
        CoffeeAdapter adapter = new CoffeeAdapter();
        coffeeListView.setAdapter(adapter);

        Button orderButton1 = view.findViewById(R.id.order_button_1);
        Button orderButton2 = view.findViewById(R.id.order_button_2);
        Button orderButton3 = view.findViewById(R.id.order_button_3);

        setupOrderButton(orderButton1, "Beef Burger", "$4.99", R.drawable.coffee_image_1);
        setupOrderButton(orderButton2, "Fillet Burger", "$3.99", R.drawable.coffee_image_2);
        setupOrderButton(orderButton3, "Vegan Burger", "$4.99", R.drawable.coffee_image_3);

        return view;
    }

    // Custom Adapter class
    private class CoffeeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return coffeeList.size();
        }

        @Override
        public Object getItem(int position) {
            return coffeeList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_coffee, parent, false);
            }

            // Get the coffee name and order button
            TextView coffeeName = convertView.findViewById(R.id.coffee_name);
            Button orderButton = convertView.findViewById(R.id.order_button);

            // Set coffee name
            coffeeName.setText(coffeeList.get(position));

            // Set click listener for the "Order Now" button
            orderButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Make a call
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+1234567890")); // Replace with your desired phone number
                    startActivity(intent);
                }
            });

            return convertView;
        }
    }
}
