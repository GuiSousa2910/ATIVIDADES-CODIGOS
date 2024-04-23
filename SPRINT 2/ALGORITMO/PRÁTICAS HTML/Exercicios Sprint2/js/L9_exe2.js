var frase = '';
function mostrar() {
    for (var contador = 1; contador <= 7; contador++) {
        frase += `Eu gosto da materia de algoritmos<br>`;
    }
    divMensagem.innerHTML = frase;
}