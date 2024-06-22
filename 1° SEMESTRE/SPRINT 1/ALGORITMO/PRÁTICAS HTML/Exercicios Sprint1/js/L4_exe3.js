var n1 = 0;
var n2 = 0;
var n3 = 0;
var media = 0;

function calculo() {
    var n1 = Number(input_n1.value);
    var n2 = Number(input_n2.value);
    var n3 = Number(input_n3.value);

    media = (n1 + n2 + n3) / 3;

    if (media < 9.4) {
        divMensagem.innerHTML = `Sua média foi de ${media}`;
    }

    if (media >= 9.4) {
        divMensagem.innerHTML += `Sua média foi de ${media}`;
        divMensagem.innerHTML += `<br>Parabéns, você é fora de série!`;
    }
}  