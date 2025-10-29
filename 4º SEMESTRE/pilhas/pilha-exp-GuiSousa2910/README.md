[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/krJIDiTE)
# 📝 Exercício: Validador de Expressões Matemáticas

![Patinho de borracha suando com faixa de ginástica, segurando halteres](rubber-duck.png)

## 🎯 Objetivo

Desenvolver um validador que verifica se os **parênteses**, **colchetes** e **chaves** em uma expressão estão **balanceados** e na **ordem correta**, utilizando a estrutura de dados **Pilha** desenvolvida em aula.

---

## 📚 Contexto

Em programação, compiladores e interpretadores precisam validar se o código está sintaticamente correto. Uma das validações mais importantes é verificar se todos os símbolos de abertura (`(`, `[`, `{`) possuem seus respectivos símbolos de fechamento (`)`, `]`, `}`) na ordem correta.

**Exemplo do dia a dia:**
- Editores de código destacam erros de parênteses
- Compiladores rejeitam código com brackets desbalanceados
- Validadores JSON verificam chaves e colchetes

---

## 📋 Especificação

### **Classe a ser implementada:**
```java
package school.sptech;

public class Validador {
    public static boolean validarExpressao(String expressao) {
        // Sua implementação aqui
    }
}
```

### **Requisitos Obrigatórios:**

1. ✅ **DEVE** utilizar a classe `Pilha<E>` desenvolvida em aula
2. ✅ **DEVE** retornar `true` se a expressão for válida
3. ✅ **DEVE** retornar `false` se a expressão for inválida
4. ✅ **PODE** criar métodos auxiliares (privados) se necessário
5. ✅ **DEVE** ignorar caracteres que não sejam brackets (letras, números, espaços, etc.)

---

## ✅ Casos de SUCESSO (retorna `true`)

### **Exemplo 1: Expressão vazia**
```java
validarExpressao("")
// Retorna: true
// Motivo: Não há brackets para validar
```

### **Exemplo 2: Parênteses simples**
```java
validarExpressao("()")
// Retorna: true
// Motivo: Abre e fecha corretamente
```

### **Exemplo 3: Múltiplos tipos**
```java
validarExpressao("()[]{}");
// Retorna: true
// Motivo: Cada par abre e fecha corretamente
```

### **Exemplo 4: Aninhamento correto**
```java
validarExpressao("({[]})");
// Retorna: true
// Motivo: Ordem de fechamento respeita LIFO (último a abrir, primeiro a fechar)
```

### **Exemplo 5: Expressão matemática**
```java
validarExpressao("(a + b) * [c - {d / e}]");
// Retorna: true
// Motivo: Ignora letras, operadores e espaços. Valida apenas os brackets.
```

### **Exemplo 6: Código real**
```java
validarExpressao("if (x > 0) { z = array[index]; }");
// Retorna: true
// Motivo: ( ) { [ ] } todos balanceados
```

---

## ❌ Casos de ERRO (retorna `false`)

### **Exemplo 1: Tipos incompatíveis**
```java
validarExpressao("(]");
// Retorna: false
// Motivo: Abre parêntese mas fecha com colchete
```

### **Exemplo 2: Ordem invertida**
```java
validarExpressao(")(");
// Retorna: false
// Motivo: Tenta fechar antes de abrir
```

### **Exemplo 3: Cruzamento (entrelaçamento)**
```java
validarExpressao("([)]");
// Retorna: false
// Motivo: A ordem de fechamento está errada
```

### **Exemplo 4: Não fechou tudo**
```java
validarExpressao("(()");
// Retorna: false
// Motivo: Falta fechar um parêntese
```

### **Exemplo 5: Fechou demais**
```java
validarExpressao("())");
// Retorna: false
// Motivo: Tentou fechar mais do que abriu
```

### **Exemplo 6: Expressão incorreta**
```java
validarExpressao("(a + b] * c");
// Retorna: false
// Motivo: Abre com ( mas fecha com ]
```

---

## 🧠 Como Resolver?

### **Por que usar Pilha?**

A Pilha é perfeita para este problema porque:
- Quando **abrimos** um bracket, criamos uma "dívida" que precisa ser paga
- O **último** bracket aberto deve ser o **primeiro** a fechar (LIFO)
- A Pilha guarda a ordem de abertura naturalmente

---

## 📦 Entregáveis

1. **Classe `Validador`** com o método `validarExpressao()` implementado
2. **Métodos auxiliares** (se você decidir criar)
3. O código deve **compilar sem erros**
4. O código deve **passar em todos os testes** fornecidos


---

## 🚀 Dicas Importantes

1. **Desenhe primeiro!** Faça um diagrama mostrando como a pilha muda a cada caractere
2. **Teste mentalmente** com exemplos simples antes de codificar
3. **Debug visual**: Se necessário, imprima o estado da pilha em cada passo
4. **Casos extremos**: Não esqueça de testar string vazia, apenas letras, etc.
5. **LIFO é a chave**: Último a entrar (last in) é o primeiro a sair (first out)

---
**Boa sorte! 🚀**