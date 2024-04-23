var frase = '';
function mostrar() {
    var numero = Number(input_numero.value);
    for (var contador = 0; contador <= numero; contador++) {
        if ((contador % 5) == 0) {
            frase += `${contador}<br>`;
        }
    }
    divMensagem.innerHTML = `${frase}`;
}