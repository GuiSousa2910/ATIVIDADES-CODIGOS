import React, { useState } from 'react';
import "./App.css";
import Card from "./Card";
import Gerenciamento from "./Gerenciamento";  
import Pokemon from "./Pokemon";  

function App() {

  const [contador, setContador] = useState(0);

  const contarNumero = () => {
    contador < 30 ? setContador(contador + 1) : setContador("Limite atingido");
  };

  return (
    <>
      {/* {<Card titulo={""} paragrafo={"Ele é legal"} />} */}
      {/* {<Card titulo={"Pedro"} paragrafo={"Ele é chato"} />} */}
      {/* {<Card titulo={"Gui"} paragrafo={"Ele é doido"} />} */}
      {/* <button onClick={contarNumero}> */}
      {/* Contar */}
      {/* </button> */}
      {/* <p>{contador}</p> */} 

      {/* <Gerenciamento /> */}
      <Pokemon />
    </>
  );
}

export default App;