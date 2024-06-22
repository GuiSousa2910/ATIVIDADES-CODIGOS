function mostrar() {
    var numero = Number(input_numero.value);
    var frase = input_frase.value;
    var texto = '';

    for (var contador = 1; contador <= numero; contador++) {
        texto += frase;
    }

    for (var contador = 0; contador < numero; contador++) {
        alert(texto);
    }
}