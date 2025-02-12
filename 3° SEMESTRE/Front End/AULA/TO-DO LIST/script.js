const taskForm = document.getElementById('task-form');
const taskInput = document.getElementById('task-input');
const taskList = document.querySelector('.task-list');

taskForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const taskDercription = taskInput.value;

    const listItem = document.createElement('li');
    listItem.classList.add('task-item');
    
    const taskSpan = document.createElement('span');
    taskSpan.textContent = taskDercription;

    const taskFormInput = document.createElement('input');
    taskFormInput.type = 'checkbox';

    const taskEditButton = document.createElement('button');
    taskEditButton.textContent = '✏️';
    
    const taskDeletButton = document.createElement('button');
    taskDeletButton.textContent = '🗑️';
    
    listItem.appendChild(taskFormInput);
    listItem.appendChild(taskSpan);
    listItem.appendChild(taskEditButton);
    listItem.appendChild(taskDeletButton);

    taskList.appendChild(listItem);

});
