function receber() {
    var saldo = Number(input_saldo.value);
    var saldo = saldo + 100;
    alert("Transferência de R$100 recebida! Saldo atual: R$" + saldo);                
    input_saldo.value = saldo
}

function pagar() {
    var saldo = Number(input_saldo.value)
    var saldo = saldo - 50
    alert("Pagamento de R$50 efetuado! Saldo atual: R$" + saldo);
    input_saldo.value = saldo
}