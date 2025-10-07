package school.sptech.lead.core.domain.shared.valueObject;

public class LeadContato {
    private String telefone;
    private String email;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String validarTel(String telefone){
        if(telefone.length() == 11){
            for (int i = 0; i < telefone.length(); i++) {
                if (telefone.charAt(i) < '0' || telefone.charAt(i) > '9') {
                    throw new IllegalArgumentException("Telefone inválido. Deve conter apenas dígitos.");
                }
            }
            return telefone;
        }else {
            throw new IllegalArgumentException("Telefone inválido. Deve conter 11 dígitos.");
        }
    }

    public String validarEmail(String email){
        if(email.contains("@")){
            return email;
        }else {
            throw new IllegalArgumentException("Email inválido. Deve conter '@'.");
        }
    }
}
