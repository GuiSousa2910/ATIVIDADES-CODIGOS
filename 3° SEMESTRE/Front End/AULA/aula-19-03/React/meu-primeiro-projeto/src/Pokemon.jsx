import React, { useEffect, useState } from 'react';
import "./App.css";
function Pokemon() {

    const [informacoes, setInformacoes] = useState({
        nome: "",
        imagem: "",
        imagemShiny: "",
        habilidades: []
    });

    useEffect(() => {
        fetch("https://pokeapi.co/api/v2/pokemon/trubbish")
            .then((response) => response.json())
            .then(json => {
                console.log(json);
                setInformacoes({
                    nome: json.name,
                    imagem: json.sprites.front_default,
                    imagemShiny: json.sprites.front_shiny,
                    habilidades: json.abilities
                });
            })
            .catch((error) => console.log(error));
    }, []);

    return (
        <div>
            <h2>{informacoes.nome}</h2>
            <img src={informacoes.imagem} alt={informacoes.nome} width={500} />
            <img src={informacoes.imagemShiny} alt={informacoes.nome} width={500} />
            {informacoes.habilidades.map((e) => (
                <div>{e.ability.name}</div>
            ))}
        </div>
    );
}

export default Pokemon;