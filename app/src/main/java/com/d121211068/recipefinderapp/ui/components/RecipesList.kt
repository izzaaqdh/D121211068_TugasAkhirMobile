package com.d121211068.recipefinderapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.d121211068.recipefinderapp.data.model.Meal


@Composable
fun RecipesList(recipe: List<Meal>){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.DarkGray)
    ){
        items(recipe){
            RecipeListItem(it)
        }
    }
}