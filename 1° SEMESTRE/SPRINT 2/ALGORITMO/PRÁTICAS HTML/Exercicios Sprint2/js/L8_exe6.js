function analisar() {
    var nota = Number(input_nota.value);
    var freq = Number(input_freq.value);

    if (nota < 0 || nota > 10) {
        alert('Onde já se viu nota <0 ou >10?!');
        divMensagem.innerHTML = ' ';
    }
    else if (freq < 0 || freq > 100) {
        alert('Onde já se viu frequência <0 ou >100?!');
        divMensagem.innerHTML = ' ';
    }
    else if (nota >= 0 && nota < 6) {
        if (freq >= 75) {
            divMensagem.innerHTML = `Aluno ficou abaixo da média<br>Aluno aprovado por frequência`;
        }
        else {
            divMensagem.innerHTML = `Aluno ficou abaixo da média<br>Aluno reprovado por frequência`;

        }

    }
    else if (nota >= 6 && nota <= 8) {
        if (freq >= 75) {
            divMensagem.innerHTML = `Aluno ficou na média<br>Aluno aprovado por frequência`;
        }
        else {
            divMensagem.innerHTML = `Aluno ficou na média<br>Aluno reprovado por frequência`;
        }
    }

    else if (nota > 8 && nota <= 10) {
        if (freq >= 75) {
            divMensagem.innerHTML = `Aluno acima da média<br>Aluno aprovado por frequência`;
        }
        else {
            divMensagem.innerHTML = `Aluno acima da média<br>Aluno reprovado por frequência`;

        }
    }
}