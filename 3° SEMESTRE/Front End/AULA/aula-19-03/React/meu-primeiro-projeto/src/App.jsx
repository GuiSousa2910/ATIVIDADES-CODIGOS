import React, { useState } from 'react';
import "./App.css";
import Card from "./Card";

function App() {

  const [contador, setContador] = useState(0);

  const contarNumero = () => {
    if (contador < 30) {
      setContador(contador + 1);
    } else {
      setContador("Limite atingido");
    }
  };

  return (
    <>
      {/* <Card titulo={""} paragrafo={"Ele é legal"}/> */}
      {/* <Card titulo={"Pedro"} paragrafo={"Ele é chato"}/> */}
      {/* <Card titulo={"Gui"} paragrafo={"Ele é doido"}/> */}
      <button onClick={contarNumero}>
        Contar
      </button>
      <p>{contador}</p>
    </>
  );
}

export default App;