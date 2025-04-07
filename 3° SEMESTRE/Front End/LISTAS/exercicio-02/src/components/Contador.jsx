import React from "react";
import { useState } from "react";

export function Contador() {

  const [contador, setContador] = useState(0);
  const [mensagem, setMensagem] = useState("Você está longe de chegar ao 30");

  function incrementar() {
    const novoContador = contador + 1;
    setContador(novoContador);
    if (novoContador >= 0 && novoContador <= 10) {
      setMensagem("Você está longe de chegar ao 30");
    } else if (novoContador > 10 && novoContador < 20) {
      setMensagem("Você está quase lá");
    } else if (novoContador >= 20 && novoContador < 30) {
      setMensagem("Falta pouco, você consegue!");
    } else {
      setMensagem("Você chegou em 30 cliques, parabéns!");
    }
  }

  return (
    <div>
      <h1>Contador: {contador}</h1>
      <p>Mensagem: {mensagem}</p>
      <button onClick={incrementar} disabled={contador >= 30}>
        Incrementar
      </button>
    </div>
  );
}