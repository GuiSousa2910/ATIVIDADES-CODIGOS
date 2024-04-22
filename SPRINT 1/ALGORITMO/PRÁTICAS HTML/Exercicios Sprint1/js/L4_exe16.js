function calculo() {
    var saldoTotal = Number(input_saldo.value);
    var retirada = Number(input_retirada.value);
    var total = saldoTotal - retirada;

    if (total >= 0) {
        divMensagem.innerHTML = `<p style="color: blue"><i>O saldo atual da conta corrente é ${total}</i> </p>`;
    } else {
        divMensagem.innerHTML = `<p style="color: red"><b>Osaldo atual da conta corrente é ${total}</b> </p>`;
    }
}