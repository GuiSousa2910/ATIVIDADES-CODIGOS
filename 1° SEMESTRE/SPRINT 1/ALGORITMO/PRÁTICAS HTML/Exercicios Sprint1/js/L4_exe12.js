function calculo() {
    peso = Number(input_peso.value);
    if (peso < 500) {
        divMensagem.innerHTML = `Elevador vai se mover`;
    } else {
        divMensagem.innerHTML = `Alguém precisa descer do elevador`;
    }
}