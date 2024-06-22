var frase = '';
function contar() {
    for (var contador = 1; contador <= 15; contador++) {
        frase += `${contador}<br>`;
    }
    divMensagem.innerHTML = frase;
}