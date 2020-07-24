package br.com.spring.boot.teste.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Pet implements Serializable {

	private String id;

	private String name;

}
