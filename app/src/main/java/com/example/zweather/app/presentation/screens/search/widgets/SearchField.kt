package com.example.zweather.app.presentation.screens.search.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.zweather.app.presentation.WeatherViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SearchField(viewModel: WeatherViewModel) {
    var textfieldValue by remember {
        mutableStateOf<String>("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalView.current.context


    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp) // Inner padding to avoid clipping the content

            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF1E1E40), // Darker Purple
                        Color(0xFF3E3E80)  // Lighter Purple
                    )
                ),
                shape = RoundedCornerShape(28.dp) // Rounded corners
            )
            .shadow(10.dp, RoundedCornerShape(28.dp)) // Shadow effect
    ) {
        // Actual TextField
        TextField(
            value = textfieldValue,
            onValueChange = {
                textfieldValue = it
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search // Sets the IME action to "Done"
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    println("search click")
                    viewModel.searchWeather(textfieldValue, context = context)
                    keyboardController?.hide()
                    
                }
            ),
            placeholder = {
                Text(
                    text = "Search for a city or airport",
                    color = Color(0xFFD3D3E3), // Light gray color for placeholder
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color(0xFFD3D3E3) // Same color as placeholder
                )
            },
            singleLine = true,

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Remove default background
                focusedIndicatorColor = Color.Transparent, // Remove focused underline
                unfocusedIndicatorColor = Color.Transparent, // Remove unfocused underline
                focusedTextColor = Color.White
            ),
            shape = RoundedCornerShape(28.dp), // Rounded TextField itself
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center) // Center inside the Box
                .padding(horizontal = 20.dp)
        )
    }
}