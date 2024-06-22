function media() {
    var mediaCon = Number(input_continuada.value) * 0.4
    var mediaSem = Number(input_semestral.value) * 0.6
    var mediaTotal = mediaCon + mediaSem

    alert('A média de ' + input_nome.value + ' será de ' + mediaTotal)
}