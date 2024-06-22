function ver() {
    var coca = Number(input_coca.value);
    var frase = '';

    for (var contador = 1; contador <= coca; contador++) {
        frase += '🥤';
    }
    divMensagem.innerHTML = frase;
}