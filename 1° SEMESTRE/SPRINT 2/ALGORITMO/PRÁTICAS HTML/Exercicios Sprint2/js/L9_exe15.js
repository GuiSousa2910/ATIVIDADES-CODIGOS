function verificar() {
    var frase = '';
    var passageiro = Number(input_qntPassageiro.value);

    for (var contador = 1; contador <= passageiro; contador++) {
        if (contador == 1) {
            frase += 'Entrou o 1º passageiro (que é o(a) motorista)<br>';
        }
        else if (contador <= 5 && contador > 1) {
            frase += `Entrou o ${contador}º passageiro<br>`;
        }
        else if (contador > 5) {
            frase += `O passageiro ${contador} terá que esperar<br>`;
        }
    }
    divMensagem.innerHTML = frase;
}