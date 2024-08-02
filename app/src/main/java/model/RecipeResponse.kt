package model

data class RecipeResponse(
    val hits: List<Hit>
)

data class Hit(
    val recipe: Recipe
)

data class Recipe(
    val label: String,
    val image: String,
    val source: String,
    val url: String,
    val ingredientLines: List<String>,
    val calories: Double
)