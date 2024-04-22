function calculo() {
    var temp = Number(input_temp.value);

    if (temp < 21 || temp > 24) {
        alert('Alerta de desconforto!');
        if (temp < 21) {
            alert('As pessoas vão ter hipotermia');
        }
        if (temp > 24) {
            alert('As pessoas vão derreter');
        }
    }
}