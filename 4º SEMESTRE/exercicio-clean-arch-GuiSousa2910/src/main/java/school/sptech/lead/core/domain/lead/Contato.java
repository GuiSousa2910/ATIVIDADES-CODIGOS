package school.sptech.lead.core.domain.lead;

public class Contato {
    private Email email;
    private Telefone telefone;

    public Contato(Email email, Telefone telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public static Contato of(String email, String telefone) {
        return new Contato(new Email(email), new Telefone(telefone));
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
