package theatre.application.service.mapper;

import org.springframework.stereotype.Component;
import theatre.application.dto.request.PerformanceRequestDto;
import theatre.application.dto.response.PerformanceResponseDto;
import theatre.application.model.Performance;

@Component
public class PerformanceMapper implements RequestDtoMapper<PerformanceRequestDto, Performance>,
        ResponseDtoMapper<PerformanceResponseDto, Performance> {
    @Override
    public Performance mapToModel(PerformanceRequestDto dto) {
        Performance performance = new Performance();
        performance.setTitle(dto.getPerformanceTitle());
        performance.setDescription(dto.getPerformanceDescription());
        return performance;
    }

    @Override
    public PerformanceResponseDto mapToDto(Performance performance) {
        PerformanceResponseDto responseDto = new PerformanceResponseDto();
        responseDto.setPerformanceId(performance.getId());
        responseDto.setPerformanceTitle(performance.getTitle());
        responseDto.setPerformanceDescription(performance.getDescription());
        return responseDto;
    }
}
