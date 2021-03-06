package scc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;
import java.util.List;

@Cacheable(value="criblist")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CribList implements Serializable {

    private static final long serialVersionUID = 926785360163664368L;

    private List<Crib> listOfCribs;
}
