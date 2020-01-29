package it.corvallis.webservices.dto;
import java.util.List;

import it.corvallis.webservices.dao.NazioniDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NazioniDto {

	public List<NazioniDao> nazioniData;
	
}
