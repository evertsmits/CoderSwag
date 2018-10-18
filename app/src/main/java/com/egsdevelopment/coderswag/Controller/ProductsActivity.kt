package com.egsdevelopment.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.egsdevelopment.coderswag.Adapters.ProductsAdapter
import com.egsdevelopment.coderswag.R
import com.egsdevelopment.coderswag.Services.DataService
import com.egsdevelopment.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        var spanCount = 2
        val screenSize = resources.configuration.screenWidthDp
        val orientation = resources.configuration.orientation

        if (screenSize > 720 && orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 6
        } else if (screenSize > 720 || orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 4
        } else {
            spanCount = 2
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter


    }
}
