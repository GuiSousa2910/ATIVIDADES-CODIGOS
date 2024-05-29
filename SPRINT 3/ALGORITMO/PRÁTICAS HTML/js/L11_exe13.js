var lista = [];
var contV = 0;
var contE = 0;
var contD = 0;
var contDeV = 0;
var contDeE = 0;
var contDeD = 0;

function registrar() {
    var soma = 0;
    var resultado = select_resultados.value;

    if (resultado == '1') {
        lista.push(3);
        contV += 3;
        contDeV += 1;
    }
    else if (resultado == '2') {
        lista.push(1);
        contE += 1;
        contDeE += 1;
    }
    else if (resultado == '3') {
        lista.push(0);
        contD += 0;
        contDeD += 1;
    }

    soma += contV + contE + contD;

    for (var i = 0; i < lista.length; i++) {
        var element = lista[i];
    }

    var aproveitamento = contV / (contV + contE + contD * 100);;

    divMensagem.innerHTML = `O time teve: ${contDeV} vitórias, ${contDeE} empates, ${contDeD} derrotas <br> Pontuação total: ${soma} pontos<br> Aproveitamento: ${aproveitamento * 100}%`;
}

function escrever() {
    var jogo = Number(input_jogo.value);
    var palavraJogo = '';

    if (lista[jogo - 1] == 3) {
        palavraJogo = 'ganhou';
        divMensagem2.innerHTML = `<br><br> No ${jogo}º jogo, o time ${palavraJogo}`;
    }

    else if (lista[jogo - 1] == 1) {
        palavraJogo = 'empatou';
        divMensagem2.innerHTML = `<br><br> No ${jogo}º jogo, o time ${palavraJogo}`;
    }

    else if (lista[jogo - 1] == 0) {
        palavraJogo = 'perdeu';
        divMensagem2.innerHTML = `<br><br> No ${jogo}º jogo, o time ${palavraJogo}`;
    }

    else if (lista[jogo - 1] == undefined) {
        divMensagem2.innerHTML = `Não foi cadastrado um ${jogo}º jogo`;
    }
}