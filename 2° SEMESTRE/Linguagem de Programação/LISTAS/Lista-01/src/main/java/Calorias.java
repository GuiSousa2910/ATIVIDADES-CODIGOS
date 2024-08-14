public class Calorias {
    public static void main(String[] args) {
        Integer minutosAquecimento = 20;
        Integer minutosAerobicos = 60;
        Integer minutosMusculacao = 30;

        Integer calPerdidosAquecimento = minutosAquecimento * 12;
        Integer calPerdidosAerobicos = minutosAerobicos * 20;
        Integer calPerdidosMusculacao = minutosMusculacao * 25;

        Integer totalMinutos = minutosAerobicos + minutosAquecimento + minutosMusculacao;
        Integer calTotal = calPerdidosAquecimento + calPerdidosAerobicos+ calPerdidosMusculacao;

        System.out.println("Olá, Jorge. Você fez um total de %d minutos de exercícios e perdeu cerca de %d calorias.".formatted(totalMinutos, calTotal));
    }
}
