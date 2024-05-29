var lista = [];

function cadastrar() {
    var nome = input_nome.value;

    if (lista.indexOf(nome) != -1) {
        alert('Não pode cadastrar 2 filhos');
    }
    else if (lista.indexOf(nome) == -1) {
        lista.push(nome);
    }
}

function analisar() {
    divMensagem.innerHTML = `
        Você tem ${lista.length} filhos <br> 
        Seu custo mensal será aproximadamente R$${lista.length * 3000} se colocá-los em escola particular ou R$${lista.length * 1500} se eles estudarem em escola pública`;
}