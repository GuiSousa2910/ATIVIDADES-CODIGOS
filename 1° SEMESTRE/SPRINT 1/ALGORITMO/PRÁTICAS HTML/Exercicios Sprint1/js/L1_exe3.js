function processarDocumento() {
    // Obtém o valor do documento como texto
    var documentoTexto = documento.value;
    
    // Gera uma versão numérica do documento
    var documentoNumerico = Number(documentoTexto);
    
    // Soma 100 ao valor numérico
    var resultado = documentoNumerico + 100;
    
    // Exibe o resultado
    document.getElementById('resultado').innerHTML = 
        '<p>Documento original (texto): ' + documentoTexto + '</p>' +
        '<p>Versão numérica: ' + documentoNumerico + '</p>' +
        '<p>Versão numérica + 100: ' + resultado + '</p>';
}
