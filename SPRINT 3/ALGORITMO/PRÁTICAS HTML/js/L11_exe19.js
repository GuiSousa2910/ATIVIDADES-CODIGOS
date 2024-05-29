var lista = [];
function assistir() {
    var filme = input_filme.value;
    lista.push(filme);
    divMensagem.innerHTML = '';

    for (var i = 0; i < lista.length; i++) {
        divMensagem.innerHTML += `Filme ${i + 1}: ${lista[i]}<br>`;
    }
}

function listar() {
    divMensagem.innerHTML = '';

    for (var i = lista.length - 1; i >= 0; i--) {
        divMensagem.innerHTML += `Filme ${i + 1}: ${lista[i]}<br>`;
    }
}

function filtrar() {
    var de = Number(inputDe.value);
    var ate = Number(inputAte.value);
    divMensagem2.innerHTML = '';

    for (var i = ate; i >= de; i--) {
        divMensagem2.innerHTML += `Filme ${i}: ${lista[i - 1]}<br>`;
    }
}