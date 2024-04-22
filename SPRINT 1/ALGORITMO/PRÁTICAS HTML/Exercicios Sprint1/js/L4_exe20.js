function calculo() {
    var temp = Number(input_temp.value);

    if (temp >= 10) {
        divMensagem.innerHTML = `<img src="imagens/49580.jpg">`;
    } else {
        divMensagem.innerHTML = `<img src="imagens/14640.jpg">`;
    }
}