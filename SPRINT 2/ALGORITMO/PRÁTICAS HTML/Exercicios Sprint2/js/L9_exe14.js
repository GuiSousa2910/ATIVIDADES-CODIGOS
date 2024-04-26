function mostrar() {
    var frase = '';
    var idade = Number(input_idade.value);

    for (var contador = 0; contador <= idade; contador++) {
        if (contador >= 0 && contador <= 4) {
            frase += `${contador} anos (Primeira Infância)<br>`;
        }
        else if (contador > 4 && contador <= 6) {
            frase += `${contador} anos (Pré-escolar)<br>`;
        }
        else if (contador > 6 && contador <= 10) {
            frase += `${contador} anos (Segunda infância)<br>`;
        }
        else if (contador > 10 && contador <= 18) {
            frase += `${contador} anos (Adolescência)<br>`;
        }
        else if (contador > 18 && contador <= 50) {
            frase += `${contador} anos (Adulto)<br>`;
        }
        else if (contador > 50 && contador <= 100) {
            frase += `${contador} anos (Melhor idade)<br>`;
        }
        else if (contador > 100) {
            frase += `${contador} anos (Matusalém)<br>`;
        }
    }
    divMensagem.innerHTML = frase;

}