package com.example.parayo.common

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController

@ControllerAdvice
@RestController
class ParayoExceptionHandler {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(ParayoException::class)
    fun handlerParayoException(exception: ParayoException): ApiResponse {
        logger.error("API Error", exception)
        return ApiResponse.error(exception.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(exception: Exception):ApiResponse{
        logger.error("API Error", exception)
        return ApiResponse.error("알 수 없는 오류가 발생했습니다.")
    }
}