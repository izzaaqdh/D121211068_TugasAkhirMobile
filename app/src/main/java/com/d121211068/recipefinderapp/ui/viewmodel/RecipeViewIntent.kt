package com.d121211068.recipefinderapp.ui.viewmodel

sealed class RecipeViewIntent {
    object LoadRandomRecipe : RecipeViewIntent()
    data class SearchRecipe(val query: String) : RecipeViewIntent()
}
