package io.madeformaid.affiliation.domain.shop.service

import affiliation.Shop.GetShopNamesRequest
import affiliation.Shop.GetShopNamesResponse
import affiliation.Shop.ShopNameInfo
import affiliation.ShopServiceGrpcKt
import io.madeformaid.affiliation.domain.shop.repository.ShopRepository
import org.springframework.grpc.server.service.GrpcService

@GrpcService
class ShopGrpcService(
    private val shopRepository: ShopRepository
) : ShopServiceGrpcKt.ShopServiceCoroutineImplBase() {
    override suspend fun getShopNames(
        request: GetShopNamesRequest
    ) : GetShopNamesResponse {
        val shopNames = shopRepository.findByIdIn(request.shopIdsList)
            .map { shop ->
                ShopNameInfo.newBuilder()
                    .setShopId(shop.id)
                    .setShopName(shop.name)
                    .build()
            }

        return GetShopNamesResponse.newBuilder()
            .addAllShopNames(shopNames)
            .build()
    }
}
