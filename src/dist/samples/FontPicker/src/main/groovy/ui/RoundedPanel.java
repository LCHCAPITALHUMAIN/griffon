/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package groovy.ui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
/**
 * Created by IntelliJ IDEA.
 * User: Danno.Ferrin
 * Date: May 8, 2008
 * Time: 6:08:55 PM
 */
class RoundedPanel extends JPanel {

    public RoundedPanel() {
        setOpaque(false);
		setLayout(new MigLayout());
    }

    public boolean isOptimizedDrawingEnabled() {
        return false;
    }


    protected void paintComponent(Graphics g) {
        Object oldhint = ((Graphics2D)g).getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(java.awt.Color.WHITE);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, oldhint);
    }


}
