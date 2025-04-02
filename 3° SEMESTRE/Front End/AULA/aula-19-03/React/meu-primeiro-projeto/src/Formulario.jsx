import React, { useEffect, useState } from 'react';

const Formulario = (props) => {

    const [disabled, setDisabled] = useState(false);
    const [buttonName, setButtonName] = useState("Desabilitar formularios");    

    useEffect(()=> {
        setDisabled(props.desabilitarTodos)
    }, [props.desabilitarTodos])

    const desabilitarInput = () => {
        if (disabled) {
            setDisabled(false);
            setButtonName("Desabilitar formularios");
        } else {
            setDisabled(true);
            setButtonName("Habilitar formularios");
        }
    };

    return (
        <>
            <div>
                <label htmlFor="nome">Nome:</label>
                <input type="text" id="nome" disabled={disabled} />
            </div>
            <div>
                <label htmlFor="profissao">Profissao:</label>
                <input type="text" id="profissao" disabled={disabled} />
            </div>
            <div>
                <label htmlFor="comentario">Comentario:</label>
                <input type="text" id="comentario" disabled={disabled} />
            </div>
            <button onClick={desabilitarInput}>{buttonName}</button>

        </>
    );

};
export default Formulario;