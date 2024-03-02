package br.com.marcusvps;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {


    public static void main(String[] args) {
        Emprestimo emprestimo = new Emprestimo(1, LocalDateTime.now(), BigDecimal.valueOf(23232));
        Emprestimo emprestimo2 = new Emprestimo(2, LocalDateTime.now(), BigDecimal.valueOf(2000), FormaPagamento.DEBITO_CONTA);
        Emprestimo emprestimo3 = new Emprestimo(3, LocalDateTime.now(), BigDecimal.valueOf(58484), FormaPagamento.BOLETO);
        Emprestimo emprestimo4 = new Emprestimo(4, LocalDateTime.now(), BigDecimal.valueOf(59000));

        List<Emprestimo> emprestimos = Arrays.asList(emprestimo, emprestimo2, emprestimo3, emprestimo4);

        emprestimos.forEach(emp -> System.out.println(
                Optional.ofNullable(emp.getFormaPagamento())
                        .map(FormaPagamento::getDescricao)
                        .orElse("Forma de Pagamento não informada.")
        ));
    }
}


class Emprestimo {
    private long id;
    private LocalDateTime contratadoEm;
    private BigDecimal valor;
    private FormaPagamento formaPagamento;

    public Emprestimo() {
    }

    public Emprestimo(long id, LocalDateTime contratadoEm, BigDecimal valor) {
        this.id = id;
        this.contratadoEm = contratadoEm;
        this.valor = valor;
    }

    public Emprestimo(long id, LocalDateTime contratadoEm, BigDecimal valor, FormaPagamento formaPagamento) {
        this.id = id;
        this.contratadoEm = contratadoEm;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getContratadoEm() {
        return contratadoEm;
    }

    public void setContratadoEm(LocalDateTime contratadoEm) {
        this.contratadoEm = contratadoEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}

enum FormaPagamento {
    BOLETO("Boleto Bancário"),
    DEBITO_CONTA("Débito em conta");

    private final String descricao;


    FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}