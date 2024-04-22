function calculo() {
    var nota = Number(input_nota.value);

    if (nota < 6) {
        divMensagem.innerHTML = `Aluno reprovado`;
    }
    else if (nota >= 6 && nota < 8.5) {
        divMensagem.innerHTML = `Aluno comum e aprovado`;
    }
    else {
        divMensagem.innerHTML = `Aluno Exemplar!`;
    }
}