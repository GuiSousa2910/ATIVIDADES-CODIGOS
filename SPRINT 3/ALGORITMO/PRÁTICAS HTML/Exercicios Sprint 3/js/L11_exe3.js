var lista = [];
function cadastrar() {
    var bairro = input_bairro.value;

    lista.push(bairro);
}

function relembrar() {
    var numero = Number(input_numero.value);

    if (numero > lista.length) {
        divMensagem.innerHTML = ''
        divMensagem.innerHTML = `Você ainda não morou num ${numero}º bairro!`
    }
    divMensagem.innerHTML += `${lista[numero]}`;
}