/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wilsoncys.gamer_pro.main;

import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.wilsoncys.gamer_pro.backend.Control;

/**
 *
 * @author Jonwil
 */
public class Main {
    public static void main(String[] args) {
        try {
//            FlatGradiantoMidnightBlueIJTheme.setup();
//            FlatLightOwlIJTheme.setup();
//            FlatHighContrastIJTheme.setup();
//              FlatGradiantoDeepOceanIJTheme.setup();
//              FlatDarkPurpleIJTheme.setup();
                                                          FlatCobalt2IJTheme.setup();
//            UIManager.setLookAndFeel(new FlatGradiantoMidnightBlueIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        new Control();
    
    }
}
