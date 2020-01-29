package it.corvallis.webservices.dto;
import java.util.List;

import it.corvallis.webservices.dao.CittaDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CittaDto {

	public List<CittaDao> cittaData;
	
}
