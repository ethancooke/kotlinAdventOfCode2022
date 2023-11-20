import java.io.File

fun findMaxCalories(calorieList: List<String>): Int {
    var maxCalories = 0
    var currentCalories = 0

    for (item in calorieList) {
        if (item.isEmpty()) {  // New elf
            maxCalories = maxOf(maxCalories, currentCalories)
            currentCalories = 0
        } else {
            currentCalories += item.toInt()
        }
    }

    // Check for the last elf
    maxCalories = maxOf(maxCalories, currentCalories)

    return maxCalories
}

fun main() {
    val fileName = "src/Day01_input"
    val calorieList = File(fileName).readLines()
    val maxCalories = findMaxCalories(calorieList)
    println("The Elf carrying the most calories is carrying a total of $maxCalories calories.")
}
