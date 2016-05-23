package br.com.fiap.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.Matmed;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;

public class Main {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
	
		Paciente paciente1 = new Paciente();
		try {
			paciente1.setCfp("12345678901");
			paciente1.setNome("Antonio Henrique");
			paciente1.setNascimento(new SimpleDateFormat("yyyy-MM-dd").parse("1980-06-26"));
			paciente1.setTelefone("11912345678");
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		GenericDao<Paciente> pacientes = new GenericDao<>(Paciente.class);
		pacientes.adicionar(paciente1);
		
		Agenda agenda1 = new Agenda();
		try {
			agenda1.setData(new SimpleDateFormat("yyyy-MM-dd").parse("2016-05-30"));
			agenda1.setHora(new SimpleDateFormat("hh:mm").parse("00:00"));
			agenda1.setDescricao("Consulta com cardiologista");
		} catch (ParseException e) {
			System.out.println(e.getMessage());;
		}
		
		GenericDao<Agenda> agendas = new GenericDao<>(Agenda.class);
		agendas.adicionar(agenda1);
		
		Procedimento proced1 = new Procedimento();
		proced1.setDescricao("Verificação de rotina");
		proced1.setPreco(250.00);
		proced1.setPaciente(paciente1);
		
		GenericDao<Procedimento> proceds = new GenericDao<>(Procedimento.class);
		proceds.adicionar(proced1);
		
		Matmed matmed1 = new Matmed();
		matmed1.setDescricao("Remédio para pressão alta");
		matmed1.setPreco(49.95);
		matmed1.setFabricante("FarmaGeneric");
		matmed1.setPaciente(paciente1);
		
		GenericDao<Matmed> matmeds = new GenericDao<>(Matmed.class);
		matmeds.adicionar(matmed1);
		
		System.out.println(pacientes.buscar(pacientes.listar().size()).getCfp());
		System.out.println(agendas.buscar(agendas.listar().size()).getId());
		System.out.println(proceds.buscar(proceds.listar().size()).getId());
		System.out.println(matmeds.buscar(matmeds.listar().size()).getId());
	}
}
