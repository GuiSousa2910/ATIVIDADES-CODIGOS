import React from 'react';

export function Contatos(props) {
    return (
        <>
            <li>
                Nome do contato: {props.nome} Sobrenome do contato {props.sobrenome} Telefone do contato {props.telefone}
                <button style={{ marginLeft: '10px' }} onClick={props.excluir}>Excluir</button>
            </li>
        </>
    );
}