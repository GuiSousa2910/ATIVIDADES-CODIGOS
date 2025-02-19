const taskForm = document.getElementById('task-form');
const taskInput = document.getElementById('task-input');
const taskList = document.querySelector('.task-list');
const hideButton = document.querySelector('#hideButton');
const showButton = document.querySelector('#showButton');

let lista = [];

taskForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const taskDercription = taskInput.value;

    const listItem = document.createElement('li');
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
        const novaTarefa = prompt(`Digite a nova descrição da tarefa "${taskDercription}"`);
        const tarefaFormatada = novaTarefa.trim();

        if (tarefaFormatada != '') {
            taskSpan.textContent = tarefaFormatada;
        }

    });

    const taskDeletButton = document.createElement('button');
    taskDeletButton.textContent = '🗑️';
    taskDeletButton.addEventListener('click', (event) => {
        const confirmacao = confirm(`Deseja realmente excluir a tarefa "${taskDercription}"`);
        if (!confirmacao) {
            return;
        }
        listItem.remove();
    });

    listItem.appendChild(taskFormInput);
    listItem.appendChild(taskSpan);
    listItem.appendChild(taskEditButton);
    listItem.appendChild(taskDeletButton);

    taskList.appendChild(listItem);

});

hideButton.addEventListener('click', (event) => {
    const vetorDeLis = Array.from(taskList.children);

    vetorDeLis.forEach((li) => {
        const input = li.querySelector('input');
        if (input.checked) {
            li.style.display = 'none';
            showButton.style.display = 'flex';
            hideButton.style.display = 'none';
        }else{
            li.style.display = 'flex';
        }
    })
})

showButton.addEventListener('click', (event) => {
    const vetorDeLis = Array.from(taskList.children);

    vetorDeLis.forEach((li) => {
        li.style.display = 'flex';
        showButton.style.display = 'none';
        hideButton.style.display = 'flex';
    })
})   


// Eu tava fazendo assim antes e nao deu certo

// function ocultar() {
//     for (let i = 0; i < lista.length; i++) {
//         lista[i].style.display = 'none';
//     }

//     if (lista.length != 0) {
//         const botao = document.getElementById('botaoO');
//         botao.style.display = 'none';
//         const botaoM = document.getElementById('botaoM');
//         botaoM.style.display = 'flex';
//     }
// }

// function mostrar() {
//     for (let i = 0; i < lista.length; i++) {
//         lista[i].style.display = 'flex';
//     }

//     const botao = document.getElementById('botaoO');
//     botao.style.display = 'flex';
//     const botaoM = document.getElementById('botaoM');
//     botaoM.style.display = 'none';
// }