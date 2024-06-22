function calculo() {
    var n1 = Number(input_n1.value);
    var n2 = Number(input_n2.value);
    var media = (n1 + n2) / 2;

    if (media >= 6) {
        divMesangem.innerHTML = `Parabéns, aprovado`;
    } else {
        divMesangem.innerHTML = `Tente outra vez...`;
    }
}