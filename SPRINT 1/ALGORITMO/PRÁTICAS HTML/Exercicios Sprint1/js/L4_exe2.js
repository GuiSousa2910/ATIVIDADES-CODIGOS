var bebidaAno = 0;
function calculo() {
    bebidaAno = input_refri.value * 365;

    if (bebidaAno >= 500) {
        divMensagem.innerHTML = `Quanitadade de refri que você bebe no ano: ${bebidaAno}<br>Cuidado com a diabetes!`;
    }
    if (bebidaAno < 500) {
        divMensagem.innerHTML = `Quanitadade de refri que você bebe no ano: ${bebidaAno}`;
    }
}