function calculo() {
    var qntChoco = Number(input_chocolate.value);
    var preco = 3;
    var conta = qntChoco * preco;

    if (qntChoco > 12) {
        preco = 2.5;
        conta = qntChoco * preco;
        divMensagem.innerHTML = `o valor da sua compra foi de ${conta}`;
    } else {
        divMensagem.innerHTML = `o valor da sua compra foi de ${conta}`;
    }
}