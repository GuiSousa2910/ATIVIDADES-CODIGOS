package school.sptech.lead.core.domain.shared.valueObject;

import java.util.regex.Pattern;

public class LeadCPF {
    private String value;
    private static Pattern cpf = Pattern.compile("^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$");

    public String getValue() {
        return value;
    }

    public static LeadCPF of(String value) {
        Boolean matches = cpf.matcher(value).matches();
        if (!matches) {
            throw new IllegalArgumentException("CPF inválido");
        }

    }
}