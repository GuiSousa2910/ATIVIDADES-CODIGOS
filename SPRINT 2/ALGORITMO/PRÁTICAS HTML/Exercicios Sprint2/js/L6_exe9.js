function calculo() {
    var alturaInicial = Number(input_inicial.value);
    var alturaFinal = Number(input_final.value);
    var nome = input_nome.value;
    var altura = Number(input_altura.value);

    if (alturaInicial > 1 && alturaFinal > alturaInicial) {
        divMensagem.innerHTML += `O candidato ${nome}, com altura de ${altura} metros, participará do processo de seleção de piloto`;

        if (altura >= alturaInicial && altura <= alturaFinal) {
            divMensagem.innerHTML += `Infelizmente, o candidato ${nome}, com altura de ${altura} metros, não atende os requisitos da seleção`;
        }
    }
    else {
        alert('Intervalo da altura de seleção é inválida! A altura inicial deve ser maior que 1 e a altura final deve ser maior que a altura inicial');
    }
}