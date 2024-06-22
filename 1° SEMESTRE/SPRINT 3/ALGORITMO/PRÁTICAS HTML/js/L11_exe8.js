var lista = [];
function cadastrar() {
    var alunos = input_alunos.value;
    lista.push(alunos);
    divMensagem.innerHTML = '';

    for (var index = lista.length; index > 0; index--) {
        divMensagem.innerHTML += `${lista[index - 1]}<br>`;
    }
}