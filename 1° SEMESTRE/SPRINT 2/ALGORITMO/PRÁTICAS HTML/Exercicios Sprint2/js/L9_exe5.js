var frase = '';
function mostrar() {
    for (var contador = 1; contador <= 30; contador++) {
        if (contador == 3) {

        }
        else if (contador == 4) {

        }
        else if (contador == 7) {

        }
        else if (contador == 10) {

        }
        else if (contador == 12) {

        }
        else {
            frase += `${contador}<br>`;
        }

    }
    divMensagem.innerHTML = frase;
}