package com.example.c8103a1

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.c8103a1.ui.theme.C8103A1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BakeryRevenueScreen()
        }
    }
}

// CHALLENGE 3 SESSION 1
@Composable
fun BakeryRevenueScreen(){
    val currencySymbol = "$"
    var cookiesSold by remember { mutableStateOf("") }
    var cookiePrice by remember { mutableStateOf("") }
    // CHALLENGE 6 SESSION 1
    var muffinsSold by remember { mutableStateOf("") }
    var muffinPrice by remember { mutableStateOf("") }
    var cakesSold by remember { mutableStateOf("") }
    var cakePrice by remember { mutableStateOf("") }

    // DATA STRUCTURE
    val bakeryItems = remember { mutableStateListOf<BakeryItem>() }
    var totalRevenue by remember { mutableStateOf(0.0) }
    var bestSellingItem by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Bakery Revenue Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Enter the sales information for each product",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // COOKIES
        OutlinedTextField(
            value = cookiesSold,
            onValueChange = { cookiesSold = it },
            label = { Text("Cookies Sold") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = cookiePrice,
            onValueChange = { cookiePrice = it },
            label = { Text("Price per cookie")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // MUFFINS
        OutlinedTextField(
            value = muffinsSold,
            onValueChange = { muffinsSold = it },
            label ={ Text("Muffins sold") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = muffinPrice,
            onValueChange = { muffinPrice = it },
            label = { Text("Price per muffins") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // CAKES
        OutlinedTextField(
            value = cakesSold,
            onValueChange = { cakesSold = it },
            label = { Text("Cakes Sold") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height((8.dp)))

        OutlinedTextField(
            value = cakePrice,
            onValueChange = { cakePrice = it },
            label = { Text("Price per cake") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // CHALLENGE 1 SESSION 2
        Button(
            onClick = {
                val cookieP = cookiePrice.toDoubleOrNull()
                val cookiesS = cookiesSold.toDoubleOrNull()
                val muffinP = muffinPrice.toDoubleOrNull()
                val muffinsS = muffinsSold.toDoubleOrNull()
                val cakeP = cakePrice.toDoubleOrNull()
                val cakesS = cakesSold.toDoubleOrNull()

                if (
                    cookiesS == null || cookieP == null ||
                    muffinsS == null || muffinP == null ||
                    cakesS == null || cakeP == null
                ){
                    errorMessage = "Please enter valid numeric values"
                } else {
                    errorMessage = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Revenue")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BakeryRevenueScreenPreview() {
    BakeryRevenueScreen()
}