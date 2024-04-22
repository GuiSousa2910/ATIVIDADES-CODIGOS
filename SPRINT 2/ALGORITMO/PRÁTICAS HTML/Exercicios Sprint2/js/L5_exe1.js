function calculo() {
    var altura = Number(input_altura.value);

    if (altura <= 165) {
        divMensagem.innerHTML = `Você pode ser piloto de corrida`;
    } else if (altura <= 180) {
        divMensagem.innerHTML = `Você pode ser piloto de futebol`;
    } else if (altura > 180) {
        divMensagem.innerHTML = `Você pode ser jogador de vôlei ou basquete`;
    }
}