package com.d121211068.recipefinderapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d121211068.recipefinderapp.data.model.Meal

@Composable
fun SuccessComponent(recipe:List<Meal>, onSearchClicked: (query: String)-> Unit){

    Column {
        Text(
            text = "Recipe Finder App",
            fontWeight= FontWeight(700),
            fontFamily = FontFamily.SansSerif,
            fontSize = 32.sp,
            modifier = Modifier.padding(18.dp)
        )
        SearchComponent(onSearchClicked = onSearchClicked)
        RecipesList(recipe = recipe)
    }

}