var contador = 0;
function cadastrar() {
    var filme = input_filme.value;
    contador++
    if (contador % 2 == 0) {
        divMensagem.innerHTML += `<p style="color: blue">${filme}</p><br>`;
    }
    else{
        divMensagem.innerHTML += `<p style="color: red">${filme}</p><br>`;
    }
    
}