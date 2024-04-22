function calculo() {
    var renda = Number(input_renda.value);
    var prestacao = Number(input_prestacao.value);
    var conta = (prestacao / renda) * 100;

    divMensagem.innerHTML = `<br>A prestação corresponde a ${conta}% da renda familiar.<br>`;

    if (conta > 30) {
        divMensagemVerm.innerHTML = `<b>Será necessário complementar a renda familiar</b>`;
    }

}