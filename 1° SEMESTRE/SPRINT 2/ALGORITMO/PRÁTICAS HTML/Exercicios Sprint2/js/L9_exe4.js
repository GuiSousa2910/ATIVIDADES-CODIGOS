function mostrar() {
    for (var contador = 0; contador <= 100; contador++) {
        if (contador % 2 == 0) {
            divMensagem.innerHTML += `${contador}<br>`;
        }
    }
}