Task Tracker🚀
A simple Command Line Interface (CLI) Task Tracker built in Java using Ant. This project helps you manage your tasks efficiently by tracking what needs to be done, what you're working on, and what is completed.

Features
✅ Add new tasks
✅ Update existing tasks
✅ Delete tasks
✅ Mark tasks as In Progress or Done
✅ List all tasks
✅ Filter tasks by status (Done, Not Done, In Progress)
✅ Stores tasks in a JSON file for persistence

Technologies Used
Java (Object-Oriented Programming)
Ant (for build automation)
Gson (for JSON storage)
LocalDateTime (to timestamp tasks)
Interface-based method initialization
Project Structure


TaskTrackerCLI/
│── src/
│   ├── task/tracker/
│   │   ├── Task.java
│   │   ├── TaskManager.java
│   │   ├── TaskTracker.java (Main CLI)
│── lib/ (contains gson-2.8.9.jar)
│── tasks.json (stores tasks)
│── build.xml (Ant build script)
│── README.md
How to Run the Project

1️⃣ Set Up the Project
Clone the repository:

git clone https://github.com/RonKirui/TaskTracker.git
Download Gson from here
Place gson-2.12.1.jar inside the lib/ folder
2️⃣ Compile and Run Using Ant

ant compile
ant run
How to Use the CLI
Once you run the program, you'll see the following menu:

Welcome to Task Tracker CLI!  
1 - Add Task  
2 - Update Task  
3 - Delete Task  
4 - Mark Task as In Progress  
5 - Mark Task as Done  
6 - List All Tasks  
7 - List Done Tasks  
8 - List Not Done Tasks  
9 - List In Progress Tasks  
0 - Exit  
Enter the corresponding number to perform an action.

Example Usage
Adding a Task

> 1
Enter task title: Buy Groceries
Task added successfully!
Marking as Done

> 5
Enter task ID: 2
Task marked as done!
Contributing
Feel free to fork and contribute to this project. Pull requests are welcome! 🚀

Project URL: https://roadmap.sh/projects/task-tracker

License
This project is open-source and free to use.