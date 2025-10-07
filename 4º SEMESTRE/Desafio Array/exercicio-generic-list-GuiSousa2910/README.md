[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/WRgLd5yn)
<h1 style="text-align:center;">Rubber Duck Debugging</h1>

<h3 style="text-align:center; font-style:italic;">
Capítulo 2: é a MESMA lista… só que genérica. 🦆
</h3>

<div style="text-align:center;">
  <a href="https://rubberduckdebugging.com/" target="_blank">
    <img src="rubber.png" alt="Patinho de borracha" width="200"/>
  </a>
</div>

---

# 📦 O que muda agora? `Lista<T>` (genérica)

Este capítulo é **a continuação direta** do capítulo anterior. Tudo o que você fez para a **lista de `String`** vale *
*igualzinho** aqui — a diferença é que agora a estrutura aceita **qualquer tipo** via **Generics**:

```java
public class Lista<T> {
    // mesmos campos/ideias do capítulo 1,
    // só que agora o tipo é T (genérico)
}
```

## ☕️ Generics em 1 minuto

* **Objetivo**: permitir **tipos parametrizados**, evitando `casts` e ganhando **segurança de tipos** em tempo de
  compilação.
* **Sintaxe**: `Lista<T>` — o `T` (type parameter) é decidido pelo usuário da classe:

    * `var ints = new Lista<Integer>();`
    * `var textos = new Lista<String>();`
* **Type Erasure**: no bytecode, o parâmetro de tipo é “apagado” (erasure) e tratado como `Object`, mas o **compilador**
  garante os tipos para você.
* **Invariância**: `Lista<Animal>` **não** é compatível com `Lista<Cachorro>` automaticamente (e vice-versa).
* **`null` continua válido**: sua lista deve aceitar `null` como elemento, como antes.

> **Resumo**: pense que você pegou sua `ListaTexto` e trocou cada `String` por um `T`. A mecânica interna (redimensionar
> array, deslocar elementos, validar índices, etc.) **não muda**.

---

# 🧭 Enunciado (versão genérica)

Implemente `Lista<T>` baseada em um array interno **redimensionável**. Mantenha a **ordem de inserção**, permita *
*duplicatas** e **`null`**.
A capacidade inicial é **4** e deve **dobrar** sempre que necessário (4 → 8 → 16 → ...), preservando a ordem dos
elementos.

---

# 🔍 Visão geral da estrutura

* **Array interno**: `T[] elements`
* **Tamanho lógico**: `int numElements` (quantas posições estão ocupadas)
* **Capacidade inicial**: `4`
* **Crescimento**: dobrar até comportar a nova quantidade solicitada
* **Semântica idêntica** ao capítulo 1 (só trocou `String` por `T`)

---

## ➕ Inserção

### `boolean add(T element)`

**O que fazer (igual ao capítulo 1):**

1. Garantir capacidade para `numElements + 1` (dobrando até caber).
2. Inserir em `elements[numElements]`.
3. Incrementar `numElements`.
4. Retornar `true`.
   **Observações**: aceita `null`; deve preservar a ordem após *resize*.

---

### `boolean add(int index, T element)`

**O que fazer:**

1. Validar índice de inserção: `0 <= index <= numElements`; caso contrário, **`IndexOutOfBoundsException`**.
2. Garantir capacidade para `numElements + 1`.
3. **Deslocar à direita** o intervalo `[index, numElements-1]`.
4. Gravar `element` em `elements[index]`.
5. Incrementar `numElements` e retornar `true`.
   **Observações**: `index == numElements` significa “inserir no fim”.

---

### `boolean addAll(Lista<T> other)`

**O que fazer:**

1. Se `other == null` → **`NullPointerException`**.
2. Se `other.size() == 0` → retornar **`false`** (nada para inserir).
3. Garantir capacidade para `numElements + other.size()`.
4. Copiar os itens de `other` **na ordem** para o final desta lista.
5. Atualizar `numElements` e retornar **`true`**.

---

### `T set(int index, T element)`

**O que fazer:**

1. Validar acesso: `0 <= index < numElements`; senão, **exceção**.
2. Guardar o valor antigo.
3. Substituir por `element` (aceita `null`).
4. **Não** alterar `numElements`.
5. Retornar o antigo.

---

## 📖 Acesso

### `T get(int index)`

**O que fazer:**

1. Validar acesso: `0 <= index < numElements`; senão, **exceção**.
2. Retornar `elements[index]` (pode ser `null`).

---

### `int size()`

**O que fazer:** retornar **exatamente** `numElements` (não a capacidade).

---

### `boolean isEmpty()`

**O que fazer:** retornar `numElements == 0`.

---

## 🗑️ Remoção

### `T remove(int index)`

**O que fazer:**

1. Validar acesso: `0 <= index < numElements`; senão, **exceção**.
2. Guardar o valor removido.
3. **Deslocar à esquerda** o intervalo `[index+1, numElements-1]`.
4. Colocar `null` na última posição que ficou vaga.
5. Decrementar `numElements`.
6. Retornar o valor removido.

---

### `boolean remove(T element)`

**O que fazer:**

1. Encontrar a **primeira ocorrência** de `element` (comparar com `equals` quando não for `null`; com `==` quando for
   `null`).
2. Se não existir, retornar **`false`**.
3. Caso exista, reutilizar a remoção por índice e retornar **`true`**.
   **Observações**: remove **apenas a primeira ocorrência**, preservando a ordem.

---

### `void clear()`

**O que fazer:**

1. (Opcional, mas recomendado) Definir `null` nas posições `0..numElements-1` para evitar retenção de referências.
2. Zerar `numElements`.
3. **Não** reduzir a capacidade do array.

---

## 🔎 Consulta

### `boolean contains(T element)`

**O que fazer:** retornar `true` se existir ao menos uma ocorrência (comparar por `equals`/`== null`), considerando *
*apenas** `0..numElements-1`.

---

### `int indexOf(T element)`

**O que fazer:** retornar o **índice da primeira ocorrência** (ou **`-1`** se não existir), percorrendo
`0..numElements-1`.
**Dica**: usar `Objects.equals(a, b)` evita NPE e cobre `null`.

---

### `int lastIndexOf(T element)`

**O que fazer:** retornar o **índice da última ocorrência** (ou **`-1`** se não existir), percorrendo de `numElements-1`
até `0`.
**Dica**: idem, `Objects.equals`.

---

## 🧪 Regras de ouro (iguais ao capítulo 1)

1. **Capacidade dobra** quando necessário, preservando ordem.
2. **Shifts corretos**: inserção por índice → direita; remoção por índice → esquerda.
3. **`null` é válido** em todas as operações.
4. **Exceções de índice**:

    * Acesso: `0 <= index < size`
    * Inserção: `0 <= index <= size`
5. **`size()`** reflete **só** `numElements`.
6. **`clear()`** não encolhe a capacidade.

---

## 🧩 Código-base citado neste capítulo (para contexto)

> **Atenção**: este trecho é apenas para **contexto/descrição**. A implementação final deve obedecer as regras acima (
> mesmas do capítulo 1, agora com `T`).

```java
package github.britooo;

import java.util.Arrays;

public class Lista<T> {

    private T[] elements;
    private int numElements;

    @SuppressWarnings("unchecked")
    public Lista() {
        this.elements = (T[]) new Object[4]; // capacidade inicial
        this.numElements = 0;
    }

    // INSERÇÃO
    public boolean add(T element) { /* ... */
        return true;
    }

    public boolean add(int index, T element) { /* ... */
        return true;
    }

    public boolean addAll(Lista<T> other) { /* ... */
        return true;
    }

    // ATUALIZAÇÃO / ACESSO
    public T set(int index, T element) { /* ... */
        return null;
    }

    public T get(int index) { /* ... */
        return null;
    }

    public int size() {
        return numElements;
    }

    public boolean isEmpty() {
        return numElements==0;
    }

    // REMOÇÃO
    public T remove(int index) { /* ... */
        return null;
    }

    public boolean remove(T element) { /* ... */
        return false;
    }

    public void clear() { /* ... */ }

    // CONSULTA
    public boolean contains(T element) { /* ... */
        return false;
    }

    public int indexOf(T element) { /* ... */
        return -1;
    }

    public int lastIndexOf(T element) { /* ... */
        return -1;
    }

    // Helpers de capacidade/validação ficariam aqui...
}
```

> Conclusão: **mesma lista** do capítulo 1, **mesmo comportamento**, **mesmos testes conceituais** — só que agora com *
*Generics** para aceitar **qualquer tipo** de elemento com segurança de tipos.
