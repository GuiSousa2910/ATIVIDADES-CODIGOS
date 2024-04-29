lista = [];
contador = 0;

function cadastrar() {
    var filme = input_filme.value;
    lista.push(filme);
    contador++;
}

function favoritos() {
    divMensagem.innerHTML += lista;
    divMensagem.innerHTML += `<br> Total: ${contador}`;
    divMensagem.innerHTML += `<br><br>
    O que filme que mais gosta é ${lista [0]}.<br>

    E desses, o que menos gosta é ${lista [lista.length - 1]} `;
}