var lista = [];
function adicionar() {
    var destino = input_destino.value;

    lista.push(destino);
}

function primeira() {
    if (lista[0] == undefined) {
        divMensagem.innerHTML = 'Ainda não viajou';
    } else {
        divMensagem.innerHTML = lista[0];
    }
}

function terceiro() {
    if (lista[2] == undefined) {
        divMensagem.innerHTML = 'Ainda não fez a terceita viagem';
    } else {
        divMensagem.innerHTML = lista[3];
    }
}
function ultimo() {
    if (lista[lista.length - 1] == undefined) {
        divMensagem.innerHTML = 'Ainda não viajou';
    } else {
        divMensagem.innerHTML = lista[lista.length - 1];
    }
}