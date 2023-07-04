package com.example.myapp.slice;

import com.example.myapp.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.window.dialog.ToastDialog;

import java.text.BreakIterator;


public class LoginAbilitySlice extends AbilitySlice {
    private Button button1;
    private Button button2;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_login);
        button2 = findComponentById(ResourceTable.Id_btn2);
        button2.setClickedListener(listener->present(new RegisterAbilitySlice(),new Intent()));
        button1= findComponentById(ResourceTable.Id_btn);
//        button1.setClickedListener();
        button1.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                Text text_name=findComponentById(ResourceTable.Id_textf1);
                Text text_password=findComponentById(ResourceTable.Id_textf2);

                String name = text_name.getText().toString().trim();
                String password = text_password.getText().toString().trim();

                if ( name.equals("admin") && password.equals("123456")) {

                    present(new MainAbilitySlice(), new Intent());
                    new ToastDialog(LoginAbilitySlice.this).setText("登录成功").show();
                } else {
                    new ToastDialog(LoginAbilitySlice.this).setText("用户名或密码有误请重新输入").show();
                }
            }


        });
    }

}
