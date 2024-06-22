var votoCanA = 0;
var votoCanB = 0;
var votoBrancos = 0;
var votoNulos = 0;

function resultadoEleicao() {


    votoCanA = Number(votoA.value);
    votoCanB = Number(votoB.value);
    votoBrancos = Number(votoBranco.value);
    var votoNulos = Number(votoNulo.value);
    var votoInvalidos = votoBrancos + votoNulos;
    var totalVotos = votoCanA + votoCanB + votoInvalidos;

    var votoPorA = (votoCanA * 100) / totalVotos;
    var votoPorB = (votoCanB * 100) / totalVotos;
    var votoPorInv = (votoInvalidos * 100) / totalVotos;

    divMensagem.innerHTML = `<br>Total de votos: ${totalVotos}<br>

Candidato A: ${votoPorA}% (${votoCanA} votos)<br>  

Candidato B: ${votoPorB}% (${votoCanB} votos)<br>  

Inválidos: ${votoPorInv}% (${votoInvalidos} votos)  `;

}