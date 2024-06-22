var listaNome = [];
var listaPreco = [];
function cadastrar() {
    var nome = input_produto.value;
    var preco = Number(input_preco.value);

    if (preco >= 0 && nome.length >= 3) {
        listaNome.push(nome);
        listaPreco.push(preco);
    }
    else {
        divMensagem.innerHTML = 'Errou';
    }
}

function atualizar() {
    var preco = 0;
    for (var i = 0; i < listaNome.length; i++) {
        preco += listaPreco[i];
        divMensagem.innerHTML = `
            Você tem ${listaNome.length} produtos cadastrados em estoque: <br><br>`;

        divMensagem2.innerHTML += `
            ${i + 1}. ${listaNome[i]} - R$${listaPreco[i]}<br>
            `;

        divMensagem3.innerHTML = `<br>Seu estoque vale ${preco}`;
    }
}

function filtrar() {
    var valor = input_valor.value;
    var select = select_valores.value;

    for (var i = 0; i < listaNome.length; i++) {
        if (select == '1') {
            if (listaPreco[i] > valor) {
                divMensagem4.innerHTML += `${i + 1}. ${listaNome[i]} - R$${listaPreco[i]}<br>`;
            }
            else {

            }
        }
        if (select == '2') {
            if (listaPreco[i] < valor) {
                divMensagem4.innerHTML += `${i + 1}. ${listaNome[i]} - R$${listaPreco[i]}<br>`;
            }
            else {

            }
        }
    }
}