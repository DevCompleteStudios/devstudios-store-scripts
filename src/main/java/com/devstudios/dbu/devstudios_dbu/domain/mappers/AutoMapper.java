package com.devstudios.dbu.devstudios_dbu.domain.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.devstudios.dbu.devstudios_dbu.application.dtos.User.UserPreviewDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.purchases.PurchaseDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.scripts.ScriptDto;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IPurchase;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IUserPreview;
import com.devstudios.dbu.devstudios_dbu.domain.entities.PurchasesEntity;
import com.devstudios.dbu.devstudios_dbu.domain.entities.ScriptEntity;
import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;


@Component
public class AutoMapper {

    public IScript scriptEntityToScript(ScriptEntity scriptEntity) {
        List<IPurchase> purchases = scriptEntity.getPurchases().stream().map( p -> purchaseEntityToPurchase(p) ).toList();
        IScript script = new ScriptDto(
            scriptEntity.getDescription(),
            scriptEntity.getName(),
            scriptEntity.getUrl(),
            scriptEntity.getImage(),
            scriptEntity.getPrice(),
            scriptEntity.getIsActive(),
            purchases
        );

        return script;
    }

    public IPurchase purchaseEntityToPurchase( PurchasesEntity purchaseEntity ){
        IPurchase purchase = new PurchaseDto(
            userEntityToUserPreview(purchaseEntity.getUser()),
            purchaseEntity.getKey(),
            purchaseEntity.getStatus(),
            purchaseEntity.getTransactionId(),
            purchaseEntity.getIsActive()
        );

        return purchase;
    }

    public IUserPreview userEntityToUserPreview( UserEntity userEntity ){
        IUserPreview user = new UserPreviewDto(
            userEntity.getId(),
            userEntity.getEmail(),
            userEntity.getRoles(),
            userEntity.getIsActive()
        );

        return user;
    }


}
