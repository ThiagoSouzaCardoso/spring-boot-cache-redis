package br.com.empresa.controller;

import br.com.empresa.convert.CompanyToDTO;
import br.com.empresa.dto.CompanyInput;
import br.com.empresa.model.Company;
import br.com.empresa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyToDTO companyToDTOConvert;

    @GetMapping
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/{identifier}")
    @ResponseStatus(HttpStatus.OK)
    public Company findByIdentifier(@PathVariable("identifier") final UUID identifier) {
        return companyService.findbyIdentifier(identifier);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@RequestBody final CompanyInput company) {
        Company converted = companyToDTOConvert.convert(company);
        return companyService.create(converted);
    }

    @PutMapping(value="/{identifier}")
    @ResponseStatus(HttpStatus.OK)
    public Company update(@PathVariable("identifier") UUID identifier, @RequestBody final CompanyInput company) {
        Company companyResult = companyService.findbyIdentifier(identifier);
        companyResult.setName(company.getName());
        return companyService.update(companyResult);
    }

    @DeleteMapping("/{identifier}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("identifier") final UUID identifier) {
        companyService.delete(identifier);
    }

}
