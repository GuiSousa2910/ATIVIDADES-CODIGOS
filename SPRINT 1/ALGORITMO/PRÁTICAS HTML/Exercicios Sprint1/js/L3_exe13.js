function calcular() {

    var totalViagens = Number(input_viagens.value);
    var viagemOnibus = totalViagens * 0.9;
    var viagemCarro = totalViagens * 0.1;

    var precoOnibus = viagemOnibus * Number(input_valor.value);

    var precoKmCarro = Number(input_distancia.value) * 0.75;
    var precoCarro = viagemCarro * precoKmCarro;
    var precoTotal = precoCarro + precoOnibus;

    divMensagem.innerHTML = `Você vai gastar R$${precoTotal} por mês com transporte.`;
}