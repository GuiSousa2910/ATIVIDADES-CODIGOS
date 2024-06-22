function calculo() {
    var nota = Number(input_nota.value);

    if (nota < 5) {
        alert('Aluno precisa de muita ajuda');
    } else if (nota <= 7) {
        alert('Aluno na média');
    } else if (nota <= 9.5) {
        alert('Aluno na acima da média');
    } else if (nota > 9.5) {
        alert('Aluno fora da curva');
    }
}