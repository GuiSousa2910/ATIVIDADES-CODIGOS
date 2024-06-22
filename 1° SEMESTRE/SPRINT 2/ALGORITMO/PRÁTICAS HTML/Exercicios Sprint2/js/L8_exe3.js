function conta() {
    var tipoPassageiro = select_tipoPassageiro.value;
    var tipoPassagem = select_tipoPassagem.value;
    var precoUnico = 4.4;
    var precoInteg = 5.9;

    if (tipoPassageiro == '1' && tipoPassagem == '1') {

        divMensagem.innerHTML = `Valor da passagem escolhida: R$${precoUnico}`;
    }
    else if (tipoPassageiro == '1' && tipoPassagem == '2') {
        divMensagem.innerHTML = `Valor da passagem: R$${precoInteg}`;
    }

    else if (tipoPassageiro == '2' && tipoPassagem == '1') {
        precoUnico *= 0.5;
        divMensagem.innerHTML = `Valor da passagem escolhida: R$${precoUnico}`;
    }

    else if (tipoPassageiro == '2' && tipoPassagem == '2') {
        precoInteg *= 0.5;
        divMensagem.innerHTML = `Valor da passagem: R$${precoInteg}`;
    }

    else if (tipoPassagem == '1' || tipoPassagem == '2' && tipoPassageiro == '3') {
        divMensagem.innerHTML = `Valor da passagem: R$0`;

    }
}