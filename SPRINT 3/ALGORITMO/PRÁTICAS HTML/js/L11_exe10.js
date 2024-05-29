lista = [];
function gravar() {
    var onibus = input_onibus.value;
    lista.push(onibus);
    var tamanho = lista.length;
    divMensagem.innerHTML = '';

    for (var i = tamanho - 1; i >= 0; i--) {
        divMensagem.innerHTML += `${lista[i]} <br>`;
    }
}

function pesquisar() {
    var linha = input_linha.value;
    var cont = 0;

    if (lista.indexOf(linha) == -1) {
        alert('Você nunca pegou essa linha!!');
    }
    else {
        var lista2 = [];

        for (var i = 0; i < lista.length; i++) {

            if (lista[i] == linha) {
                cont++;
                lista2.push(i + 1);
                divMensagem.innerHTML = `Você já pegou essa linha ${cont} vezes, nessa ordem: ${lista2}`;
            }
        }
    }
}