function analisar() {
    var modoP = input_modo.value;

    if (modoP == 'Dinheiro' || modoP == 'Débito') {
        divMensagem.innerHTML = `Você terá de pagar a vista`;
    }
    else {
        divMensagem.innerHTML = `Pagamento poderá ser parcelado`;
    }
}