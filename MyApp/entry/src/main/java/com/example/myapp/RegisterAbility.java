package com.example.myapp;

import com.example.myapp.slice.RegisterAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class RegisterAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(RegisterAbilitySlice.class.getName());
    }
}
