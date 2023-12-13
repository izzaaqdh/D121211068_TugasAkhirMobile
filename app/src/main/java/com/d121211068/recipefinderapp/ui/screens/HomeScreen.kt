package com.d121211068.recipefinderapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.d121211068.recipefinderapp.ui.components.ErrorComponent
import com.d121211068.recipefinderapp.ui.components.LoadingComponent
import com.d121211068.recipefinderapp.ui.components.SuccessComponent
import com.d121211068.recipefinderapp.ui.viewmodel.RecipeViewIntent
import com.d121211068.recipefinderapp.ui.viewmodel.RecipeViewModel
import com.d121211068.recipefinderapp.ui.viewmodel.RecipeViewState

@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel){
    val state by recipeViewModel.state

    when(state) {
        is RecipeViewState.Loading -> LoadingComponent()
        is RecipeViewState.Success -> {
            val recipe = (state as RecipeViewState.Success).recipes
            SuccessComponent(recipe = recipe, onSearchClicked =  {query ->
                recipeViewModel.processIntent(RecipeViewIntent.SearchRecipe(query))
            })
        }
        is RecipeViewState.Error -> {
            val message = (state as RecipeViewState.Error).message
            ErrorComponent(message = message, onRefreshClicked =  {
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
            })
        }
    }
    LaunchedEffect(Unit){
        recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }
}