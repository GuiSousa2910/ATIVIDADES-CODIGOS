function calculo() {
    var meta = Number(input_meta.value);
    var atual = Number(input_guard.value);
    var ultra = atual - meta;
    var falta = meta - atual;

    if (atual == meta) {
        divMensagem.innerHTML = `Parabéns, meta alcançada!`;
    }
    if (atual > meta) {
        divMensagem.innerHTML = `Parabéns, meta alcançada!<br>Meta ultrapassada em ${ultra}`;
    }
    if (atual < meta) {
        divMensagem.innerHTML = `Força! Ainda em busca da meta! Falta ${falta}`;
    }
}