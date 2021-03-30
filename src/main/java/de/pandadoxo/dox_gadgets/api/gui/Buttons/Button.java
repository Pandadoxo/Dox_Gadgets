package de.pandadoxo.dox_gadgets.api.gui.Buttons;


import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiMenu;

import java.util.ArrayList;
import java.util.List;

public abstract class Button {

    private GuiMenu menu;
    private int slot;

    public GuiMenu getMenu() {
        return menu;
    }

    public int getSlot() {
        return slot;
    }

    public static List<Button> buttonList = new ArrayList<>();

    public Button(GuiMenu menu, int slot) {
        buttonList.add(this);
    }

    public void destroy() {
        buttonList.remove(this);
    }
}
