function ver() {
    var qntCafeLeite = Number(input_cafeLeite.value);
    var coLeite = 0;
    var coCafe = 0;

    for (var contador = 1; contador <= qntCafeLeite; contador++) {
        coLeite++;
        coCafe += 2;
    }
    divMensagem.innerHTML = `${coLeite} colheres com leite em pó e ${coCafe} colheres de café em pó`;
}