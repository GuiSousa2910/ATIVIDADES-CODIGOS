function calculo() {
    var serie = input_sitcom.value;
    var totalEp = Number(input_ep.value) * 22;
    divMensagem.innerHTML = `Vejo que você gosta da série ${serie}`;

    if (totalEp > 1800) {
        divMensagem.innerHTML = `Vejo que você gosta da série ${serie}<br>Uau, você realmente gosta dessa série!`;
    }
}