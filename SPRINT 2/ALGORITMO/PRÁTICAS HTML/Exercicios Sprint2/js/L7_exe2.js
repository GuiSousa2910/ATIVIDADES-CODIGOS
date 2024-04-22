function calculo() {
    var enem = Number(input_enem.value);
    var vest = Number(input_vest.value);

    if (enem >= 800 || vest >= 700) {
        alert('Parabéns! Aprovado');
    }
    else {
        alert('Tente semestre que vem');
    }
}