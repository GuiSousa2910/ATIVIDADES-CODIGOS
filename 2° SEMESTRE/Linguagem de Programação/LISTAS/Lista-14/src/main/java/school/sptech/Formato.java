package school.sptech;

public enum Formato {

    DIGITAL("DIGITAL"),
    COMUM("COMUM"),
    CAPA_DURA("CAPA_DURA");

    private final String formato;

    public String getRaridade() {
        return formato;
    }

    Formato(String formato) {
        this.formato = formato;
    }

}
