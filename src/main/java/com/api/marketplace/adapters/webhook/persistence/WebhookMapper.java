package com.api.marketplace.adapters.webhook.persistence;

import com.api.marketplace.domain.webhook.model.Webhook;
import org.springframework.stereotype.Component;

@Component
public class WebhookMapper {
    public Webhook toDomain(WebhookJpaEntity jpaEntity){
        Webhook domain = new Webhook(
                jpaEntity.getId(),
                jpaEntity.getCallbackUrl()
        );

        jpaEntity.getStoreIds().forEach(domain::addStoreId);

        return domain;
    }

    public WebhookJpaEntity toJpa(Webhook domain){
        return new WebhookJpaEntity(
                domain.getId(),
                domain.getCallbackUrl(),
                domain.getStoreIds()
        );
    }
}
