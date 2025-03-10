import React from "react";
import Task from "./Task";

const TaskList = ({ tasks, deleteTask, completeTask }) => {
  return (
    <ul>
      {tasks.map(task => (
        <Task key={task.id} task={task} deleteTask={deleteTask} completeTask={completeTask} />
      ))}
    </ul>
  );
};

export default TaskList;
