function calculo() {
    var temp = Number(input_temp.value);

    if (temp < 14) {
        divMensagem.innerHTML = `Congelante`;
    } else if (temp <= 21) {
        divMensagem.innerHTML = `Com frio`;
    } else if (temp <= 24) {
        divMensagem.innerHTML = `Confortavel`;
    } else if (temp <= 31) {
        divMensagem.innerHTML = `Com calor`;
    } else {
        divMensagem.innerHTML = `Calor escaldante`;
    }
}