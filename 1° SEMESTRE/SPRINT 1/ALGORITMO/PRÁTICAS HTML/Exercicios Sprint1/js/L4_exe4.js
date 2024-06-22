function calculo() {
    var amigos = Number(input_amigos.value);
    var valor = Number(input_valor.value);

    var valorCada = valor / amigos;

    divMensagem.innerHTML = `Cada amigo vai pagar R$${valorCada} pela pizza`;

    if (valorCada > 20) {

        divMensagem.innerHTML = `Cada amigo vai pagar R$${valorCada} pela pizza <br> Deu ruim! Pizza muito cara!`;
    }
}