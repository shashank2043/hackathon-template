package com.hackathon.notification.mapper;

import com.hackathon.notification.dto.NotificationDto;
import com.hackathon.notification.entity.Notification;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-02T21:29:14+0530",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.100.v20260624-0231, environment: Java 21.0.11 (Eclipse Adoptium)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public NotificationDto toDto(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        NotificationDto.NotificationDtoBuilder notificationDto = NotificationDto.builder();

        notificationDto.body( notification.getBody() );
        notificationDto.id( notification.getId() );
        notificationDto.recipient( notification.getRecipient() );
        notificationDto.sentAt( notification.getSentAt() );
        notificationDto.status( notification.getStatus() );
        notificationDto.subject( notification.getSubject() );
        notificationDto.type( notification.getType() );

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
