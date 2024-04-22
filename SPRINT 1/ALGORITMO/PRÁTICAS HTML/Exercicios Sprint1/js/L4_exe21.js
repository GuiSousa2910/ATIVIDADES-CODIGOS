function calculo() {
    var homem = Number(input_homens.value);
    var mulher = Number(input_mulher.value);
    var pesoH = homem * 90;
    var pesoM = mulher * 70;
    var total = pesoH + pesoM;

    if (total >= 500) {
        elevador = total - 500;
        divMensagem.innerHTML = `Precisa perder ${elevador}kg para mover o elevador`;
    } else {
        divMensagem.innerHTML = ` Elevador vai se mover, pois está com ${total} kg`;
    }
}