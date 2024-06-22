function calculo() {
    var peso = Number(input_peso.value);
    var altura = Number(input_altura.value);

    var imc = peso / (altura * altura);
    divMensagem.innerHTML = `Seu IMC: ${imc}`;
}