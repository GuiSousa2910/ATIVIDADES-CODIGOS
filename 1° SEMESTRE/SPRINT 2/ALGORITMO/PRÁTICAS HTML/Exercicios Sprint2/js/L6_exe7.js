function validacao() {
    var login = input_login.value;
    var senha = input_senha.value;

    if (login == 'SPTech' && senha == 'digital') {
        alert('Usuário autenticado com sucesso');
    }
    else {
        alert('Falha na autenticação');
    }
}