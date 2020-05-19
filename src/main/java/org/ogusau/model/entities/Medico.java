package org.ogusau.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Medico")
@PrimaryKeyJoinColumn(name = "ID_MEDICO_USUARIO")
public class Medico extends Usuario implements Serializable{

	private static final long serialVersionUID = 7869281375485093199L;

	@Column(name = "NUM_COLEGIADO")
	private String numColegiado;

	public Medico() {}

	public Medico(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

}
