package com.hackathon.notification.mapper;

import com.hackathon.notification.dto.NotificationDto;
import com.hackathon.notification.entity.Notification;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-02T21:24:08+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationDto toDto(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        NotificationDto.NotificationDtoBuilder notificationDto = NotificationDto.builder();

        notificationDto.id( notification.getId() );
        notificationDto.recipient( notification.getRecipient() );
        notificationDto.subject( notification.getSubject() );
        notificationDto.body( notification.getBody() );
        notificationDto.type( notification.getType() );
        notificationDto.status( notification.getStatus() );
        notificationDto.sentAt( notification.getSentAt() );

        return notificationDto.build();
    }

    @Override
    public List<NotificationDto> toDtoList(List<Notification> notifications) {
        if ( notifications == null ) {
            return null;
        }

        List<NotificationDto> list = new ArrayList<NotificationDto>( notifications.size() );
        for ( Notification notification : notifications ) {
            list.add( toDto( notification ) );
        }

        return list;
    }
}
