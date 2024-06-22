function calcular() {
    var qntDeposito = Number(input_deposito.value);
    var valor = Number(input_valor.value);
    frase = '';

    var saldo = 0;

    for (var contador = 1; contador <= qntDeposito; contador++) {
        saldo += valor;

        if ((contador % 3) == 0) {
            saldo *= 1.01;
        }

        frase += `${contador}º Mês: R$ ${saldo}<br>`;
    }
    divMensagem.innerHTML = frase;
}