function calculo() {
    var meioT = input_meioT.value;
    var km = Number(input_km.value);

    if (km <= 10) {
        if (meioT == 'Carro' || meioT == 'Metrô' || meioT == 'Ônibus') {
            alert('Tá tranks');
        }
        else {
            alert('É... um pouco cansado');
        }
    }
    else {
        if (meioT == 'Carro') {
            alert('É... um pouco cansado');
        }
        else if (meioT == 'Metrô' || meioT == 'Ônibus') {
            alert('Bem cansado');
        }
        else {
            alert('Vish... tá só o pó...');
        }
    }
}