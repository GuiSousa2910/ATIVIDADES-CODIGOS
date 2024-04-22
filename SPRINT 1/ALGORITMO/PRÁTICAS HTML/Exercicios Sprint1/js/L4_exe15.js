function calculo() {
    var nome = input_nome.value;
    var idade = input_idade.value;
    if (idade >= 18) {
        divMensagem.innerHTML = `${nome}, vamos tirar a CNH?`;
    } else {
        divMensagem.innerHTML = `${nome}, vai jogar Playstation!`;
    }
}