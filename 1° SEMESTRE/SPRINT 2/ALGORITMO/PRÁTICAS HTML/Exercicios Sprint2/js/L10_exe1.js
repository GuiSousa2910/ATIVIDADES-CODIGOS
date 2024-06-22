function gerar() {
    var numeros = Number(input_numero.value);

    var contador_abaixo_metade = 0;
    var contador_maior_metade = 0;

    var menorNumero = 1;
    var maiorNumero = 0;

    var frase = '';
    var media = 0;

    for (var contador = 1; contador <= numeros; contador++) {
        var aleatorio = Math.random();
        media += aleatorio;

        if (aleatorio >= 0.5) {
            contador_maior_metade++;
            frase += `<br> ${aleatorio} - metade SUPERIOR`;
        }
        else {
            contador_abaixo_metade++;
            frase += `<br> ${aleatorio} - metade INFERIOR`;
        }

        if (aleatorio > maiorNumero) {
            maiorNumero = aleatorio;
        }
        else if (aleatorio < menorNumero) {
            menorNumero = aleatorio;
        }
    }

    divMensagem.innerHTML = '';
    divMensagem.innerHTML += `<br><br>Total da metade INFERIOR: ${contador_abaixo_metade}`;
    divMensagem.innerHTML += `<br>Total da metade SUPERIOR: ${contador_maior_metade}`;
    divMensagem.innerHTML += `<br>Total de Numeros mostrados: ${contador_maior_metade + contador_abaixo_metade}`;
    divMensagem.innerHTML += `<br>Media: ${media / numeros}`;
    divMensagem.innerHTML += `<br>Menor Numero: ${menorNumero}`;
    divMensagem.innerHTML += `<br>Maior Numero: ${maiorNumero}`;
}