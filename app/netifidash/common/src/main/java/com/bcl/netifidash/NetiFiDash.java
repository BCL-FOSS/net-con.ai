package com.bcl.netifidash;

import static com.codename1.ui.CN.*;
import com.codename1.system.Lifecycle;
import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.io.*;
import com.codename1.ui.plaf.*;
import com.codename1.ui.util.Resources;
import com.bcl.netifidash.util.BackendUtil;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose
 * of building native mobile applications using Java.
 */
public class NetiFiDash extends Lifecycle {
    @Override
    public void runApp() {
        Form hi = new Form("Hi World", BoxLayout.y());
        Button helloButton = new Button("Hello World");
        hi.add(helloButton);
        helloButton.addActionListener(e -> hello());
        hi.getToolbar().addMaterialCommandToSideMenu("Hello Command",
        FontImage.MATERIAL_CHECK, 4, e -> hello());
        hi.show();
    }

    private void hello() {
        Dialog.show("Hello Codename One", "Welcome to Codename One", "OK", null);
    }

    private void auth(String name, String pass){
        BackendUtil backendUtil = new BackendUtil();
        backendUtil.auth(name, pass);
    }

}
