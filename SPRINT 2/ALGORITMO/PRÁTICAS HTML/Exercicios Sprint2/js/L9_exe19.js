function calcular() {
    var qntDeposito = Number(input_deposito.value);
    var valor = Number(input_valor.value);

    divMensagem.innerHTML = '';

    // var saldo = 0;

    for (var contador = 1; contador <= qntDeposito; contador++) {
        var mult = contador * valor;
        // saldo += valor
        divMensagem.innerHTML += `${contador}º Mês: R$ ${mult}<br> `;
    }
    divMensagem.innerHTML += `Total guardado: ${mult}`;

}