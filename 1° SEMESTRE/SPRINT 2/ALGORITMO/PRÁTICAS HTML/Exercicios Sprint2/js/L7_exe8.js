function calculo() {
    var nome = input_nomeE.value;
    var bolsa = Number(input_bolsa.value);
    var vr = Number(input_vr.value);
    var dist = Number(input_dist.value);

    if (bolsa >= 1800 || vr >= 20 || dist <= 30) {
        divMensagem.innerHTML = `A empresa ${nome} é uma de suas preferências`;
    }
    else {
        divMensagem.innerHTML = `A empresa ${nome} está fora da sua lista`;
    }
}