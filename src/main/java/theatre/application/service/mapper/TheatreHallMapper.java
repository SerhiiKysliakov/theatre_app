package theatre.application.service.mapper;

import org.springframework.stereotype.Component;
import theatre.application.dto.request.TheatreHallRequestDto;
import theatre.application.dto.response.TheatreHallResponseDto;
import theatre.application.model.TheatreHall;

@Component
public class TheatreHallMapper implements RequestDtoMapper<TheatreHallRequestDto, TheatreHall>,
        ResponseDtoMapper<TheatreHallResponseDto, TheatreHall> {
    @Override
    public TheatreHall mapToModel(TheatreHallRequestDto dto) {
        TheatreHall theatreHall = new TheatreHall();
        theatreHall.setDescription(dto.getDescription());
        theatreHall.setCapacity(dto.getCapacity());
        return theatreHall;
    }

    @Override
    public TheatreHallResponseDto mapToDto(TheatreHall theatreHall) {
        TheatreHallResponseDto responseDto = new TheatreHallResponseDto();
        responseDto.setId(theatreHall.getId());
        responseDto.setDescription(theatreHall.getDescription());
        return responseDto;
    }
}
