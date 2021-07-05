package theatre.application.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theatre.application.dto.request.TheatreHallRequestDto;
import theatre.application.dto.response.TheatreHallResponseDto;
import theatre.application.model.TheatreHall;
import theatre.application.service.TheatreHallService;
import theatre.application.service.mapper.TheatreHallMapper;

@RestController
@RequestMapping("/theatre-halls")
public class TheatreHallController {
    private final TheatreHallService theatreHallService;
    private final TheatreHallMapper theatreHallMapper;

    public TheatreHallController(TheatreHallService theatreHallService,
                                 TheatreHallMapper theatreHallMapper) {
        this.theatreHallService = theatreHallService;
        this.theatreHallMapper = theatreHallMapper;
    }

    @PostMapping
    public TheatreHallResponseDto add(@RequestBody @Valid TheatreHallRequestDto requestDto) {
        TheatreHall theatreHall = theatreHallService.add(theatreHallMapper.mapToModel(requestDto));
        return theatreHallMapper.mapToDto(theatreHall);
    }

    @GetMapping
    public List<TheatreHallResponseDto> getAll() {
        return theatreHallService.getAll()
                .stream()
                .map(theatreHallMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
