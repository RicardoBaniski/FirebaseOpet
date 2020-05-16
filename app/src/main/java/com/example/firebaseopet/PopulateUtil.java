package com.example.firebaseopet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

class PopulateUtil {
    public static List<Pessoa> loadPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();

        Pessoa pessoa = new Pessoa();
        pessoa.nome = "Pedro José";
        pessoa.qtde_pets=2;
        pessoa.salario=3500.00;
        pessoa.ativo=false;
        pessoa.pets= Arrays.asList("Zakk","Ginger");
        pessoa.data_aniversario= new GregorianCalendar(1991, Calendar.AUGUST,17).getTime();

        pessoas.add(pessoa);

        pessoa = new Pessoa();
        pessoa.nome = "Ana Maria";
        pessoa.qtde_pets=2;
        pessoa.salario=2900.00;
        pessoa.ativo=true;
        pessoa.pets= Arrays.asList("Pingo","Chico");
        pessoa.data_aniversario= new GregorianCalendar(1980, Calendar.OCTOBER,13).getTime();

        pessoas.add(pessoa);

        pessoa = new Pessoa();
        pessoa.nome = "Pedro Moreira";
        pessoa.qtde_pets=0;
        pessoa.salario=1500.55;
        pessoa.ativo=true;
        pessoa.pets= null;
        pessoa.data_aniversario= new GregorianCalendar(1989, Calendar.DECEMBER,25).getTime();

        pessoas.add(pessoa);

        return pessoas;
    }
}
