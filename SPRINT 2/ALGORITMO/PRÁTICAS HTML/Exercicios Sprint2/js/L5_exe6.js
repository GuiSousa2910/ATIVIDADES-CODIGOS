function calculo() {
    var time = input_time.value;

    if (time == 'Corinthians') {
        divMensagem.innerHTML = `<p class ="corin">Salve o Corinthians</p>`;
    } else if (time == 'Palmeiras') {
        divMensagem.innerHTML = `<p class ="pal">Salve o alviverde imponente</p>`;
    } else if (time == 'Santos') {
        divMensagem.innerHTML = `Agora quem dá a bola é o Santos`;
    } else if (time == 'São Paulo') {
        divMensagem.innerHTML = `<p class ="sp">Salve o Tricolor Paulista</p>`;
    }
}