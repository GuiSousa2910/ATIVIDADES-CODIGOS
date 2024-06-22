function calculo() {
    var nomePassageiro = input_nome.value;
    var distancia = Number(input_distancia.value);
    var distanciaKm = distancia * 1.25;
    var bandeira = Number(input_bandeira.value);
    var horario = Number(input_horario.value);

    if (bandeira >= 1) {
        if (bandeira <= 3) {

            if (bandeira == 1) {
                if (horario >= 0) {
                    if (horario <= 6) {
                        distanciaKm += distanciaKm * 0.05;
                    }
                }
                if (horario >= 7) {
                    if (horario <= 12) {
                        distanciaKm += distanciaKm * 0.10;
                    }
                }
                if (horario >= 13) {
                    if (horario <= 24) {
                        distanciaKm += distanciaKm * 0.15;
                    }
                }
            }

            if (bandeira == 2) {
                if (horario >= 0) {
                    if (horario <= 6) {
                        distanciaKm += distanciaKm * 0.10;
                    }
                }
                if (horario >= 7) {
                    if (horario <= 12) {
                        distanciaKm += distanciaKm * 0.20;
                    }
                }
                if (horario >= 13) {
                    if (horario <= 24) {
                        distanciaKm += distanciaKm * 0.30;
                    }
                }
            }

            if (bandeira == 3) {
                if (horario >= 0) {
                    if (horario <= 6) {
                        distanciaKm += distanciaKm * 0.15;
                    }
                }
                if (horario >= 7) {
                    if (horario <= 12) {
                        distanciaKm += distanciaKm * 0.30;
                    }
                }
                if (horario >= 13) {
                    if (horario <= 24) {
                        distanciaKm += distanciaKm * 0.45;
                    }
                }
            }
        }
    }
    divMensagem.innerHTML = `<b>Olá ${nomePassageiro}, sua corrida, será na bandeira ${bandeira}, percorrerá ${distancia} km e o total da corrida será de ${distanciaKm} </b>`;
}