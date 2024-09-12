package school.sptech.ex1;

public class Bolo {

    String sabor;
    Double valor;
    Integer qntVenda = 0;
    Integer qntEstoque = 0;

    void venderBolo(Integer qntBolo) {
        if (qntBolo < 0.0 || qntBolo > qntEstoque) {
            System.out.println("Quantidade inválida");
        } else {
            qntVenda += qntBolo;
            qntEstoque -= qntBolo;
            System.out.println("Agora seu estoque tem " + qntEstoque + " bolos e você vendeu " + qntVenda + " bolos");
        }
    }

    void aumentarEstoque(Integer addEstoque) {
        if (addEstoque < 0) {
            System.out.println("Valor negativo");
        } else {
            qntEstoque += addEstoque;
            System.out.println("Agora seu estoque tem " + qntEstoque + " bolos");
        }
    }

    Integer quantidadeDisponivel(){
        System.out.println("Seu estoque tem: " + qntEstoque + " bolos");
        return qntEstoque;
    }

    Double totalVendido(){
        Double salario = valor * qntVenda;
        System.out.println("Seu salário: " + salario);
        return salario;
    }

}
