import java.time.LocalTime
import java.time.format.DateTimeFormatter

class TaskManager() {


    private val tasks = mutableListOf<Task>()

    // Create a new task and add it to tasks.
    fun createTask(){

        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        // Get task info
        println("Please fill out the following information:\n")

        println("Enter task name: ")
        val taskName = readlnOrNull()

        println("Enter task description: ")
        val taskDesc = readlnOrNull()

        println("Enter a start time (HH:mm):")
        val startTimeInput = readlnOrNull()
        val startTime = LocalTime.parse(startTimeInput, formatter)

        println("Enter an end time (HH:mm): ")
        val endTimeInput= readlnOrNull()
        val endTime = LocalTime.parse(endTimeInput, formatter)

        // Add to tasks if not null
        if (taskName != null && taskDesc != null) {
            val newTask = Task(startTime, endTime, taskName, taskDesc )
            tasks.add(newTask)
        } else {
            println("Task not added due to empty name/desc.")
        }

        println("Task created successfully!")
    }

    // Remove a task from tasks
    fun removeTask(){
        println("Please type the name of the task you would like to remove: ")

        // Show task names to choose from.
        displayTaskNames()

        // Read user input for the index to remove
        val taskToRemove = readlnOrNull()
        val indexToRemove = taskToRemove?.toInt()

        // Check if the input is a valid integer
        if (indexToRemove != null && indexToRemove > 0 && indexToRemove <= tasks.size) {
            tasks.removeAt(indexToRemove - 1)
            println("Task removed successfully")
        }else {
            println("Task with name '$taskToRemove' not found.")
        }



    }

    // Display task named for removeTask
    private fun displayTaskNames() {
        var count = 1
        for (task in tasks) {
            println(count.toString() + ". " + task.taskName)
            count++
        }
    }

    // Display a list of tasks
    fun displayTasks() {
        for (task in tasks) {
            println("\nTask name: " + task.taskName)
            println("Task description: " + task.taskDesc)
            println(task.startTime.toString() + " - " + task.endTime)

        }
    }


}