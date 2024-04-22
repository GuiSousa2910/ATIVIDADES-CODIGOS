function calculo() {
    var renda = Number(input_renda.value);
    var rendaFamilia = Number(input_rendaTotal.value);

    if (renda <= 1050 && rendaFamilia <= 2100) {
        divMensagem.innerHTML = `Você terá direito!`;
    }
    else {
        divMensagem.innerHTML = `Você NÃO terá direito`;
    }
}