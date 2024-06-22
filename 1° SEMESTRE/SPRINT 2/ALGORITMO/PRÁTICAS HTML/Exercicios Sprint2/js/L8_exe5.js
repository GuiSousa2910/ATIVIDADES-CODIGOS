function avaliar() {
    var temperatura = input_temperatura.value;
    var umidade = input_umidade.value;

    if (umidade < 0 || umidade > 100) {
        alert('Valor da umidade inválido');
        divMensagem.innerHTML = ` `;
    }
    if (umidade >= 0 && umidade <= 100) {
        if (umidade < 60) {
            if (temperatura >= 22 && temperatura <= 23) {
                divMensagem.innerHTML = `Clima agradavel`;
            }
            else if (temperatura < 22 || temperatura > 23) {
                divMensagem.innerHTML = `Clima desagradavel`;
            }
        }
        else if (umidade >= 60) {
            divMensagem.innerHTML = `Clima desagradavel`;
        }
    }
}