function calculo() {
    var saldo = Number(input_saldo.value);
    var valorRetirado = Number(input_tirar.value);
    var conta = saldo - valorRetirado;

    if (conta < 0) {
        divMensagemVerm.innerHTML = `<b>O saldo atual da conta corrente é ${conta}</b>`;
    }
    if (conta >= 0) {
        divMensagem.innerHTML = `<b>O saldo atual da conta corrente é  ${conta}</b>`;
    }
}