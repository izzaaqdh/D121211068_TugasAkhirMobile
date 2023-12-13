package com.d121211068.recipefinderapp.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d121211068.recipefinderapp.data.network.MealApiClient
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch



class RecipeViewModel: ViewModel() {
    private val _state = mutableStateOf<RecipeViewState>(RecipeViewState.Loading)
    val state: State<RecipeViewState> = _state

    fun processIntent(intent: RecipeViewIntent){
        when(intent){
            is RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is RecipeViewIntent.SearchRecipe -> searchRecipe(intent.query)
        }
    }

    private var randomRecipeJob: Job? = null

    private fun loadRandomRecipe() {
        randomRecipeJob?.cancel()
        randomRecipeJob = viewModelScope.launch {
            _state.value = RecipeViewState.Loading
            try {
                _state.value = RecipeViewState.Success(MealApiClient.getRandomRecipe())
            } catch (e: java.io.IOException) {
                _state.value = RecipeViewState.Error("Network error")
            } catch (e: Exception) {
                _state.value = RecipeViewState.Error("Error fetching recipe")
            }
        }
    }

    private fun searchRecipe(query: String) {
        viewModelScope.launch{
            _state.value = RecipeViewState.Loading

            try{
                _state.value = RecipeViewState.Success (
                    MealApiClient.getSearchedRecipe(query)
                )
            }catch(e: Exception){
                _state.value = RecipeViewState.Error("Error fetching recipe")
            }
        }
    }
}