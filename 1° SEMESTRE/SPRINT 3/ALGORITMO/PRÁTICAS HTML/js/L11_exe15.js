listaNome = [];
listaPreco = [];

function cadastrar() {
    var produto = input_produto.value;
    var preco = Number(input_compra.value);

    listaNome.push(produto);
    listaPreco.push(preco);
}

function relatar() {
    divMensagem.innerHTML = ``;
    var contador = 0;

    divMensagem.innerHTML = `Total Produtos: ${listaNome.length}<br>`;

    for (var i = 0; i < listaNome.length && i < listaPreco.length; i++) {
        contador++;

        divMensagem.innerHTML += `
            Produto ${contador}: ${listaNome[i]} <br>
            Preço de compra: R$${listaPreco[i]}. Vender por R$${listaPreco[i] * 1.25}<br>`;

    }
}