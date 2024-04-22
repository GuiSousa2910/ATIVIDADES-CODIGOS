function calculo() {
    var homem = Number(input_homem.value) * 80;
    var mulher = Number(input_mulher.value) * 60;
    var totalPeso = homem + mulher;

    divMensagem.innerHTML = `<br>Este elevador suporta 800 Kg e o peso estimado desta lotação é de ${totalPeso}kg`;

    if (totalPeso > 800) {
        divMensagemAz.innerHTML = `<br>Será necessário que alguém desça para que o elevador se movimente`;
    }
}