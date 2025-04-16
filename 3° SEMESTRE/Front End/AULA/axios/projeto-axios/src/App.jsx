import { useEffect } from 'react';
import axios from 'axios';
import './App.css';
import { Card } from './Card';
import { api } from './provider/apiInstance';

function App() {
  useEffect(() => { }, []);

  function adicionarUsers() {
    api.post("/usuarios", {
      nome: "Lucas",
      idade: 23,
      profissao: "Desenvolvedor"
    });
  }

  const buscarUsers = () => {
    api.get("/usuarios")
      .then(respose => {
        console.log(respose.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const atualizarUsers = () => {
    api.put("/usuarios/4f07", {
      nome: "Marcos",
      idade: 23,
      profissao: "Desenvolvedor"
    });
  };

  const deletarUsers = () => {
    api.delete("/usuarios/4f07")
      .then(respose => {
        console.log(respose.data);
      })
      .catch(error => {
        console.log(error);
      });
  };


  return (
    <>
      {/* <button onClick={adicionarUsers}>ADICIONAR</button>
      <button onClick={buscarUsers}>BUSCAR</button>
      <button onClick={atualizarUsers}>ATUALIZAR</button>
      <button onClick={deletarUsers}>DELETAR</button> */}

      <Card />
    </>
  );
}

export default App;
