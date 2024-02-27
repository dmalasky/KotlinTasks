fun main() {

    val taskManager = TaskManager()

    var done = false
    while (!done){

        // Show menu options
        displayMainMenu()

        print("\n> ")
        val choice = readlnOrNull()

        when (choice){
            "1" ->{
                taskManager.createTask() // Create tasks
            }
            "2" ->{
                taskManager.displayTasks() // Display tasks
            }
            "3" ->{
                taskManager.removeTask() // Remove tasks
            }
            "4" -> {
                done = true
            }
        }
    }
}

fun displayMainMenu() {
    println("\nHello Welcome to JavaTasks!\n")
    println("Please select one of the following:\n")
    println("1. Add task")
    println("2. Display tasks")
    println("3. Remove task")
    println("4. Quit")
}

