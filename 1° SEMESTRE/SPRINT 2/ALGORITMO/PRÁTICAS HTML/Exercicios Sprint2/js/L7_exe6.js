function calculo() {
    var meioT = input_meioT.value;

    if (meioT == 'Carro' || meioT == 'Uber') {
        alert('Tá tranquilo...');
    }
    else if (meioT == 'Metrô' || meioT == 'Ônibus') {
        alert('Um pouco cansado');
    }
    else {
        alert('Vish...vive cansado');
    }
}