import React from "react";
import { useState, useEffect } from "react";

export function DiarioInterativo() {

  const [anotacao, setAnotacao] = useState("");

  useEffect(() => {
    const storedAnotacao = localStorage.getItem("anotacao");
    if (storedAnotacao) {
      setAnotacao(storedAnotacao);
    }
  }, []);
  
  useEffect(() => {
    localStorage.setItem("anotacao", anotacao);
  }, [anotacao]);

  const salvarAnotacao = (e) => {
    setAnotacao(e.target.value);
  };

  return (
    <div>
      <h1>Diário Interativo</h1>
      <textarea
        onChange={salvarAnotacao}
        value={anotacao}
        placeholder="Escreva suas anotações aqui..."
        rows={10}
      />
    </div>
  );
}