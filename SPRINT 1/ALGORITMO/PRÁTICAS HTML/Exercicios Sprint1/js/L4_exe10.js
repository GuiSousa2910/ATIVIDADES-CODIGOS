function calculo() {
    var conta = Number(input_saldo.value);
    if (conta > 0) {
        divMensagem.innerHTML = `<p style="color: blue">Saldo positivo! </p>`;
    }
    if (conta == 0) {
        divMensagem.innerHTML = `Conta zerada`;
    }
    if (conta < 0) {
        divMensagemVerm.innerHTML = `<p style="color: red">Está devendo! </p>`;
    }
}