function pesquisar() {
    var listaFrutas = ['Banana', 'Laranja', 'Maçã'];
    var fruta = input_fruta.value;

    if (listaFrutas.indexOf(fruta) >= 0) {
        divMensagem.innerHTML = `A fruta ${fruta} existe na lista.`
    }else{
        divMensagem.innerHTML = `A fruta ${fruta} não existe na lista.`
    }
}