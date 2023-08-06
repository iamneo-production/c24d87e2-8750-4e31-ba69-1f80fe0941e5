package com.example.centralservice.modeldto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseDto {
	
	private Map<String, Long> diseaseName;
}
