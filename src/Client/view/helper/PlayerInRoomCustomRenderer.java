package Client.view.helper;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import Client.model.PlayerInGame;
import Shared.constant.Avatar;

// https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
public class PlayerInRoomCustomRenderer extends JLabel implements ListCellRenderer<PlayerInGame> {

    @Override
    public Component getListCellRendererComponent(JList<? extends PlayerInGame> jlist, PlayerInGame p, int index,
            boolean isSelected, boolean cellHasFocus) {
        ImageIcon imageIcon = new ImageIcon(Avatar.PATH + p.getAvatar());
        setIcon(imageIcon);
        setText(p.getNameId());

        if (isSelected) {
            setBackground(jlist.getSelectionBackground());
            setForeground(jlist.getSelectionForeground());
        } else {
            setBackground(jlist.getBackground());
            setForeground(jlist.getForeground());
        }

        return this;
    }

}
