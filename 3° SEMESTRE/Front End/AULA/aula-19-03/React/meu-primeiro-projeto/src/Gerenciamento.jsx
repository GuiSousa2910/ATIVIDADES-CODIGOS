import "./App.css";
import { useState } from 'react';
import Formulario from "./Formulario";

function Gerenciamento() {
    const [desabilitarTodos, setDesabilitarTodos] = useState(false);
    const [buttonName, setButtonName] = useState("Desabilitar todos formularios");

    const desabilitarForms = () => {
        if (desabilitarTodos) {
            setDesabilitarTodos(false);
            setButtonName("Desabilitar todos formularios");
        } else {
            setDesabilitarTodos(true);
            setButtonName("Habilitar todos formularios");
        }
    };

    return (
        <>
            <button onClick={() => desabilitarForms(true)}>{buttonName}</button>
            <Formulario desabilitarTodos={desabilitarTodos} />
            <Formulario desabilitarTodos={desabilitarTodos} />
            <Formulario desabilitarTodos={desabilitarTodos} />
        </>
    );
}

export default Gerenciamento;