import React from "react";
import { useState } from "react";
import { Contatos } from "./Contatos";

export function ListaTelefonica() {

  const [contatos, setContatos] = useState([]);
  const [nome, setNome] = useState("");
  const [sobrenome, setSobrenome] = useState("");
  const [telefone, setTelefone] = useState("");

  const capturarNome = (e) => {
    const nomeEscrito = e.target.value;
    setNome(nomeEscrito);
  };

  const capturarSobrenome = (e) => {
    setSobrenome(e.target.value);
  };

  const capturarTel = (e) => {
    setTelefone(e.target.value);
  };

  const cadastrarContato = () => {
    const novoContato = { nome, sobrenome, telefone };
    setContatos((prevContatos) => {
      const novosContatos = [...prevContatos, novoContato];
      console.log(novosContatos);
      return novosContatos;
    });
  };

  const exibirLista = () => {
    return contatos.map((contato, index) => (
      <Contatos
        key={index}
        nome={contato.nome}
        sobrenome={contato.sobrenome}
        telefone={contato.telefone}
        excluir={() =>
          setContatos((prevContatos) =>
            prevContatos.filter((_, i) => i !== index)
          )
        }
      />
    ));
  };

  return (
    <div>
      <h1>Lista Telefônica</h1>

      <input type="text" name="nome" placeholder="Nome" onInput={capturarNome} />
      <input type="text" name="sobrenome" placeholder="Sobrenome" onInput={capturarSobrenome} />
      <input type="text" name="telefone" placeholder="Telefone" onInput={capturarTel} />

      <button onClick={cadastrarContato}>Cadastrar</button>

      {exibirLista()}
    </div>
  );
}