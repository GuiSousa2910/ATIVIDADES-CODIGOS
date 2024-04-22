function calculo() {
    var kwhMes = Number(input_luz.value);
    var precoMes = kwhMes * 0.85;

    if (kwhMes < 100) {
        precoMes = precoMes * 0.90;
        alert('Valor da conta: ' + precoMes);
    }
    if (kwhMes >= 100) {
        alert('Valor da conta: ' + precoMes);
    }
}