lista = [];
function analisar() {
    var numero = Number(input_numero.value);
    lista.push(numero);

    var menorNumero = lista[0];
    var maiorNumero = lista[0];

    divMensagem.innerHTML = '';

    for (var i = 0; i < lista.length; i++) {
        var numero_atual = lista[i];

        if (numero_atual < menorNumero) {
            menorNumero = numero_atual;
        }

        else if (numero_atual > maiorNumero) {
            maiorNumero = numero_atual;
        }
        divMensagem.innerHTML += `${i + 1}º Número: ${numero_atual}<br>`;
    }
    divMensagem.innerHTML += `
        <br>Maior: ${maiorNumero}
        <br>Menor: ${menorNumero}`;

}