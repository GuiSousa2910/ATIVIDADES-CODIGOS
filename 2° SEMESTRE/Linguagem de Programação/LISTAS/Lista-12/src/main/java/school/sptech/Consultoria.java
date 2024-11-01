package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor) {
        if (vagas > 0) {
            desenvolvedores.add(desenvolvedor);
            return true;
        } else {
            return false;
        }
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (vagas > 0) {
            if (desenvolvedor.isFullstack()) {
                desenvolvedores.add(desenvolvedor);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Double getTotalSalarios() {
        Double totalSalario = 0.0;
        for (Desenvolvedor desenvolvedores : desenvolvedores) {
            totalSalario += desenvolvedores.calcularSalario();
        }
        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer total = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                total++;
            } else {
                continue;
            }
        }
        return total;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> salarioFiltrado = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                salarioFiltrado.add(desenvolvedor);
            }
        }
        return salarioFiltrado;
    }

    public Desenvolvedor buscarMenorSalario() {
        Desenvolvedor desenvolvedorMenorSalario = new Desenvolvedor();
        Double menorSalario = Double.POSITIVE_INFINITY;

        if (desenvolvedores.isEmpty()) {
            return null;
        } else {
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if (desenvolvedor.calcularSalario() < menorSalario) {
                    menorSalario = desenvolvedor.calcularSalario();
                    desenvolvedorMenorSalario = desenvolvedor;
                }
            }
            return desenvolvedorMenorSalario;
        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresFiltrados = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb) {
                if (tecnologia.equalsIgnoreCase(desenvolvedorWeb.getBackend()) ||
                        tecnologia.equalsIgnoreCase(desenvolvedorWeb.getFrontend()) ||
                        tecnologia.equalsIgnoreCase(desenvolvedorWeb.getSgbd())) {
                    desenvolvedoresFiltrados.add(desenvolvedor);
                }
            } else if (desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile) {
                if (tecnologia.equalsIgnoreCase(desenvolvedorMobile.getPlataforma()) ||
                        tecnologia.equalsIgnoreCase(desenvolvedorMobile.getLinguagem())) {
                    desenvolvedoresFiltrados.add(desenvolvedor);
                }
            }
        }
        return desenvolvedoresFiltrados;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double totalSalario = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb desenvolvedorWeb){
                if (desenvolvedorWeb.getBackend().equalsIgnoreCase(tecnologia) || desenvolvedorWeb.getFrontend().equalsIgnoreCase(tecnologia) || desenvolvedorWeb.getSgbd().equalsIgnoreCase(tecnologia)){
                    totalSalario += desenvolvedor.calcularSalario();
                }
            }
            if (desenvolvedor instanceof DesenvolvedorMobile desenvolvedorMobile){
                if (desenvolvedorMobile.getPlataforma().equalsIgnoreCase(tecnologia) || desenvolvedorMobile.getLinguagem().equalsIgnoreCase(tecnologia)){
                    totalSalario += desenvolvedor.calcularSalario();
                }
            }
        }
        return totalSalario;
    }



}