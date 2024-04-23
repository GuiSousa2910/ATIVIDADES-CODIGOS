var frase = '';

function calcular() {
    var numero = Number(input_numero.value);

    for (contador = 0; contador <= numero; contador++) {
        if (contador % 7 == 0) {
            frase += `${contador}<br>`;
        }
    }
    divMensagem.innerHTML = frase;
}