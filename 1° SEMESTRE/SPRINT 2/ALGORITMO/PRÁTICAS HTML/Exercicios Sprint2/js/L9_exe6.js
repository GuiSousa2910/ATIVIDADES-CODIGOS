var frase = '';
function amor() {
    var pessoa = input_amor.value;
    var qntAmor = Number(input_qnt.value);

    for (var contador = 0; contador <= qntAmor; contador++) {
        frase += `${contador}- ${pessoa}<br>`;
    }
    divMensagem.innerHTML = frase;
}