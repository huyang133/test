package com.example.myapp.slice;

import com.example.myapp.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.window.dialog.ToastDialog;

public class RegisterAbilitySlice extends AbilitySlice {
    Button button_zhuce;
    Text name_zhuce,password_zhuce,password_queren;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_register);
        button_zhuce=findComponentById(ResourceTable.Id_btnzc);
        name_zhuce=findComponentById(ResourceTable.Id_tfyhm);
        password_zhuce=findComponentById(ResourceTable.Id_tfmm);
        password_queren=findComponentById(ResourceTable.Id_tfyzchm);
        button_zhuce.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {

                String name =name_zhuce.getText().toString().trim();
                String password = password_zhuce.getText().toString().trim();
                String queren = password_queren.getText().toString().trim();

                if(!name.equals(null) && !name.equals("") && !password.equals(queren)){
                    new ToastDialog(RegisterAbilitySlice.this).setText("密码不一致，请重新尝试！").show();
                }else if (button_zhuce!=null && !name.equals(null)&& !name.equals("") && !password.equals(null) && !password.equals("") &&  password.equals(queren)){
                    new ToastDialog(RegisterAbilitySlice.this).setText("注册成功！").show();
                    present(new LoginAbilitySlice(),new Intent());
                }else{
                    new ToastDialog(RegisterAbilitySlice.this).setText("请输入完整信息！").show();
                }
            }
        });


    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
