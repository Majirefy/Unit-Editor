package org.augix.ue.ui;

import javafx.scene.control.TextField;

/**
 * Created by Majirefy on 4/25/15.
 */
public class NumericTextField extends TextField {
    @Override
    public void replaceText(int start, int end, String text) {
        String oldValue = getText();
        if (!text.matches("[A-Za-z]") && !text.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            super.replaceText(start, end, text);
        }
        if (getText().length() > 25) {
            setText(oldValue);
        }
    }

    @Override
    public void replaceSelection(String replacement) {
        String oldValue = getText();
        if (!replacement.matches("[A-Za-z]") && !replacement.matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")) {
            super.replaceSelection(replacement);
        }
        if (getText().length() > 25) {
            setText(oldValue);
        }
    }
}
