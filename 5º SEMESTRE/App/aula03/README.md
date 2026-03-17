Exercício 1 – Contadora
--------------------------

### O que o app deve fazer

O aplicativo deve:

*   **Sortear um número aleatório** (entre 1 e 10).
*   Permitir que o usuário clique em um botão para **incrementar um contador**.
*   **Verificar** se o contador chegou exatamente ao valor do numero sorteado.
*   Quando acertar, **mostrar uma segunda tela** com uma mensagem de parabéns e a quantidade de cliques.

### Regras importantes

*   O **contador deve começar em 0**.
*   A **navegação para a segunda tela** só pode acontecer quando o valor do contador for **exatamente igual** à soma.

### Dicas de implementação

*   **Onde sortear os números**:
    *   Logo que a tela for carregada, você pode sortear o numero
*   **Botão de incrementar**:
    *   No `onPress`, incremente o contador.
    *   Atualize também o número de cliques.
*   **Tela de resultado**:
    *   Crie uma segunda tela que receba o numero sorteado.

* * *

Exercício 2 – Controle de Sprint (Lista de Tarefas)
---------------------------------------------------

### O que o app deve fazer

Você vai criar um aplicativo onde o usuário gerencia tarefas de uma sprint, marcando quais foram finalizadas e vendo um **resumo** ao final.

O app terá **2 telas**:

1.  **Tela de Tarefas da Sprint**
2.  **Tela de Resumo da Sprint**

### Tela inicial – Tarefas da Sprint

*   Utilize as tarefas criadas no arquivo (tarefas.json localizado no diretório do exercício).  
      
    
*   Cada tarefa tem :
    *   **id**
    *   **titulo**
    *   **descricao**
    *   **concluido** (boolean: `true` ou `false`)

Na tela devem aparecer:

*   **Título da tarefa**
*   **Status** (Concluido / Pendente)
*   **Botão** para marcar ou desmarar como finalizada
*   **Botão "Finalizar Sprint"**
*   A lista deve ser renderizada usando **`map`**.

### Comportamento esperado

*   Ao clicar em **marcar**:
    *   A da tarefa deve ser atualizado para concluida .
    *   O **layout** deve mudar visualmente (por exemplo, cor diferente para tarefa concluída).
*   Ao clicar em **"Finalizar Sprint"**:
    *   O usuário deve ser **redirecionado para a tela de resumo**.

### Tela de Resumo da Sprint

Essa tela deve exibir:

*   **Total de tarefas** da sprint.
*   **Quantidade de tarefas finalizadas.**
*   **Quantidade de tarefas pendentes.**
*   **Percentual de conclusão.**

Exemplo:

*   “4 de 6 tarefas concluídas”
*   “66% da sprint finalizada”

Também deve exibir uma **mensagem dinâmica**, por exemplo:

*   Se 100%:
    *   “Sprint concluída com sucesso!”
*   Se menos de 50%:
    *   “Atenção! Muitas tarefas ficaram pendentes.”
*   Caso contrário:
    *   “Bom progresso, mas ainda pode melhorar.”

### Regras importantes

*   **Utilizar navegação entre telas.**
*   **Não perder o estado das tarefas ao navegar.**
*   A **porcentagem** deve ser calculada dinamicamente.
*   A renderização deve usar **`map`**.
*   Utilizar **`useState`** para controlar as tarefas.

### Dicas de implementação

*   *   Não precisa em se preocupar com a interface, apenas implementar a lógica, pois os componentes já estão ajustado para refletir os dados. Basta apenas passsar a tarefa com atributo do JSON concluido ou não.

* * *

(Difícil) Exercício 3 – Mini E-commerce (React Native)
------------------------------------------------------

### Parte 1 – Lista e Detalhes de Produtos

### O que o app deve fazer

O aplicativo deve:

*   Ler uma lista de produtos a partir de um **JSON local**.
*   Exibir esses produtos em **formato de lista**.
*   Permitir que o usuário clique em **"Ver mais"**.
*   Enviar os dados do produto selecionado para **outra tela**.
*   Mostrar todas as informações detalhadas do produto na segunda tela.

Se tudo estiver correto, o usuário conseguirá **navegar entre lista e detalhes**.

### Ao abrir o app

*   Carregar os dados do arquivo de produtos (JSON local).
*   Renderizar a lista de produtos.
*   Exibir apenas **informações resumidas** na tela inicial.

### O que deve aparecer na tela inicial

Para cada produto:

*   **Nome do produto**
*   **Preço do produto**
*   Botão com o texto: **“Ver mais”**

Quando o usuário tocar em **"Ver mais"**:

*   Deve ser **redirecionado** para a tela de detalhes.
*   Os dados do produto devem ser enviados usando **parâmetros de rota**.

### Tela de Detalhes

Essa tela deve mostrar:

*   Nome do produto.
*   Preço.
*   Descrição.

### Regras importantes

*   Os dados devem vir de um **JSON local** (não usar API).
*   Deve ser enviado o id do produto e importar o JSON para achar o produto que foi selecionado

### Dicas de implementação (lista e detalhes)

*   **Lista**:
    *   Importe o JSON com os produtos.
    *   Use `map` para renderizar um componente de item (por exemplo, um card) para cada produto.
*   **Botão “Ver mais”**:
    *   Ao clicar, navegue para a rota de detalhes enviando o `id` (e/ou os dados completos do produto).
*   **Tela de detalhes**:
    *   Recupere o `id`/dados recebidos via rota.
    *   Localize o produto correspondente no JSON.
    *   Substitua textos fixos pelos dados reais.

* * *

### Parte 2 – Mini E-commerce (Carrinho de Compras) (Desafio)

Agora você vai **continuar o mini e‑commerce**, adicionando uma funcionalidade de **carrinho de compras**, garantindo que os dados não sejam perdidos ao navegar entre telas.

### O que o app deve fazer

1.  **Adicionar ao carrinho**
    
    *   Criar um campo para o usuário digitar o **ID do produto**.
    *   Criar um botão **"Adicionar ao Carrinho"**.
    *   Validar se o ID existe.
    *   Se existir → adicionar o produto ao carrinho.
    *   Se não existir → exibir mensagem de erro.
2.  **Exibir carrinho**
    
    *   Na mesma tela, exibir uma seção **"Carrinho"** contendo:
        *   Nome do produto.
        *   Preço.
    *   A renderização do carrinho deve ser feita com **`map`**.
3.  **Regra importante**
    
    *   Se o usuário:
        *   Entrar na tela de detalhes.
        *   Voltar para a lista.
    *   A seção de carrinho deve aparecer tanto na tela de produtos quanto na tela de detalhes.
    *   **O carrinho não pode perder os produtos adicionados.**

### Dicas de implementação (carrinho)

*   **Onde guardar o carrinho**:
    *   Use um **layout do Expo Router** (por exemplo, `_layout.jsx` dentro da pasta do mini e‑commerce) para manter o estado do carrinho
    *   Use o componente Container para o layout ficar bem ajustado
