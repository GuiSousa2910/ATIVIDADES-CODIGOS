function calculo() {
    var horaNet = Number(input_horaNet.value);

    if (horaNet >= 19 && horaNet <= 21) {
        divMensagem.innerHTML = `Não é recomendável que você assista sua série favorita no horário ${horaNet}!`;
    }
    else {
        divMensagem.innerHTML = `O horário ${horaNet} é adequado para assistir sua série favorita!`;
    }
}