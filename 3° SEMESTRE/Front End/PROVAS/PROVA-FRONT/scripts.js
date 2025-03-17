const historico = [];

function calcular(botao) {
    const inputNum1 = document.getElementById('input-num1');
    const inputNum2 = document.getElementById('input-num2');
    const resultadoSection = document.getElementById('section-resultado');
    const divHistorico = document.getElementById('div-historico');
    const sectionHist = document.querySelector('#section-historico');

    const btSoma = document.getElementById('btn-somar');
    const btSub = document.getElementById('btn-subtrair');
    const btMult = document.getElementById('btn-multiplicar');
    const btDiv = document.getElementById('btn-dividir');

    const validarPreenchimento = () => {
        if (inputNum1.value == '' || inputNum2.value == '') {
            return true;
        } else {
            return false;
        }
    };

    const atualizarHistorico = (e) => {
        historico.push(e);
        divHistorico.textContent = '';
        sectionHist.style.display = "flex";
        for (let index = historico.length - 1; index >= 0; index--) {
            const element = historico[index];
            if (index == historico.length - 1) {
                divHistorico.innerHTML += `${element}`;
            } else {
                divHistorico.innerHTML += `<br> ${element}`;
            }
        }
    };

    btSoma.addEventListener('click', (event) => {
        resultadoSection.style.color = "#421490";
        if (validarPreenchimento()) {
            resultadoSection.textContent = "Informe os 2 números para realizar a operação";
        } else {
            const n1 = Number(inputNum1.value);
            const n2 = Number(inputNum2.value);

            const resultado = n1 + n2;

            resultadoSection.textContent = `Resultado: ${n1} mais ${n2} = ${resultado}`;
            atualizarHistorico(`\n ⏲️ ${n1} mais ${n2} = ${resultado}`);
        }
    });

    btSub.addEventListener('click', (event) => {
        resultadoSection.style.color = "#421490";
        if (validarPreenchimento()) {
            resultadoSection.textContent = "Informe os 2 números para realizar a operação";
        } else {
            const n1 = Number(inputNum1.value);
            const n2 = Number(inputNum2.value);

            const resultado = n1 - n2;

            resultadoSection.textContent = `Resultado: ${n1} menos ${n2} = ${resultado}`;
            atualizarHistorico(`\n ⏲️ ${n1} menos ${n2} = ${resultado}`);
        }
    });

    btMult.addEventListener('click', (event) => {
        resultadoSection.style.color = "#421490";
        if (validarPreenchimento()) {
            resultadoSection.textContent = "Informe os 2 números para realizar a operação";
        } else {
            const n1 = Number(inputNum1.value);
            const n2 = Number(inputNum2.value);

            const resultado = n1 * n2;

            resultadoSection.textContent = `Resultado: ${n1} vezes ${n2} = ${resultado}`;
            atualizarHistorico(`\n ⏲️ ${n1} vezes ${n2} = ${resultado}`);
        }
    });

    btDiv.addEventListener('click', (event) => {
        resultadoSection.style.color = "#421490";
        const n1 = Number(inputNum1.value);
        const n2 = Number(inputNum2.value);

        if (validarPreenchimento()) {
            resultadoSection.textContent = "Informe os 2 números para realizar a operação";
        } else {
            if (n2 === 0) {
                resultadoSection.textContent = `Não pode divisão por 0!!`;
            } else {
                const resultado = n1 / n2;

                resultadoSection.textContent = `Resultado: ${n1} dividido ${n2} = ${resultado}`;
                atualizarHistorico(`⏲️ ${n1} dividido ${n2} = ${resultado}`);
            }
        }
    });
} 

document.addEventListener('DOMContentLoaded', (event) => {
    calcular(); 
});