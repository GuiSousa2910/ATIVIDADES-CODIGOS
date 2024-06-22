var lista = [];

function registrar() {
    var projeto = input_projeto.value;
    lista.push(projeto);
    exibir();
}

function exibir() {
    var profissional = '';

    if (lista.length <= 4) {
        profissional = 'Junior';
    }
    else if (lista.length > 4 && lista.length <= 12) {
        profissional = 'Pleno';
    }
    else {
        profissional = 'Senior';
    }
    divMensagem.innerHTML = `Você ja fez ${lista.length}. Por isso você é um profissional ${profissional} <br>`;
}

function mostrar() {
    var tamanho_lista = lista.length;

    for (var index = tamanho_lista - 1; index >= 0; index--) {

        divMensagem.innerHTML += `${lista[index]} <br>`;
    }
}