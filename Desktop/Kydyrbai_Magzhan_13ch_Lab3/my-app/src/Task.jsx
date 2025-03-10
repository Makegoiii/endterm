import React from "react";

const Task = ({ task, deleteTask, completeTask }) => {
  return (
    <li style={{ textDecoration: task.completed ? "line-through" : "none" }}>
      {task.text}
      <button onClick={() => completeTask(task.id)}>Complete</button>
      <button onClick={() => deleteTask(task.id)}>Delete</button>
    </li>
  );
};

export default Task;
