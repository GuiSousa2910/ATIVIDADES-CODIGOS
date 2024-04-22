function calculo() {
    var rendaI = Number(input_renda.value);
    var rendaF = Number(input_familia.value);

    if (rendaI <= 2000 || rendaF <= 3000) {
        divMensagem.innerHTML = `Você terá direito ao auxílio`;
    }
    else {
        divMensagem.innerHTML = `Sem direito ao auxílio`;
    }
}