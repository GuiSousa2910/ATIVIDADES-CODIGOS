import React from 'react';
import { useState } from 'react';

export function Calculadora() {

  const [resultado, setResultado] = useState(0);
  const [numero1, setNumero1] = useState(0);
  const [numero2, setNumero2] = useState(0);
  const [operacao, setOperacao] = useState('MULTIPLICAR');

  const primeiroNumero = (e) => {
    setNumero1(e.target.value);
  };

  const segundoNumero = (e) => {
    setNumero2(e.target.value);
  };

  const alterarOption = (e) => {
    setOperacao(e.target.value);
  };

  function calcular() {
    if (operacao === 'MULTIPLICAR') {
      setResultado(numero1 * numero2);
    } else if (operacao === 'SUBTRAIR') {
      setResultado(numero1 - numero2);
    } else if (operacao === 'DIVIDIR') {
      if (numero2 === 0) {
        setResultado('Não é possível dividir por zero');
      } else {
        setResultado(numero1 / numero2);
      }
    } else if (operacao === 'SOMAR') {
      setResultado(Number(numero1) + Number(numero2));
    }
  }

  return (
    <div>
      <input type="number" onInput={primeiroNumero} />
      <input type="number" onInput={segundoNumero} />
      <select onChange={alterarOption}>
        <option value="MULTIPLICAR">MULTIPLICAR</option>
        <option value="SUBTRAIR">SUBTRAIR</option>
        <option value="DIVIDIR">DIVIDIR</option>
        <option value="SOMAR">SOMAR</option>
      </select>
      <button onClick={calcular}>Calcular</button>
      Resultado da operação: {resultado}
    </div>
  );
}

