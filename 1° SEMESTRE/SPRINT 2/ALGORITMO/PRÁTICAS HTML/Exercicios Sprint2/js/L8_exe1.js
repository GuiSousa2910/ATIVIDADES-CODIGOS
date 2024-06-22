function avaliar() {
    var nota = Number(input_nota.value);

    if (nota < 0 || nota > 10) {
        divMensagem.innerHTML = `Nota invalida`;
    }
    else if (nota >= 0 && nota < 5) {
        divMensagem.innerHTML = `Não aprovado`;
    }
    else if (nota >= 5 && nota <= 6) {
        divMensagem.innerHTML = `Neutro`;
    }
    else {
        divMensagem.innerHTML = `Aprovado`;
    }
}