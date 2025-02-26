const taskForm = document.getElementById('task-form');
const taskInput = document.getElementById('task-input');
const taskList = document.querySelector('.task-list');
const hideButton = document.querySelector('#hideButton');
const showButton = document.querySelector('#showButton');
const progressBar = document.querySelector('.progress-bar');
const progressText = document.querySelector('.progress-text');

let lista = [];

taskForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const listItem = document.createElement('li');
    addTask(listItem);
});

const addTask = (listItem) => {

    const taskDercription = taskInput.value;
    listItem.classList.add('task-item');

    const taskSpan = document.createElement('span');
    taskSpan.textContent = taskDercription;

    const taskFormInput = document.createElement('input');
    taskFormInput.type = 'checkbox';
    taskFormInput.addEventListener('click', (event) => {
        if (taskFormInput.checked) {
            taskSpan.style.textDecoration = 'line-through';
        } else {
            taskSpan.style.textDecoration = 'none';
        }
    });

    const taskEditButton = document.createElement('button');
    taskEditButton.textContent = '✏️';
    taskEditButton.addEventListener('click', (event) => {
        const novaTarefa = prompt(`Digite a nova descrição da tarefa "${taskSpan.textContent}"`, taskSpan.textContent);
        if (novaTarefa === null) {
            return;
        }
        const tarefaFormatada = novaTarefa.trim();

        if (tarefaFormatada != '') {
            taskSpan.textContent = tarefaFormatada;
            changeProgressBar();
        }
    });

    const taskDeletButton = document.createElement('button');
    taskDeletButton.textContent = '🗑️';
    taskDeletButton.addEventListener('click', (event) => {
        const confirmacao = confirm(`Deseja realmente excluir a tarefa "${taskSpan.textContent}"`, taskSpan.textContent);
        if (confirmacao) {
            listItem.remove();
        }
        changeProgressBar();
    });

    taskFormInput.addEventListener('change', () => {
        changeProgressBar();
    });

    listItem.appendChild(taskFormInput);
    listItem.appendChild(taskSpan);
    listItem.appendChild(taskEditButton);
    listItem.appendChild(taskDeletButton);
    
    taskList.appendChild(listItem);
    changeProgressBar();
};

hideButton.addEventListener('click', (event) => {
    const vetorDeLis = Array.from(taskList.children);

    if (hideButton.dataset.action === "hide") {
        vetorDeLis.forEach((li) => {
            const input = li.querySelector('input');
            if (input.checked) {
                li.style.display = 'none';
            }
        });
        hideButton.dataset.action = "show";
        hideButton.textContent = 'Mostrar tarefas';

    } else {
        vetorDeLis.forEach((li) => {
            li.style.display = 'flex';
        });
        hideButton.dataset.action = "hide";
        hideButton.textContent = 'Ocultar concluidos';
    }
});

const changeProgressBar = () => {
    const taskLength = taskList.children.length;
  
    if (taskLength === 0) {
        progressBar.style.width = `0%`;
        progressText.textContent = `0/0 concluidos (0.0%)`;
        return;
    }

    const doneArray = [...taskList.children].filter((li) => li.querySelector('input').checked);
    const doneLength = doneArray.length;
    const percentual = (doneLength / taskLength) * 100;

    progressBar.style.width = `${percentual}%`;
    progressText.textContent = `${doneLength}/${taskLength} concluidos (${percentual.toFixed(1)}%)`;

    saveTasks();
};

const saveTasks = () => {
    const tasks = [...taskList.children].map((li) => {
        const isCheckbox = li.querySelector('input').checked;
        const spanText = li.querySelector('span').textContent;
        const newJson = {
            text: spanText,
            done: isCheckbox
        }

        return newJson;
    });

    localStorage.setItem('tasks', JSON.stringify(tasks));
}