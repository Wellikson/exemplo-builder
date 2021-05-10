
import com.wellikson.exemplo.builder.Produto;
import com.wellikson.exemplo.builder.ProdutoBuilder;
import com.wellikson.exemplo.builder.Vendedor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wellikson
 */
public class Principal {

    public static void main(String[] args) {
        DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Vendedor v = new Vendedor();
        v.setId(1);
        v.setNome("Maria");

        Produto produto = new ProdutoBuilder()
                .id(1)
                .titulo("TV LCD")
                .marca("PHILCO")
                .dataCadastro(LocalDate.parse("10/05/2021", FORMATO_DATA))
                .dataUltimaAtualizacao(LocalDate.parse("10/05/2021", FORMATO_DATA))
                .categoria("Eletronicos")
                .descricao("TV LCD 32'' Android")
                .modelo("123b")
                .altura(0)
                .peso(10)
                .preco(1200)
                .vendedor(v)
                .urlFoto("Sem Foto")
                .largura(2)
                .profundidade(0)
                .build();

        System.out.println(produto.toString());
    }

}
