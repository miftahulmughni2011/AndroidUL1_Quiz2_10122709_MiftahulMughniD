package Recipe.api

data class Recipe(
    val label: String,
    val image: String,
    val source: String,
    val url: String,
    val ingredientLines: List<String>,
    val calories: Double
)