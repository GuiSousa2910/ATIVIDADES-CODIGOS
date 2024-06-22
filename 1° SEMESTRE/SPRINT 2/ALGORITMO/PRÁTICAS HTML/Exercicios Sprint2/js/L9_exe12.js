function calcular() {
    var inicioTabu = Number(input_tabuada.value);
    var fimTabu = Number(input_final.value);
    var frase = '';

    for (var contador = 1; contador <= fimTabu; contador++) {
        frase += `${inicioTabu} x ${contador} = ${inicioTabu * contador} <br>`;
    }
    divMensagem.innerHTML = frase;
}   