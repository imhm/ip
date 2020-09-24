# Duke User Guide
Duke is a desktop app for managing tasks, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).



## Table Of Contents
### 1. Quick Start
### 2. Features
### 3. FAQ
### 4. Command Summary




## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest duke.jar from here.
3. Copy the file to the folder you want to use as the home folder for your task manager.
4. Double-click the file to start the app. You should see a welcome message with the "Duke" icon.




## Features 
1. Add a todo task.
2. Add a deadline task.
3. Add an event task.
4. Mark a task as complete.
5. Find a task based on a keyword.
6. Delete a task.
7. List all tasks.
8. Exit the programme.
9. Save data.


### Add a todo task: `add`
Adds a todo task to your list of tasks. The task is marked as incomplete by default.

#### Command: `todo` *your_task_description*

#### Expected outcome: A todo task is added to your task list. You can view it using the `list` feature.



### Add a deadline task: `deadline`
Adds a deadline task to your list of tasks. The task is marked as incomplete by default.

#### Command: `deadline` *your_deadline_description* `/by` due date
 
#### Expected outcome: A deadline task is added to your task list. You can view it using the `list` feature.



### Add an event task: `event`
Adds an event task to your list of tasks. The task is marked as incomplete by default.

#### Command: `event` *your_event_description* `/at` event date

#### Expected outcome: An event is added to your task list. You can view it using the `list` feature.



### Mark a task as complete: `done`
Marks the task as complete.

#### Command: `done` *task_number*

#### Expected outcome: The task is marked as done. The status icon beside the task description shows a tick.



### Find a task based on a keyword: `find`
Displays all the tasks that contains the keyword.

#### Command: `find` *keyword*

#### Expected outcome: The list of tasks containing the keywords are shown, along with their respective task number.



### Delete a task: `delete`
Removes the task from the task list.

#### Command: `delete` *task_number*

#### Expected outcome: The task is removed from the task list. You will not be able to view it using the `list` feature.



### List all tasks: `list`
Displays all tasks in the task list.

#### Command: `list` 

#### Expected outcome: The list of tasks and the total number of tasks in the task list are shown.



### Exit the programme: `bye`
Terminates Duke and saves the list of tasks into a text file onto your computer.

#### Command: `bye` 

#### Expected outcome: Duke terminates. You can find the saved file under "home_folder/data/duke.txt"



### Save data:
Duke saves the list of tasks into a text file onto your computer automatically whenever you terminate it. See also *Exit the programme* feature.
When you start the programme, Duke retrieves the stored data from "home_folder/data/duke.txt" and populates the task list automatically.

#### Command: **Not Applicable**

#### Expected outcome: You can view it your list of tasks saved previously using the `list` feature. See also *Exit the programme* feature.



## FAQ
**Q:** How do I transfer my data to another Computer?

**A:** Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Duke home folder.



## Command Summary
| Feature | Command format |

| ------------ | -------------|

| Add todo task | `todo` *your_task_description* |

| Add deadline task | `deadline` *your_deadline_description* `/by` due date |

| Add event task | `event` *your_event_description* `/at` event date |

| Mark task as done | `done` *task_number* |

| Find task(s) | `find` *keyword* |

| Delete a task | `delete` *task_number* |

| List tasks | `list` |

| Exit | `bye` |