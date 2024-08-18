package Financial.example.User_management.Dtos;

import Financial.example.User_management.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface DtoMapper {
    AuthDTO userToAuthDto(User user);
    User AuthDtoUser(AuthDTO authDTO);

    @Mapping(target = "userid", ignore = true)
    AuthDTO createUser
}
