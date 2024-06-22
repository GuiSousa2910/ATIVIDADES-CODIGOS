function calcular() {

    var sabor = input_sabor.value
    var caixinha = Number(input_preco.value) * 0.1
    var preco = Number(input_preco.value) + caixinha
    var amigo = Number(input_amigos.value)
    var dividir = preco/amigo

    divMensagem.innerHTML = `Cada amigo vai colaborar com R$${dividir} para a pizza de ${sabor}`
}