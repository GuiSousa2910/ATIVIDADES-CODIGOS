function calculo() {
    var peso = Number(input_peso.value);

    if (peso <= 13.5) {
        divMensagem.innerHTML = `Abaixo do peso`;
    } else if (peso <= 21.2) {
        divMensagem.innerHTML = `Peso médio`;
        if (peso == 18.3) {
            divMensagem.innerHTML = `Peso perfeito`;
        }
    } else if (peso > 21.2) {
        divMensagem.innerHTML = `Acima do peso`;
    }
}