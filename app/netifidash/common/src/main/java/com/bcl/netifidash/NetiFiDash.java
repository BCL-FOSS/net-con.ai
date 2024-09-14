package com.bcl.netifidash;

import static com.codename1.ui.CN.*;

import com.codename1.components.ToastBar;
import com.codename1.system.Lifecycle;
import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.io.*;
import com.codename1.ui.plaf.*;
import com.codename1.ui.util.Resources;
import com.bcl.netifidash.util.BackendUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose
 * of building native mobile applications using Java.
 */
public class NetiFiDash extends Lifecycle {
    private Label connectionLabel;
    @Override
    public void runApp() {
        Form hi = new Form("Hi World", BoxLayout.y());
        Button helloButton = new Button("Hello World");
        Button socketTest = new Button("Send message to backend");
        TextField eventType = new TextField("Enter Event Type");
        TextField eventMessage = new TextField("Enter Event Message");
        TextField socketHost = new TextField("Enter Socket IP/Hostname");
        TextField socketPort = new TextField("Enter Socket Port");

        hi.add(helloButton);
        hi.add(socketTest);
        hi.add(eventType);
        hi.add(eventMessage);
        hi.add(socketHost);
        hi.add(socketPort);
        helloButton.addActionListener(e -> hello());
        socketTest.addActionListener(e -> auth());

        hi.getToolbar().addMaterialCommandToSideMenu();
        hi.getToolbar().addMaterialCommandToSideMenu("Hello Command",
        FontImage.MATERIAL_CHECK, 4, e -> hello());
        hi.show();
    }

    private void hello() {
        Dialog.show("Hello Codename One", "Welcome to Codename One", "OK", null);
    }

    private void auth(){
        BackendUtil backendUtil = new BackendUtil();
        backendUtil.auth();
    }



}
