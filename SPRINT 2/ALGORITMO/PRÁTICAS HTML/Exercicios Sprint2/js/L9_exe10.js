function mostrar() {
    var frase = '';
    var n1 = Number(input_n1.value);
    var n2 = Number(input_n2.value);

    for (contador = n1; contador <= n2; contador++) {
        if (contador % 2 == 0) {
            frase += `${contador}<br>`;
        }
    }
    divMensagem.innerHTML = frase;
}