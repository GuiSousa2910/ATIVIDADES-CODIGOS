function autenticar() {
    var login = input_login.value;
    var senha = input_senha.value;
    var pessoal = input_pessoal.value;

    if (login == 'ana' && senha == 'braga' && pessoal == 1949 || pessoal == 'louro josé') {
        divMensagem.innerHTML = 'Acesso permitido';
    }
    else {
        divMensagem.innerHTML = 'Acesso negado';
    }
}