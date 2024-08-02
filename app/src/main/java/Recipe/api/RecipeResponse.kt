package Recipe.api

data class RecipeResponse(
    val q: String,
    val hits: List<Hit>
)

data class Hit(
    val recipe: Recipe
)