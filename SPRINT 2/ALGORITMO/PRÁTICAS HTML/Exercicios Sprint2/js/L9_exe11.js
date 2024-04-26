function correr() {
    var voltas = Number(input_voltas.value);
    var frase = '';

    for (var contador = 1; contador <= voltas; contador++) {
        frase += `Carro dando a ${contador}ª volta <br>`;
        if (contador == voltas) {
            frase += `Corrida finalizada!`;
        }
    }
    divMensagem.innerHTML = frase;
}