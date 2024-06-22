var preco = 4.40;
var valorPagar = 0;

function calculo() {
    var qntPa = Number(input_qntPa.value);

    if (qntPa < 8 && qntPa > 50) {
        alert('Quantidade inválida para o Fidelidade!');
    }

    else if (qntPa >= 8 && qntPa <= 50) {
        alert('1 ' + preco);
        if (qntPa >= 8 && qntPa <= 19) {
            preco *= 0.97;
            valorPagar = qntPa * preco;
            alert('2 ' + preco);
        }
        if (qntPa >= 20 && qntPa <= 49) {
            preco *= 0.95;
            valorPagar = qntPa * preco;
        }
        if (qntPa == 50) {
            preco *= 0.93;
            valorPagar = qntPa * preco;
        }
        divMensagem.innerHTML = `Total a pagar: R$${valorPagar}`;
    }
}