function exibir() {
    var musculacao = Number(input_musculo.value);
    var frase = '';

    for (var contador = 1; contador <= 30; contador++) {
        frase += `Dia ${contador} - Musculação <br>`;
        for (var contar = 2; contar <= musculacao; contar++) {
            frase += `Dia ${contar} - Comer, dormir etc <br>`;
        }
    }
    divMensagem.innerHTML = frase;
}