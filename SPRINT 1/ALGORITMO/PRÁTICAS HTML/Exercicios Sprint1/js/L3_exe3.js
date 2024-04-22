function economia() {
    var estudante = Number(input_valor.value) / 2
    var normal = input_valor.value * input_viagem.value
    var estudanteEco = estudante * input_viagem.value
    var economiaMes = normal - estudanteEco

    alert('Você economizará R$' + economiaMes + ' por mês')
}