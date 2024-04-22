function calculo() {
    var marca = input_marca.value;
    var preco = Number(input_preco.value);

    if (preco < 800 || preco > 2000) {
        divMensagem.innerHTML += `TV fora da faixa de preço`;
        if (preco < 800) {
            divMensagem.innerHTML += `<br>Preço baixo demais!`;
        }
        else {
            divMensagem.innerHTML += `<br>TV cara demais, infelizmente`;
        }
    }
    if (preco >= 800 && preco <= 2000) {
        if (marca == 'Mondial' || marca == 'Britânia') {
            divMensagem.innerHTML = `Na faixa de preço, porém marca não confiável`;
        }
        else {
            divMensagem.innerHTML = `Essa TV pode entrar na sua lista!`;
        }
    }
}