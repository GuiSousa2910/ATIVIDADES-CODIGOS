function calculo() {
    var renda = Number(input_renda.value);

    if (renda <= 250) {
        divMensagem.innerHTML = `Classe E`;
    } else if (renda <= 900) {
        divMensagem.innerHTML = `Classe D`;
    } else if (renda <= 2500) {
        divMensagem.innerHTML = `Classe C`;
    } else if (renda <= 9500) {
        divMensagem.innerHTML = `Classe B`;
    } else if (renda > 9500) {
        divMensagem.innerHTML = `Classe A`;
    }
}