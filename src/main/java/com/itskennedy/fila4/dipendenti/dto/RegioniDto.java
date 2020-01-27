package com.itskennedy.fila4.dipendenti.dto;

import java.util.List;

import com.itskennedy.fila4.dipendenti.dao.RegioniDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegioniDto {
	private List<RegioniDao> regioniData;
}
