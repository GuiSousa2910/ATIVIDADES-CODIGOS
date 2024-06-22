frase = '';
function mostrar() {
    var texto = input_frase.value;
    for (var contador = 1; contador <= 7; contador++) {
        frase += `${contador}. ${texto}<br>`;
    }
    divMensagem.innerHTML = frase;
}