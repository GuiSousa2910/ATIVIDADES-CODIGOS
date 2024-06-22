function calculo() {
    var freq = Number(input_freq.value);

    if (freq >= 50) {
        divMensagem.innerHTML = `<img src="imagens/376.jpg">`;
    } else {
        divMensagem.innerHTML = ` <img src="imagens/conceito-de-turismo-viagens-e-ferias-feliz-turista-vai-sair-de-ferias-segurando-a-mochila-e-mostrando-o-sinal-de-tudo-bem-sorrindo-satisfeito-em-pe-contra-um-fundo-amarelo.jpg">`;
    }
}