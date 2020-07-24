package br.com.spring.boot.teste.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Client  implements Serializable{
	
	  private String id;
	  private String name = null;
	  private String cpf = null;
	  @JsonProperty("pets")
	  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	  List<Pet> pets;

}
