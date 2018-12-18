package br.com.clinicaVet.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.MappedSuperclass;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;

@MappedSuperclass
abstract class BaseDomain {

	public void validarDomain() {
		Configuration<?> config = Validation.byDefaultProvider().configure();
		ValidatorFactory factory = config.buildValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BaseDomain>> violations = validator.validate(this);

		Set<String> violationMessages = new HashSet<>();

		for (ConstraintViolation<BaseDomain> constraintViolation : violations) {
			String campo = StringUtils.capitalize(constraintViolation.getPropertyPath().toString());
			String msg = constraintViolation.getMessage();
			violationMessages.add(campo.concat(" : ").concat(msg));
		}

		if (!violationMessages.isEmpty()) {
			throw new DominioInvalidoException(StringUtils.join(violationMessages, " \n "));
		}
	}

}
