package br.net.ti2.newsinlevelcontrolapi.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.net.ti2.newsinlevelcontrolapi.dto.ErroDeValicacaoHandlerDto;

@RestControllerAdvice
public class ErroDeValicacaoHandler {

	@Autowired
	private MessageSource messsageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeValicacaoHandlerDto> handle(MethodArgumentNotValidException exception) {
		List<ErroDeValicacaoHandlerDto> errosDto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			errosDto.add(new ErroDeValicacaoHandlerDto(e.getField(), messsageSource.getMessage(e, LocaleContextHolder.getLocale())));
		});

		return errosDto;
	}
}
