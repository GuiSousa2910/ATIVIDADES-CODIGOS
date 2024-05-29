var lista = [];
function exibir() {
    var musica = input_nomeMusica.value;
    lista.push(musica);
    divMensagem.innerHTML = '';

    for (var i = 0; i < lista.length; i++) {
        divMensagem.innerHTML += `Musica ${i + 1}: ${lista[i]}<br>`;
    }
}

function filtrar() {
    var deopc = Number(de.value);
    var ateopc = Number(ate.value);
    divMensagem2.innerHTML = '';

    for (var i = deopc; i <= ateopc; i++) {
        divMensagem2.innerHTML += `Musica ${i}: ${lista[i - 1]}<br>`;
    }
}