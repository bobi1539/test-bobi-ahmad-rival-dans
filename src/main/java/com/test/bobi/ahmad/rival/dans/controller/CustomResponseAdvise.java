package com.test.bobi.ahmad.rival.dans.controller;

import com.test.bobi.ahmad.rival.dans.dto.BaseResponse;
import com.test.bobi.ahmad.rival.dans.util.BeanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice(basePackages = "com.test.bobi.ahmad.rival.dans.controller")
@Slf4j
public class CustomResponseAdvise extends BaseController implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {
        if (returnType.getContainingClass().isAnnotationPresent(RestController.class)) {
            if (body instanceof List || body instanceof Map) {
                return buildSuccessResponse(body);
            } else {
                BaseResponse baseResponse = BeanMapper.map(body, BaseResponse.class);
                if (Objects.isNull(baseResponse.getCode())) {
                    return buildSuccessResponse(body);
                }
            }
        }
        return body;
    }
}
