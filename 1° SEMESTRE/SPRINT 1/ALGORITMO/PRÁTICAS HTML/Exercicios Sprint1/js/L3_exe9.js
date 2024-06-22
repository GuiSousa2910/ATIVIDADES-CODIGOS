var calculoSono1 = 0;
var calculoSono2 = 0;
var calculoSono3 = 0;
var calculoSono4 = 0;

function calculo() {

    calculoSono1 = input_horasDormidas.value * 0.05;
    calculoSono2 = input_horasDormidas.value * 0.45;
    calculoSono3 = input_horasDormidas.value * 0.30;
    calculoSono4 = input_horasDormidas.value * 0.20;

    idMensagem.innerHTML = `
        <br>Ao dormir ${input_horasDormidas.value} horas, você dormiu:<br>  

${calculoSono1} horas na fase 1  <br>

${calculoSono2} horas na fase 2  <br>

${calculoSono3} horas na fase 3  <br>

${calculoSono4} horas na fase REM <br> `;
}