function atazanar() {
    var elefante = Number(input_elefante.value);
    var texto = '';
    divMensagem.innerHTML = '';

    for (var contador = 2; contador <= elefante; contador++) {
        divMensagem.innerHTML += `<br> 1 elefante incomoda muita gente`;
        texto += `incomodam `;
        divMensagem.innerHTML += `<br> ${contador} elefantes ${texto} muito mais!`;
    }
}