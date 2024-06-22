var saldo = 0

function depositar() {
    var deposito = Number(input_deposito.value)
    var saldo = saldo + deposito
    alert('Depósito de R$'+ deposito +' efetuado! Saldo atual: R$'+ saldo) 
    input_deposito.value = deposito
}

function retirar() {
    var deposito = Number(input_deposito.value)
    var saldo = saldo - deposito
    alert('Retirada de R$' + deposito + ' efetuada! Saldo atual: R$' + saldo)
    input_deposito.value = deposito
}