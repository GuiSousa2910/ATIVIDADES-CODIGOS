function analisar() {
    var temperatura = Number(input_temp.value);

    if (temperatura >= 21 && temperatura <= 24) {
        divMensagem.innerHTML = `A temperatura está confortavel`;
    }
    else {
        divMensagem.innerHTML = `A temperatura está desconfortavel`;
    }
}