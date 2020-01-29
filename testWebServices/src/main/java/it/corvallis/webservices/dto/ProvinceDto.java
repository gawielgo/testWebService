package it.corvallis.webservices.dto;
import java.util.List;

import it.corvallis.webservices.dao.ProvinceDao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceDto {

	public List<ProvinceDao> provinceData;
	
}
