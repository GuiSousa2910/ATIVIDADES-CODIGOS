function match() {
    var altura = Number(input_altura.value);
    var cor = select_cor.value;

    if (altura < 1.85) {
        if (cor == '3' || cor == '4') {
            divMensagem.innerHTML = `<img src="depositphotos_380564934-stock-illustration-smile-icon-happy-face-symbol.jpg">`;
        }
        else if (cor == '1' || cor == '2') {
            divMensagem.innerHTML = `<img src="images.jpg">`;

        }
    }
    else {
        divMensagem.innerHTML = `<img src="images.jpg">`;
    }
}