package common;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtonRenderer extends DefaultTableCellRenderer {

    private JButton button;

    public ButtonRenderer(String text) {
        button = new JButton(text);
        setOpaque(true); // Make sure the button is rendered properly
    }

    @Override
    public JButton getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
}
