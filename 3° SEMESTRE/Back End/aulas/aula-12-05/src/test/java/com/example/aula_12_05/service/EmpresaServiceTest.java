package com.example.aula_12_05.service;

import com.example.aula_12_05.entity.Empresa;
import com.example.aula_12_05.exception.NotFoundException;
import com.example.aula_12_05.repository.EmpresaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {

    @InjectMocks
    private EmpresaService service;

    @Mock
    private EmpresaRepository repository;

    @Test
    @DisplayName("Listagem quando acionado deve retornar empresas")
    void listagemQuandoAcionadoDeveRetornarEmpresasTest() {
        List<Empresa> empresas = List.of(
                new Empresa(
                        1L,
                        "Empresa 1",
                        "Fantasia 1",
                        "12345678000195"
                ),

                new Empresa(
                        2L,
                        "Empresa 2",
                        "Fantasia 2",
                        "12345678000196"
                ),

                new Empresa(
                        3L,
                        "Empresa 3",
                        "Fantasia 3",
                        "12345678000197"
                )
        );

        when(repository.findAll()).thenReturn(empresas);

        List<Empresa> resposta = service.listagem();

        assertEquals(3, resposta.size());
    }

    @Test
    void retornaNoContentQuandoNaoEncontrarEmpresasTest() {
        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<Empresa> resposta = service.listagem();

        assertTrue(resposta.isEmpty());
    }

    @Test
    void retornaEmpresaPeloID() {
        var idTeste = 42L;

        var empresaAlvo = new Empresa(1L, "Teste", "TesteFantasia", "342567890112");

        Optional<Empresa> empresaTesteOpt = Optional.of(empresaAlvo);

        when(repository.findById(anyLong())).thenReturn(empresaTesteOpt);

        Empresa empresa = service.buscarId(idTeste);

        assertNotNull(empresa);
        assertEquals("Teste", empresa.getRazaoSocial());

    }

    @Test
    void deveLancarExceptionEmpresaPeloIDInvalido() {
        var idTeste = 42L;

        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.buscarId(idTeste));
    }

    @Test
    void deletaEmpresa() {
        var idTeste = 42L;

        when(repository.existsById(anyLong())).thenReturn(true);
        doNothing().when(repository).deleteById(anyLong());

        service.deletarId(idTeste);

        verify(repository, times(1)).existsById(anyLong());
        verify(repository, times(1)).deleteById(anyLong());

    }

    @Test
    void naoDeletaEmpresaInexistente() {
        var idTeste = 42L;


        when(repository.existsById(anyLong())).thenReturn(false);
        doNothing().when(repository).deleteById(anyLong());

        verify(repository, times(1)).existsById(anyLong());
        verify(repository, times(1)).deleteById(anyLong());


    }
}