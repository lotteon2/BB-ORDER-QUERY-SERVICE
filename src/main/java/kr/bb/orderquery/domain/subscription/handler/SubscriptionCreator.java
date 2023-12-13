package kr.bb.orderquery.domain.subscription.handler;

import kr.bb.orderquery.client.dto.ProductInfoDto;
import kr.bb.orderquery.domain.subscription.dto.SubscriptionCreateDto;
import kr.bb.orderquery.domain.subscription.entity.Subscription;
import kr.bb.orderquery.domain.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionCreator {
    private final SubscriptionRepository subscriptionRepository;

    public Subscription create(ProductInfoDto productInfo, SubscriptionCreateDto subscriptionCreateDto) {
        Subscription subscription = Subscription.builder()
                .subscriptionId(subscriptionCreateDto.getSubscriptionId())
                .subscriptionCode(subscriptionCreateDto.getSubscriptionCode())
                .userId(subscriptionCreateDto.getUserId())
                .storeId(productInfo.getStoreId())
                .productThumbnail(productInfo.getProductThumbnail())
                .productName(productInfo.getProductName())
                .unitPrice(productInfo.getUnitPrice())
                .quantity(subscriptionCreateDto.getQuantity())
                .ordererName(subscriptionCreateDto.getOrdererName())
                .ordererPhoneNumber(subscriptionCreateDto.getOrdererPhoneNumber())
                .ordererEmail(subscriptionCreateDto.getOrdererEmail())
                .recipientName(subscriptionCreateDto.getRecipientName())
                .recipientPhoneNumber(subscriptionCreateDto.getRecipientPhoneNumber())
                .deliveryAddress(subscriptionCreateDto.getDeliveryAddress())
                .paymentDateTime(subscriptionCreateDto.getPaymentDateTime())
                .nextDeliveryDate(subscriptionCreateDto.getNextDeliveryDate().toString())
                .nextPaymentDate(subscriptionCreateDto.getNextPaymentDate())
                .totalOrderPrice(subscriptionCreateDto.getTotalOrderPrice())
                .totalDiscountPrice(subscriptionCreateDto.getTotalDiscountPrice())
                .deliveryPrice(subscriptionCreateDto.getDeliveryPrice())
                .actualPrice(subscriptionCreateDto.getActualPrice())
                .reviewStatus(subscriptionCreateDto.getReviewStatus())
                .cardStatus(subscriptionCreateDto.getCardStatus())
                .isUnsubscribed(subscriptionCreateDto.getIsUnsubscribed())
                .build();

        return subscriptionRepository.save(subscription);
    }
}