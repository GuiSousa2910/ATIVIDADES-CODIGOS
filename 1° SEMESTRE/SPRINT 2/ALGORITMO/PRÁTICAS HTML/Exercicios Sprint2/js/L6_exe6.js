function calculo() {
    var nota = Number(input_nota.value);
    var freq = Number(input_freq.value);

    if (nota >= 6 && freq >= 75) {
        alert('Parabéns! Aprovado!');
    }
    else {
        alert('Infelizmente, não foi desta vez');
    }
}