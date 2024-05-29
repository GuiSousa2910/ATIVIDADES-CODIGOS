var lista = [];
var soma = 0;
function cadastrar() {
    var preco = Number(input_preco.value);
    lista.push(preco);
    soma += preco;
}

function atualizar() {
    divMensagem.innerHTML = '';

    for (var i = lista.length - 1; i >= 0; i--) {
        divMensagem.innerHTML += `<br>${lista[i]}`;

    }
    divMensagem.innerHTML += `
        <br>Você tem ${lista.length} produtos cadastrados em estoque 
        <br>Seu estoque vale R$${soma}
        `;
}