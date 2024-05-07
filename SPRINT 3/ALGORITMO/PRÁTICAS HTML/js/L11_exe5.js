var lista = [];
var contador = 0;
function cadastrar() {
    var filme = input_filme.value;
    contador++;
    lista.push(filme);
    if (lista.length > 2) {
        divMensagem.innerHTML = `
      Seu filme favorito: ${lista[0]}<br>

  Seu 3º filme favorito: ${lista[2]} <br>

  Total de filmes cadastrados: ${contador}<br>
    `;
    } else {
        divMensagem.innerHTML = `
      Seu filme favorito: ${lista[0]}<br>

  Seu 3º filme favorito: Ainda não existe<br>

  Total de filmes cadastrados: ${contador}<br>
    `;

    }
}