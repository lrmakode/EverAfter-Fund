/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.weddinggiftlisting;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AlternateRowColorRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) { // Apply colors only if the row is not selected
            if (row % 2 == 0) {
                cell.setBackground(new Color(230, 240, 255)); // Light blue for even rows
            } else {
                cell.setBackground(Color.WHITE); // White for odd rows
            }
        }
        return cell;
    }
}