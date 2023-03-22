package com.screenshotToDocument.Configurations;

import com.screenshotToDocument.Activity.impl.PerformActionImpl;
import com.screenshotToDocument.Components.impl.ScreenShotHandler;
import com.screenshotToDocument.Components.impl.Utilities;
import com.screenshotToDocument.Components.impl.WordDoumentWriter;
import com.screenshotToDocument.GUI.impl.UIComponentsImpl;
import com.screenshotToDocument.Session.impl.SessionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanProvider {

    @Bean(name = "utility")
    public Utilities getUtility(){
        return new Utilities();
    }

    @Bean(name = "screenShotHandler")
    public ScreenShotHandler getScreenShotHandler(){
        return new ScreenShotHandler();
    }

    @Bean(name = "performActionImpl")
    public PerformActionImpl getPerformActionImpl(){
        return new PerformActionImpl();
    }

    @Bean(name = "uiComponents")
    public UIComponentsImpl getUIComponentsImpl(){
        return new UIComponentsImpl();
    }

    @Bean(name = "sessionServiceImpl")
    public SessionServiceImpl getSessionServiceImpl(){
        return new SessionServiceImpl();
    }

    @Bean(name = "wordDocumentWriter")
    public WordDoumentWriter getWordDocumentWriter(){
        return new WordDoumentWriter();
    }

}
