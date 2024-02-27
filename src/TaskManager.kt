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

        val taskToRemove = readlnOrNull()

        // Create an iterator to safely remove from the list
        val iterator = tasks.iterator()
        while (iterator.hasNext()) {
            val task = iterator.next()
            if (task.taskName == taskToRemove) {
                iterator.remove()
                println("Task removed successfully")
                return
            }
        }

        println("Task with name '$taskToRemove' not found.")
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
            println(task.StartTime.toString() + " - " + task.EndTime)

        }
    }


}