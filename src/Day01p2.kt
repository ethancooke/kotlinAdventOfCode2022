import java.io.File

fun findTopThreeCalories(calorieList: List<String>): Int {
    val caloriesPerElf = mutableListOf<Int>()
    var currentCalories = 0

    for (item in calorieList) {
        if (item.isEmpty()) {  // New elf
            caloriesPerElf.add(currentCalories)
            currentCalories = 0
        } else {
            currentCalories += item.toInt()
        }
    }

    // Add the last elf's calories
    caloriesPerElf.add(currentCalories)

    // Sort and get the top three
    val topThree = caloriesPerElf.sortedDescending().take(3)

    return topThree.sum()
}

fun main() {
    val fileName = "src/Day01_input"
    val calorieList = File(fileName).readLines()
    val totalCaloriesTopThree = findTopThreeCalories(calorieList)
    println("The total calories carried by the top three Elves are $totalCaloriesTopThree.")
}
