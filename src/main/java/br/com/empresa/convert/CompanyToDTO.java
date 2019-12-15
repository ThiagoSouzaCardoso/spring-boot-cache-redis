package br.com.empresa.convert;

import br.com.empresa.dto.CompanyInput;
import br.com.empresa.model.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyToDTO implements Converter<CompanyInput, Company>{

    @Override
    public Company convert(CompanyInput companyInput) {
        return new Company(companyInput.getName());
    }
}
