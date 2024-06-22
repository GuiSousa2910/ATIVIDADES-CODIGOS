var contador = 3;

function analisar() {
    var nota = Number(input_nota.value);
    var freq = Number(input_freq.value);

    if (nota < 0 || nota > 10) {
        alert('Onde já se viu nota <0 ou >10?!');
        contador -= 1;
        divMensagem.innerHTML = `Você ainda tem ${contador} tentativa(s)`;
    }

    else if (freq < 0 || freq > 100) {
        alert('Onde já se viu frequência <0 ou >100?!');
        contador -= 1;
        divMensagem.innerHTML = `Você ainda tem ${contador} tentativa(s) `;
    }

    if (contador <= 0) {
        divMensagem.innerHTML = '<br>Usúario BLOQUEADO! Procure seu gerente!';
        if (nota > 0 && nota < 10) {
            if (freq >= 75 || freq < 75) {
                divMensagem.innerHTML = '<br>Usúario BLOQUEADO! Procure seu gerente!';
            }
        }
    }
    else if (contador > 0) {
        if (nota >= 0 && nota < 6) {
            if (freq >= 75) {
                divMensagem.innerHTML = `Aluno ficou abaixo da média<br>Aluno aprovado por frequência`;
                contador = 3;
            }
            else {
                divMensagem.innerHTML = `Aluno ficou abaixo da média<br>Aluno reprovado por frequência`;
                contador = 3;

            }

        }
        else if (nota >= 6 && nota <= 8) {
            if (freq >= 75) {
                divMensagem.innerHTML = `Aluno ficou na média<br>Aluno aprovado por frequência`;
                contador = 3;
            }
            else {
                divMensagem.innerHTML = `Aluno ficou na média<br>Aluno reprovado por frequência`;
                contador = 3;
            }
        }

        else if (nota > 8 && nota <= 10) {
            if (freq >= 75) {
                divMensagem.innerHTML = `Aluno acima da média<br>Aluno aprovado por frequência`;
                contador = 3;
            }
            else {
                divMensagem.innerHTML = `Aluno acima da média<br>Aluno reprovado por frequência`;
                contador = 3;
            }
        }
    }

}