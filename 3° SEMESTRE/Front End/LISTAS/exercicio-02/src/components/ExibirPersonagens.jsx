import React from "react";
import { useState } from "react";
import { useEffect } from "react";

export function ExibirPersonagem() {

  const [personagem, setPersonagem] = useState({
    nome: "",
    imagem: ""
  });

  useEffect(() => {
    fetch("https://rickandmortyapi.com/api/character/502")
      .then((response) => response.json())
      .then(json => {
        console.log(json);
        setPersonagem({
          nome: json.name,
          imagem: json.image
        });
      })
      .catch((error) => console.log(error));
  }, []);

  return (
    <div>
      <h1>Personagem</h1>
      <ul>
        <li>Nome do personagem: {personagem.nome} Imagem: {<img src={personagem.imagem} />}</li>
      </ul>
    </div>
  );
}