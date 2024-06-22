var lista = [];
function cadastrar() {
    var bairro = input_bairro.value;
    lista.push(bairro);
}

function relembrar() {
    var numero = Number(input_numero.value);
    divMensagem.innerHTML = '';

    if (numero > lista.length) {
        divMensagem.innerHTML = `Você ainda não morou num ${numero}º bairro!`;
    }else{
        divMensagem.innerHTML += `${lista[numero]}`;
    }
}