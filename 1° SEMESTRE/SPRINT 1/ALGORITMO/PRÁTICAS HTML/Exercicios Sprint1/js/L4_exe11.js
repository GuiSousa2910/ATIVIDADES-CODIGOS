function calculo() {
    var filho = Number(input_filho.value);
    if (filho == 1) {
        divMensagem.innerHTML = `Não tem TV<br>`;
    }
    if (filho == 2) {
        divMensagem.innerHTML = `Não tem TV<br>Não tem internet<br>`;
    }
    if (filho == 3) {
        divMensagem.innerHTML = `Não tem TV<br>Não tem internet<br>Não tem video game<br>`;
    }
    if (filho >= 4) {
        divMensagem.innerHTML = `Não tem TV<br>Não tem internet<br>Não tem video game<br>Não tem Netflix`;
    }
}